import { Component, Input, QueryList, ViewChildren } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CustomInput } from '../../Compartidos/custom-input/custom-input';
import { CustomSelect } from '../../Compartidos/custom-select/custom-select';
import { FormValidation } from '../../../Interfaces/FormValidation';
import { z } from 'zod';
import { ServiceWS } from '../../../Service/service-ws';
import { Mascota } from '../../../Entidades/Mascota';
import Swal from 'sweetalert2';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ResponsableVeterinaria } from '../../../Entidades/Responsable';

interface Option {
  label: string; 
  value: string;
}

interface FormValid {
  nombre: FormValidation;
  raza: FormValidation;
  edad: FormValidation;
  razonCita: FormValidation;
  clienteId: FormValidation;
  responsableId: FormValidation;
  //veterinariaId: FormValidation;
}

const form: FormValid = {
  nombre: {
    id: "nombre",
    isValid: false,
    schema: z.string().min(1, 'El nombre es obligatorio').max(15, "Máximo 15 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/, 'Solo se pueden contener letras y espacios')
  },
  raza: {
    id: "raza",
    isValid: false,
    schema: z.string().min(1, 'El nombre es obligatorio').max(15, "Máximo 15 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/, 'Solo se pueden contener letras y espacios')
  },
  edad:{
    id: "edad",
    isValid: false,
    schema: z.string().min(1, 'La edad es obligatoria').regex(/^[0-9]{1,2}$/, { message: 'Solo cantidades positivas sin decimales' }).refine((val) => Number(val) <= 20, { message: "Edad máxima de 20 años"})
  },
  razonCita: {
    id: "razonCita",
    isValid: false,
    schema: z.string().min(1, 'La razón de la cita es obligatoria').max(100, "Máximo 100 caracteres").regex(/^[A-Za-zÁÉÍÓÚáéíóúÑñ0-9)(.,"':\s-]+$/, `Solo se pueden contener letras, números, espacios y caracteres especiales como (-.,:"')`)
  },
  clienteId: {
    id: "clienteId",
    isValid: false,
    schema: z.number().refine((val) => Number.isInteger(val) && val > 0, { message: "El cliente es obligatorio"})
  },
  responsableId: {
    id: "responsableId",
    isValid: false,
    schema: z.number().refine((val) => Number.isInteger(val) && val > 0, { message: "El responsable es obligatorio"})
  },
  /*veterinariaId: {
    id: "veterinariaId",
    isValid: false,
    schema: z.number().refine((val) => Number.isInteger(val) && val > 0, { message: "La veterinaria es obligatoria"})
  },*/
}

@Component({
  selector: 'app-editar-m',
  imports: [FormsModule, FontAwesomeModule, CustomInput, CustomSelect],
  templateUrl: './editar-m.html',
  styleUrl: './editar-m.css'
})
export class EditarM {
  constructor(private service: ServiceWS){}

  @ViewChildren('nombreInput, razaInput, edadInput, razonCitaInput') inputsString!: QueryList<CustomInput>;
  @ViewChildren('clienteIdSelect, responsableIdSelect, veterinariaIdSelect') selectsNumber!: QueryList<CustomSelect>;

  @Input() mascota: Mascota = new Mascota()
  responsables: ResponsableVeterinaria[] = []
  form = form;
  clienteOptions: Option[] =  []
  responsableOptions: Option[] =  []
  veterinariaOptions: Option[] =  []

  ngOnInit(): void {
    this.listarClientes()
    this.listarResponsables()
    //this.listarVeterinarias()
  }

  listarClientes() {
    this.service.listarClienteWS().subscribe({
      next: data => {
        const options = data.map(cli => ({
          label: cli.nombre,
          value: cli.idCliente.toString()
        }));
        this.clienteOptions = options;
      },
      error: err => {
        console.error('Error al listar clientes:', err);
      }
    });
  }

  listarResponsables() {
    this.service.listarResponsableWS().subscribe({
      next: data => {
        this.responsables = data
        const options = data.map(resp => ({
          label: resp.nombre,
          value: resp.idResponsable.toString()
        }));
        this.responsableOptions = options;
      },
      error: err => {
        console.error('Error al listar responsables:', err);
      }
    });
  }

  /*listarVeterinarias() {
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
  }*/

  handleValidation(event: { id: string, valid: boolean; }) {
    if(["nombre", "raza", "edad", "razonCita", "clienteId", "responsableId", "veterinariaId"].includes(event.id)) this.form[event.id as keyof FormValid].isValid = event.valid;
  }

  validateForm() {
    this.inputsString.forEach(input => input.validateValue('string'));
    this.selectsNumber.forEach(select => select.validateValue('number'));

    const isFormValid = (): boolean => {
      return Object.values(form).every(field => field.isValid);
    };

    return isFormValid();
  }

  editarMascota() {
    const responsableVeterinaria = this.responsables.find(item => item.idResponsable === this.mascota.responsableId);
    this.mascota.veterinariaId = responsableVeterinaria?.veterinaria.idVeterinaria || 0

    if (!this.validateForm()) {
      Swal.fire({
        icon: "warning",
        title: "Campos incompletos",
        html: "Todos los campos con <span style='color: red;'>*</span> son obligatorios",
        confirmButtonText: "OK"
      })
      return
    }

    this.service.editarMascotaWS(this.mascota).subscribe({
      next: (data) => {
        Swal.fire({
          icon : "success",
          title: "EDITAR",
          text: data,
          confirmButtonText: "OK"
        }).then((result) => {
          if (result.isConfirmed) {
            window.location.reload();
          }
        });
      },
      error: (err) => {
        Swal.fire({
          icon : "error",
          title: "EDITAR",
          text: "Ocurrió un error",
          confirmButtonText: "OK"
        })
        console.error(err)
      }
    })
  }
}
