package br.com.nobre.transaction_api.core.exception.controller;

import br.com.nobre.transaction_api.core.exception.model.PayloadException;
import br.com.nobre.transaction_api.core.exception.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PayloadException.class)
    public ResponseEntity<ErrorDto> handlerPayloadException(PayloadException ex) {
        return new ResponseEntity<>(new ErrorDto(ex.getMessage(), ex.getStatusCode()), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDto> handlerPayloadIsNullException(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(new ErrorDto("Necessário passar um corpo na requisição no foramto de json",
                HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

}
