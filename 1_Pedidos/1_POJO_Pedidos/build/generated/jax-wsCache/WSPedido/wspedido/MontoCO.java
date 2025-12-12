
package wspedido;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for montoCO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="montoCO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_CO" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "montoCO", propOrder = {
    "idCO"
})
public class MontoCO {

    @XmlElement(name = "id_CO")
    protected int idCO;

    /**
     * Gets the value of the idCO property.
     * 
     */
    public int getIdCO() {
        return idCO;
    }

    /**
     * Sets the value of the idCO property.
     * 
     */
    public void setIdCO(int value) {
        this.idCO = value;
    }

}
