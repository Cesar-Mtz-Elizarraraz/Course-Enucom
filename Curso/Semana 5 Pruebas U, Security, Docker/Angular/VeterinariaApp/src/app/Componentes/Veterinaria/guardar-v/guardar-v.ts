import { Component, QueryList, ViewChild, ViewChildren } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Veterinaria } from '../../../Entidades/Veterinaria';
import { ServiceWS } from '../../../Service/service-ws';
import Swal from 'sweetalert2';
import { z } from 'zod';
import { CustomInput } from '../../Compartidos/custom-input/custom-input';
import { FormValidation } from '../../../Interfaces/FormValidation';

interface FormValid {
  nombre: FormValidation;
  direccion: FormValidation;
  telefono: FormValidation;
}

const form: FormValid = {
  nombre: {
    id: "nombre",
    isValid: false,
    schema: z.string().min(1, 'El nombre es obligatorio').max(50, "Máximo 50 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/, 'Solo se pueden contener letras y espacios')
  },
  direccion: {
    id: "direccion",
    isValid: false,
    schema: z.string().min(1, 'La descripción es obligatoria').max(100, "Máximo 100 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9)(.,"':\s-]+$/, `Solo se pueden contener letras, números, espacios y caracteres especiales como (-.,:"')`)
  },
  telefono:{
    id: "telefono",
    isValid: false,
    schema: z.string().regex(/^\d{10}$/, { message: 'El teléfono debe tener exactamente 10 dígitos numéricos' })
  }
}

@Component({
  selector: 'app-guardar-v',
  imports: [FormsModule, CustomInput],
  templateUrl: './guardar-v.html',
  styleUrl: './guardar-v.css'
})
export class GuardarV {

  constructor(private service: ServiceWS){}

  @ViewChildren('nombreInput, telefonoInput, direccionInput') inputsString!: QueryList<CustomInput>;
    
  veterinaria: Veterinaria = new Veterinaria()
  form = form;

  handleValidation(event: { id: string, valid: boolean; }) {
    if(["nombre", "direccion", "telefono"].includes(event.id)) this.form[event.id as keyof FormValid].isValid = event.valid;
  }

  validateForm() {
    this.inputsString.forEach(input => input.validateValue('string'));

    const isFormValid = (): boolean => {
      return Object.values(form).every(field => field.isValid);
    };

    return isFormValid();
  }

  guardarVeterinaria() {

    if (!this.validateForm()) {
      Swal.fire({
        icon: "warning",
        title: "Campos incompletos",
        html: "Todos los campos con <span style='color: red;'>*</span> son obligatorios",
        confirmButtonText: "OK"
      })
      return
    }

    this.service.guardarVeterinariaWS(this.veterinaria).subscribe({
      next: data => {
        Swal.fire({
          icon : "success",
          title: "GUARDAR",
          text: data,
          confirmButtonText: "OK"
        }).then((result) => {
          if (result.isConfirmed) {
            window.location.reload();
          }
        })
      },
      error: err => {
        Swal.fire({
          icon : "error",
          title: "GUARDAR",
          text: err.error,
          confirmButtonText: "OK"
        })
        console.error(err)
        }
    })
  }
}
