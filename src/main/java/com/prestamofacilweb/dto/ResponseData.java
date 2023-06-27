package com.prestamofacilweb.dto;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseData<T> {
    private Boolean Success;
    private HttpStatus StatusCode;
    private T Data;
    private String Message;

    public ResponseData(T data) {
        this.Success = true;
        this.StatusCode = HttpStatus.OK;
        this.Data = data;
    }

    public ResponseData(T data, String message) {
        this.Success = true;
        this.StatusCode = HttpStatus.OK;
        this.Data = data;
        this.Message = message;
    }

    public ResponseData(HttpStatus statusCode, String message) {
        this.Success = false;
        this.StatusCode = statusCode;
        this.Message = message;
    }
}
