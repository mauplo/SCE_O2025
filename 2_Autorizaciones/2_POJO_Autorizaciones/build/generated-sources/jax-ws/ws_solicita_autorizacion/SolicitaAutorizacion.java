
package ws_solicita_autorizacion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solicitaAutorizacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solicitaAutorizacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idClte" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idProv" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dblMonto" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitaAutorizacion", propOrder = {
    "idClte",
    "idProv",
    "dblMonto"
})
public class SolicitaAutorizacion {

    protected int idClte;
    protected int idProv;
    protected double dblMonto;

    /**
     * Gets the value of the idClte property.
     * 
     */
    public int getIdClte() {
        return idClte;
    }

    /**
     * Sets the value of the idClte property.
     * 
     */
    public void setIdClte(int value) {
        this.idClte = value;
    }

    /**
     * Gets the value of the idProv property.
     * 
     */
    public int getIdProv() {
        return idProv;
    }

    /**
     * Sets the value of the idProv property.
     * 
     */
    public void setIdProv(int value) {
        this.idProv = value;
    }

    /**
     * Gets the value of the dblMonto property.
     * 
     */
    public double getDblMonto() {
        return dblMonto;
    }

    /**
     * Sets the value of the dblMonto property.
     * 
     */
    public void setDblMonto(double value) {
        this.dblMonto = value;
    }

}
