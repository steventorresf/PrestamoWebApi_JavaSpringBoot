package com.prestamofacilweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.prestamofacilweb.dto.exceptions.BadRequestException;
import com.prestamofacilweb.dto.exceptions.ExceptionResponse;
import com.prestamofacilweb.dto.exceptions.ExceptionResponseErrors;
import com.prestamofacilweb.dto.exceptions.UnauthorizedException;
import com.prestamofacilweb.service.IFileTxtService;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private IFileTxtService fileTxtService;

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ExceptionResponse> handleUnauthorizedException(UnauthorizedException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse("Acceso denegado", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponseErrors> handleBadRequestException(BadRequestException ex,
            WebRequest request) {
        String[] splitMessages = ex.getMessage().split("\\|");
        ExceptionResponseErrors response = new ExceptionResponseErrors("Parametros incorrectos",
                "Revise los datos de entrada y vuelva a ejecutar el servicio.",
                splitMessages);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request) {
        fileTxtService.FileLogError(ex);
        ExceptionResponse response = new ExceptionResponse("Error",
                "Error interno del servidor, por favor contacte a su administrador");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
