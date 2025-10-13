package com.mx.Operacion.Util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;

import java.util.HashMap;

//Marca esta clase como un manejador global de excepciones para todos los controladores REST
@RestControllerAdvice
public class ValidationUtil {

 // Indica que este método manejará excepciones del tipo MethodArgumentNotValidException,
 // que se lanza automáticamente cuando falla una validación con @Valid
 @ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<HashMap<String, String>> manejarErroresDeValidacion(MethodArgumentNotValidException ex) {

     HashMap<String, String> errores = new HashMap<>();

     // Recorrer todos los errores de validación encontrados
     ex.getBindingResult().getAllErrors().forEach(error -> {
         
         // Convertir el error genérico a un FieldError para saber el nombre del campo
         String campo = ((FieldError) error).getField();

         // Obtener el mensaje de error personalizado definido en la anotación
         String mensaje = error.getDefaultMessage();

         // Guardar el nombre del campo y su mensaje correspondiente en el HashMap
         errores.put(campo, mensaje);
     });

     // Devolvemos una respuesta con los errores y el código de estado HTTP 400 (Bad Request)
     return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
 }
}

