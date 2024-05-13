package com.ghimprove.apisat.internal.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValidationResponse {
    private String codigoEstatus;
    private String estado;
    private String esCancelable;
    private String estatusCancelacion;
    private String validacionEFOS;
    private String validationStatus;
}