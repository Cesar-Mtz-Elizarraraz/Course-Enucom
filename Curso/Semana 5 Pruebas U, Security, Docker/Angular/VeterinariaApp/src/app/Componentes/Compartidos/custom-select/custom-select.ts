import { Component, EventEmitter, forwardRef, Input, Output } from '@angular/core';
import { ControlValueAccessor, NG_VALUE_ACCESSOR } from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { ZodSchema } from 'zod';

@Component({
  selector: 'app-custom-select',
  imports: [FontAwesomeModule],
  templateUrl: './custom-select.html',
  styleUrl: './custom-select.css',
  providers: [
    {
      // Con NG_VALUE_ACCESOR Angular entiende que este componente actuará como un "ControlValueAccessor"
      provide: NG_VALUE_ACCESSOR,
      // Indicar que se debe usar una instancia del mismo componente (CustomInput)
      // El forwardRef se usa porque la clase aún no está completamente definida en este punto
      useExisting: forwardRef(() => CustomSelect),
      // Permitir que haya múltiples proveedores para NG_VALUE_ACCESSOR
      // Esto es necesario para no sobrescribir los value accessors nativos (como input, select, etc.)
      multi: true
    }
  ]
})
export class CustomSelect implements ControlValueAccessor {
  @Input() options: {label: string, value: string}[] = [];
  @Input() name: string = ''
  @Input() id: string = ''
  @Input() required: boolean = false
  @Input() label: string = ''
  @Input() defaultOption: string = '- Selecciona una opción -'
  @Input() defaultEmpty: string = 'Sin opciones'
  @Input() disabled: boolean = false
  @Input() iconRight: string = ''
  @Input() iconLeft: string = ''

  @Input() schema?: ZodSchema<any>; // Esquema zod para validar
  @Output() validationStatus = new EventEmitter<{ id: string, valid: boolean; errors?: string[] | null }>();

  value: any = '';
  errors: string[] | null = null;

  onChange = (_: any) => {};
  onTouched = () => {};
  
  writeValue(value: any): void {
    this.value = value;
  }

  registerOnChange(fn: any): void {
    this.onChange = fn;
  }

  registerOnTouched(fn: any): void {
    this.onTouched = fn;
  }

  setDisabledState?(isDisabled: boolean): void {
  }

  handleSelected(value: string) {
    let newValue: number | string = value.trim()
    newValue = isNaN(Number(newValue)) ? newValue : Number(newValue)
    this.value = newValue
    this.onChange(newValue); // comunica el cambio

    this.doValidate(newValue)
  }

  validateValue(valueType?: 'number' | 'string'){
    let newValue: string | number;
      
    newValue = valueType === 'number' ? Number(this.value) : this.value.toString().trim()

    this.doValidate(newValue)
  }

  doValidate(value: any){
    if (this.schema) {
      const result = this.schema.safeParse(value);
      if (!result.success) {
        this.errors = result.error.errors.map(e => e.message);
        this.validationStatus.emit({ id: this.id, valid: false });
        // this.validationStatus.emit({ id: this.id, valid: false, errors: this.errors });
      } else {
        this.errors = null;
        this.validationStatus.emit({ id: this.id, valid: true });
      }
    }
  }

}
