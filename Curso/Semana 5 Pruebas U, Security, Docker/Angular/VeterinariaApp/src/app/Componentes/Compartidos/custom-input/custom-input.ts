import { Component, EventEmitter, forwardRef, Input, Output } from '@angular/core';
import { ControlValueAccessor, NG_VALUE_ACCESSOR } from '@angular/forms';
import { ZodSchema } from 'zod';

@Component({
  selector: 'app-custom-input',
  imports: [],
  templateUrl: './custom-input.html',
  styleUrl: './custom-input.css',
  providers: [
    {
      // Con NG_VALUE_ACCESOR Angular entiende que este componente actuará como un "ControlValueAccessor"
      provide: NG_VALUE_ACCESSOR,
      // Indicar que se debe usar una instancia del mismo componente (CustomInput)
      // El forwardRef se usa porque la clase aún no está completamente definida en este punto
      useExisting: forwardRef(() => CustomInput),
      // Permitir que haya múltiples proveedores para NG_VALUE_ACCESSOR
      // Esto es necesario para no sobrescribir los value accessors nativos (como input, select, etc.)
      multi: true
    }
  ]
})
export class CustomInput implements ControlValueAccessor {
  @Input() type: string = 'text'
  @Input() multi: boolean = false
  @Input() name: string = ''
  @Input() id: string = ''
  @Input() required: boolean = false
  @Input() placeholder: string = ''
  @Input() label: string = ''
  @Input() minLength: number = 1
  @Input() maxLength: number = 255
  @Input() uppercase: boolean = false
  @Input() disabled: boolean = false

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
 
  handleInput(event: any) {
    let newValue = event.target.value
    newValue = typeof newValue === 'string' && this.uppercase ? newValue.toUpperCase() : newValue
    this.value = newValue
    this.onChange(newValue); // comunica el cambio

    if (this.schema) {
      const result = this.schema.safeParse(typeof newValue === 'string' ? newValue.trim() : newValue);
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

  handleBlur() {
    this.onTouched(); // marca como "tocado"
  }

  validateValue(valueType?: 'number' | 'string'){
    let newValue: string | number;
      
    newValue = valueType === 'number' ? Number(this.value) : this.value.toString().trim()

    if (this.schema) {
      const result = this.schema.safeParse(newValue);
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
