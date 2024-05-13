package com.ghimprove.apisat.internal.service;

import com.ghimprove.apisat.internal.model.CFDIResponse;
import com.ghimprove.apisat.internal.model.repository.ISatService;
import lombok.extern.slf4j.Slf4j;
import org.datacontract.schemas._2004._07.sat_cfdi_negocio_consultacfdi.Acuse;
import org.springframework.stereotype.Service;
import org.tempuri.ConsultaCFDIService;
import org.tempuri.IConsultaCFDIService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

@Slf4j
@Service
public class SatServiceImpl implements ISatService {

    @Override
    public CFDIResponse validateCFDI(String rfcEmisor, String rfcReceptor, String folioFiscal, Double totalFactura) {
        StringBuilder sb = new StringBuilder();
        sb.append("<![CDATA[")
                .append("?re=").append(rfcEmisor)
                .append("&rr=").append(rfcReceptor)
                .append("&tt=").append(totalFactura)
                .append("&id=").append(folioFiscal)
                .append("&fe=")
                .append("]]>");

        try {
            var consultaCFDIService = new ConsultaCFDIService().getBasicHttpBindingIConsultaCFDIService();
            var response = consultaCFDIService.consulta(sb.toString());

            log.info("response: {}, {}, {}, {}, {}",
                    response.getCodigoEstatus().getValue(),
                    response.getEsCancelable().getValue(),
                    response.getEstado().getValue(),
                    response.getEstatusCancelacion().getValue(),
                    response.getValidacionEFOS().getValue());

            CFDIResponse cfdiResponse = CFDIResponse.acuseAResponse(response);

            String validationStatus = cfdiResponse.getValidationStatus();
            log.info("Validation Status: {}", validationStatus);

            return cfdiResponse;
        } catch (Exception e) {
            log.error("Error al consultar el CFDI: {}", e.getMessage());
            return null;
        }
    }

    @Override
    public CFDIResponse processCFDI(String xmlString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlString)));

            String rfcEmisorFromXML = getElementValue(document, "cfdi:Emisor", "Rfc");
            String rfcReceptorFromXML = getElementValue(document, "cfdi:Receptor", "Rfc");
            String folioFiscalFromXML = getElementValue(document, "tfd:TimbreFiscalDigital", "UUID");
            String totalFacturaFromXML = getElementValue(document, "cfdi:Comprobante", "Total");

            log.info("Datos del XML: rfcEmisor={}, rfcReceptor={}, Folio Fiscal={}, Total Factura={}",
                    rfcEmisorFromXML, rfcReceptorFromXML, folioFiscalFromXML, totalFacturaFromXML);

            CFDIResponse response = validateCFDI(rfcEmisorFromXML, rfcReceptorFromXML, folioFiscalFromXML, Double.valueOf(totalFacturaFromXML));

            return response;
        } catch (Exception e) {
            log.error("Error al procesar el XML: {}", e.getMessage());
            return null;
        }
    }

    private String getElementValue(Document document, String parentTagName, String attribute) {
        NodeList nodeList = document.getElementsByTagName(parentTagName);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            if (element.hasAttribute(attribute)) {
                return element.getAttribute(attribute);
            }
        }
        return null;
    }
}
