
package wspedido;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sugerirSustitutos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sugerirSustitutos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_prod_original" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cantidad_requerida" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sugerirSustitutos", propOrder = {
    "idProdOriginal",
    "cantidadRequerida"
})
public class SugerirSustitutos {

    @XmlElement(name = "id_prod_original")
    protected int idProdOriginal;
    @XmlElement(name = "cantidad_requerida")
    protected int cantidadRequerida;

    /**
     * Gets the value of the idProdOriginal property.
     * 
     */
    public int getIdProdOriginal() {
        return idProdOriginal;
    }

    /**
     * Sets the value of the idProdOriginal property.
     * 
     */
    public void setIdProdOriginal(int value) {
        this.idProdOriginal = value;
    }

    /**
     * Gets the value of the cantidadRequerida property.
     * 
     */
    public int getCantidadRequerida() {
        return cantidadRequerida;
    }

    /**
     * Sets the value of the cantidadRequerida property.
     * 
     */
    public void setCantidadRequerida(int value) {
        this.cantidadRequerida = value;
    }

}
