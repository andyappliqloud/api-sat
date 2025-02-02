package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2024-04-10T15:54:22.926-05:00
 * Generated source version: 3.3.0
 *
 */
@WebService(targetNamespace = "http://tempuri.org/", name = "IConsultaCFDIService")
@XmlSeeAlso({com.microsoft.schemas._2003._10.serialization.ObjectFactory.class, ObjectFactory.class, org.datacontract.schemas._2004._07.sat_cfdi_negocio_consultacfdi.ObjectFactory.class})
public interface IConsultaCFDIService {

    @WebMethod(operationName = "Consulta", action = "http://tempuri.org/IConsultaCFDIService/Consulta")
    @Action(input = "http://tempuri.org/IConsultaCFDIService/Consulta", output = "http://tempuri.org/IConsultaCFDIService/ConsultaResponse")
    @RequestWrapper(localName = "Consulta", targetNamespace = "http://tempuri.org/", className = "org.tempuri.Consulta")
    @ResponseWrapper(localName = "ConsultaResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.ConsultaResponse")
    @WebResult(name = "ConsultaResult", targetNamespace = "http://tempuri.org/")
    public org.datacontract.schemas._2004._07.sat_cfdi_negocio_consultacfdi.Acuse consulta(
        @WebParam(name = "expresionImpresa", targetNamespace = "http://tempuri.org/")
        java.lang.String expresionImpresa
    );
}
