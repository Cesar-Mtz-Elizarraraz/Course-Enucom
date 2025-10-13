import { Component, QueryList, ViewChildren } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CustomInput } from '../../Compartidos/custom-input/custom-input';
import { FormValidation } from '../../../Interfaces/FormValidation';
import { z } from 'zod';
import { ServiceWS } from '../../../Service/service-ws';
import { Responsable } from '../../../Entidades/Responsable';
import Swal from 'sweetalert2';
import { CustomSelect } from '../../Compartidos/custom-select/custom-select';

interface FormValid {
  nombre: FormValidation;
  contacto: FormValidation;
  veterinariaId: FormValidation;
}

const form: FormValid = {
  nombre: {
    id: "nombre",
    isValid: false,
    schema: z.string().min(1, 'El nombre es obligatorio').max(50, "Máximo 50 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/, 'Solo se pueden contener letras y espacios')
  },
  contacto:{
    id: "contacto",
    isValid: false,
    schema: z.string().regex(/^\d{10}$/, { message: 'El contacto debe tener exactamente 10 dígitos numéricos' })
  },
  veterinariaId: {
    id: "veterinariaId",
    isValid: false,
    schema: z.number().refine((val) => Number.isInteger(val) && val > 0, { message: "La veterinaria es obligatoria"})
  },
}

@Component({
  selector: 'app-guardar-r',
  imports: [FormsModule, CustomInput, CustomSelect],
  templateUrl: './guardar-r.html',
  styleUrl: './guardar-r.css'
})
export class GuardarR {
  constructor(private service: ServiceWS){}

  @ViewChildren('nombreInput, contactoInput') inputsString!: QueryList<CustomInput>;
  @ViewChildren('veterinariaIdSelect') selectsNumber!: QueryList<CustomInput>;
    
  responsable: Responsable = new Responsable()
  form = form
  veterinariaOptions: {label: string; value: string;}[] =  []

  ngOnInit(): void {
    this.listarVeterinarias()
  }

  listarVeterinarias() {
    this.service.listarVeterinariaWS().subscribe({
      next: data => {
        const options = data.map(vet => ({
          label: vet.nombre,
          value: vet.idVeterinaria.toString()
        }));
        this.veterinariaOptions = options;
      },
      error: err => {
        console.error('Error al listar veterinarias:', err);
      }
    });
  }

  handleValidation(event: { id: string, valid: boolean; }) {
    if(["nombre", "contacto", "veterinariaId"].includes(event.id)) this.form[event.id as keyof FormValid].isValid = event.valid;
  }

  validateForm() {
    this.inputsString.forEach(input => input.validateValue('string'));
    this.selectsNumber.forEach(select => select.validateValue('number'));

    const isFormValid = (): boolean => {
      return Object.values(form).every(field => field.isValid);
    };

    return isFormValid();
  }

  guardarResponsable() {

    if (!this.validateForm()) {
      Swal.fire({
        icon: "warning",
        title: "Campos incompletos",
        html: "Todos los campos con <span style='color: red;'>*</span> son obligatorios",
        confirmButtonText: "OK"
      })
      return
    }

    this.service.guardarResponsableWS(this.responsable).subscribe({
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
