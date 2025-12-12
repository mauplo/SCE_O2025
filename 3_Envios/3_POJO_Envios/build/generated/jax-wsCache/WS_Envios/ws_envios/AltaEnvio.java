
package ws_envios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for alta_envio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="alta_envio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_clte" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="num_pedido" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="num_dias" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "alta_envio", propOrder = {
    "idClte",
    "numPedido",
    "numDias"
})
public class AltaEnvio {

    @XmlElement(name = "id_clte")
    protected int idClte;
    @XmlElement(name = "num_pedido")
    protected int numPedido;
    @XmlElement(name = "num_dias")
    protected int numDias;

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
     * Gets the value of the numPedido property.
     * 
     */
    public int getNumPedido() {
        return numPedido;
    }

    /**
     * Sets the value of the numPedido property.
     * 
     */
    public void setNumPedido(int value) {
        this.numPedido = value;
    }

    /**
     * Gets the value of the numDias property.
     * 
     */
    public int getNumDias() {
        return numDias;
    }

    /**
     * Sets the value of the numDias property.
     * 
     */
    public void setNumDias(int value) {
        this.numDias = value;
    }

}
