
package org.datacontract.schemas._2004._07.sat_cfdi_negocio_consultacfdi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Acuse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Acuse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CodigoEstatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EsCancelable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EstatusCancelacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ValidacionEFOS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Acuse", propOrder = {
    "codigoEstatus",
    "esCancelable",
    "estado",
    "estatusCancelacion",
    "validacionEFOS"
})
public class Acuse {

    @XmlElementRef(name = "CodigoEstatus", namespace = "http://schemas.datacontract.org/2004/07/Sat.Cfdi.Negocio.ConsultaCfdi.Servicio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> codigoEstatus;
    @XmlElementRef(name = "EsCancelable", namespace = "http://schemas.datacontract.org/2004/07/Sat.Cfdi.Negocio.ConsultaCfdi.Servicio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> esCancelable;
    @XmlElementRef(name = "Estado", namespace = "http://schemas.datacontract.org/2004/07/Sat.Cfdi.Negocio.ConsultaCfdi.Servicio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> estado;
    @XmlElementRef(name = "EstatusCancelacion", namespace = "http://schemas.datacontract.org/2004/07/Sat.Cfdi.Negocio.ConsultaCfdi.Servicio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> estatusCancelacion;
    @XmlElementRef(name = "ValidacionEFOS", namespace = "http://schemas.datacontract.org/2004/07/Sat.Cfdi.Negocio.ConsultaCfdi.Servicio", type = JAXBElement.class, required = false)
    protected JAXBElement<String> validacionEFOS;

    /**
     * Obtiene el valor de la propiedad codigoEstatus.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCodigoEstatus() {
        return codigoEstatus;
    }

    /**
     * Define el valor de la propiedad codigoEstatus.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCodigoEstatus(JAXBElement<String> value) {
        this.codigoEstatus = value;
    }

    /**
     * Obtiene el valor de la propiedad esCancelable.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEsCancelable() {
        return esCancelable;
    }

    /**
     * Define el valor de la propiedad esCancelable.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEsCancelable(JAXBElement<String> value) {
        this.esCancelable = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEstado(JAXBElement<String> value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad estatusCancelacion.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEstatusCancelacion() {
        return estatusCancelacion;
    }

    /**
     * Define el valor de la propiedad estatusCancelacion.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEstatusCancelacion(JAXBElement<String> value) {
        this.estatusCancelacion = value;
    }

    /**
     * Obtiene el valor de la propiedad validacionEFOS.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getValidacionEFOS() {
        return validacionEFOS;
    }

    /**
     * Define el valor de la propiedad validacionEFOS.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setValidacionEFOS(JAXBElement<String> value) {
        this.validacionEFOS = value;
    }

}
