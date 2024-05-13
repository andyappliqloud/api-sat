package com.ghimprove.apisat.internal.model.repository;

import com.ghimprove.apisat.internal.model.CFDIResponse;

public interface ISatService {
  CFDIResponse validateCFDI(String rfcEmisor, String rfcReceptor, String folioFiscal, Double totalFactura);
  CFDIResponse processCFDI(String xmlString);
}
