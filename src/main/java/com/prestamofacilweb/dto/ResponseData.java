package com.prestamofacilweb.dto;

public class ResponseData<T> {
    public Boolean Success;
    public String Message;
    public T Data;

    public ResponseData(T data) {
        this.Success = true;
        this.Data = data;
    }

    public ResponseData(T data, String message) {
        this.Success = true;
        this.Data = data;
        this.Message = message;
    }

    public ResponseData(String message) {
        this.Success = false;
        this.Message = message;
    }
}
