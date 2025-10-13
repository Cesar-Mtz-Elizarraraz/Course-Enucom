package com.mx.ProcesarCliente.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Para errores en @Valid en @RequestBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .collect(Collectors.toMap(
                fieldError -> fieldError.getField(), // Atributo donde sucede ele rror
                fieldError -> fieldError.getDefaultMessage(), // Mensaje del atributo
                (existing, replacement) -> existing  // En caso de múltiples errores por campo, toma el primero
            ));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}

