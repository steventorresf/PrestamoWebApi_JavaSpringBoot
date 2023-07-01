package com.prestamofacilweb.dto.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseErrors {
    private String Title;
    private String Message;
    private String[] Errors;
}
