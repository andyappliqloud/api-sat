
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.sat_cfdi_negocio_consultacfdi.Acuse;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ConsultaResult" type="{http://schemas.datacontract.org/2004/07/Sat.Cfdi.Negocio.ConsultaCfdi.Servicio}Acuse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "consultaResult"
})
@XmlRootElement(name = "ConsultaResponse")
public class ConsultaResponse {

    @XmlElementRef(name = "ConsultaResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<Acuse> consultaResult;

    /**
     * Obtiene el valor de la propiedad consultaResult.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Acuse }{@code >}
     *     
     */
    public JAXBElement<Acuse> getConsultaResult() {
        return consultaResult;
    }

    /**
     * Define el valor de la propiedad consultaResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Acuse }{@code >}
     *     
     */
    public void setConsultaResult(JAXBElement<Acuse> value) {
        this.consultaResult = value;
    }

}
