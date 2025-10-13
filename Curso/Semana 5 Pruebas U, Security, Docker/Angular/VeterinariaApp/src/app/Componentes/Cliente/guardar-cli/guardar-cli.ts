import { Component, QueryList, ViewChild, ViewChildren } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Cliente } from '../../../Entidades/Cliente';
import { ServiceWS } from '../../../Service/service-ws';
import Swal from 'sweetalert2';
import { z } from 'zod';
import { CustomInput } from '../../Compartidos/custom-input/custom-input';
import { FormValidation } from '../../../Interfaces/FormValidation';

interface FormValid {
  nombre: FormValidation;
  direccion: FormValidation;
  contacto: FormValidation;
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
  contacto:{
    id: "contacto",
    isValid: false,
    schema: z.string().regex(/^\d{10}$/, { message: 'El contacto debe tener exactamente 10 dígitos numéricos' })
  }
}

@Component({
  selector: 'app-guardar-cli',
  imports: [FormsModule, CustomInput],
  templateUrl: './guardar-cli.html',
  styleUrl: './guardar-cli.css'
})
export class GuardarCli {

  constructor(private service: ServiceWS){}

  @ViewChildren('nombreInput, contactoInput, direccionInput') inputsString!: QueryList<CustomInput>;
    
  cliente: Cliente = new Cliente()
  form = form;

  handleValidation(event: { id: string, valid: boolean; }) {
    if(["nombre", "direccion", "contacto"].includes(event.id)) this.form[event.id as keyof FormValid].isValid = event.valid;
  }

  validateForm() {
    this.inputsString.forEach(input => input.validateValue('string'));

    const isFormValid = (): boolean => {
      return Object.values(form).every(field => field.isValid);
    };

    return isFormValid();
  }

  guardarCliente() {

    if (!this.validateForm()) {
      Swal.fire({
        icon: "warning",
        title: "Campos incompletos",
        html: "Todos los campos con <span style='color: red;'>*</span> son obligatorios",
        confirmButtonText: "OK"
      })
      return
    }

    this.service.guardarClienteWS(this.cliente).subscribe({
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
