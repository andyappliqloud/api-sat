package com.ghimprove.apisat.internal.model;

import lombok.*;
import org.datacontract.schemas._2004._07.sat_cfdi_negocio_consultacfdi.Acuse;

import javax.xml.bind.JAXBElement;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CFDIResponse {

    private JAXBElement<String> codigoEstatus;
    private JAXBElement<String> esCancelable;
    private JAXBElement<String> estado;
    private JAXBElement<String> estatusCancelacion;
    private JAXBElement<String> validacionEFOS;

    public static CFDIResponse acuseAResponse(Acuse acuse){
        return CFDIResponse.builder()
                .codigoEstatus(acuse.getCodigoEstatus())
                .esCancelable(acuse.getEsCancelable())
                .estado(acuse.getEstado())
                .estatusCancelacion(acuse.getEstatusCancelacion())
                .validacionEFOS(acuse.getValidacionEFOS())
                .build();
    }

    public static String buildFormattedResponse(CFDIResponse response) {
        StringBuilder formattedResponse = new StringBuilder();
        formattedResponse.append("Codigo estatus: ").append(response.getCodigoEstatus().getValue()).append("\n");
        formattedResponse.append("Estado: ").append(response.getEstado().getValue()).append("\n");
        formattedResponse.append("Es cancelable: ").append(response.getEsCancelable().getValue()).append("\n");
        formattedResponse.append("Estatus de cancelacion: ").append(response.getEstatusCancelacion().getValue()).append("\n");
        formattedResponse.append("Validacion EFOS: ").append(response.getValidacionEFOS().getValue());
        return formattedResponse.toString();
    }

    public String getValidationStatus() {
        String efosValue = validacionEFOS.getValue();
        if ("200".equals(efosValue.trim())) {
            return "No pertenece a la lista negra EFOS o EDOS";
        } else if ("100".equals(efosValue.trim())) {
            return "Pertenece a la lista negra de EFOS o EDOS";
        } else {
            return "Estado de validación EFOS no reconocido";
        }
    }
}
