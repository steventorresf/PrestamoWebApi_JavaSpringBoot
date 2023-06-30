package com.prestamofacilweb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.prestamofacilweb.exceptions.models.BadRequestException;
import com.prestamofacilweb.exceptions.models.UnauthorizedException;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ExceptionResponse> handleUnauthorizedException(UnauthorizedException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse("Acceso denegado", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponseErrors> handleBadRequestException(BadRequestException ex,
            WebRequest request) {
        String[] splitMessages = ex.getMessage().split("\\|");
        ExceptionResponseErrors response = new ExceptionResponseErrors("Error",
                "Revise los datos de entrada y vuelva a ejecutar el servicio.",
                splitMessages);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse("Error",
                "Error interno del servidor, por favor contacte a su administrador");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
