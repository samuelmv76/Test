import { F } from '@angular/cdk/keycodes';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-formulario-registro',
  imports: [ReactiveFormsModule],
  templateUrl: './formulario-registro.html',
  styleUrl: './formulario-registro.css'
})
export class FormularioRegistro {
  
  
  formulario: FormGroup;

  constructor(private fb: FormBuilder) {

    this.formulario = this.fb.group({
      nombre: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(10)]],
      email: ['', [Validators.required, Validators.email, Validators.minLength(3)]],
      edad: ['', [Validators.required, Validators.min(0)]],
    });

  }

  mostrar(){
      if(this.formulario.invalid){
        console.log("El formulario contiene errores.");
      }else {
        console.log(this.formulario.value);
      }
  }

  resetear(){
    this.formulario.reset({
      nombre: '',
      email: ''
    });
  }


}
