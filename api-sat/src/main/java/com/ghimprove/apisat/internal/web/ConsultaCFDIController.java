package com.ghimprove.apisat.internal.web;

import com.ghimprove.apisat.internal.model.CFDIResponse;
import com.ghimprove.apisat.internal.model.repository.ISatService;
import com.ghimprove.apisat.internal.web.model.ValidationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ConsultaCFDIController {

    private static final Logger logger = LoggerFactory.getLogger(ConsultaCFDIController.class);


    @Autowired
    private ISatService satService;

    @GetMapping("/validarCFDI")
    public ResponseEntity<ValidationResponse> validateCFDI(
            @RequestParam String rfcEmisor,
            @RequestParam String rfcReceptor,
            @RequestParam String folioFiscal,
            @RequestParam Double totalFactura
    ) {
        var response = satService.validateCFDI(rfcEmisor, rfcReceptor, folioFiscal, totalFactura);

        if (response != null) {
            String validationStatus = response.getValidationStatus() != null ? response.getValidationStatus() : "No se pudo validar el CFDI";

            ValidationResponse validationResponse = new ValidationResponse(
                    response.getCodigoEstatus().getValue(),
                    response.getEstado().getValue(),
                    response.getEsCancelable().getValue(),
                    response.getEstatusCancelacion().getValue(),
                    response.getValidacionEFOS().getValue(),
                    validationStatus
            );

            return new ResponseEntity<>(validationResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/process-cfdi")
    public ResponseEntity<ValidationResponse> processCFDI(@RequestParam String xmlString) {
        CFDIResponse response = satService.processCFDI(xmlString);
        if (response != null) {
            String validationStatus = response.getValidationStatus(); // Obtener el estado de validación
            ValidationResponse validationResponse = new ValidationResponse(
                    response.getCodigoEstatus().getValue(),
                    response.getEstado().getValue(),
                    response.getEsCancelable().getValue(),
                    response.getEstatusCancelacion().getValue(),
                    response.getValidacionEFOS().getValue(),
                    validationStatus // Usar el estado de validación obtenido
            );
            return new ResponseEntity<>(validationResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}