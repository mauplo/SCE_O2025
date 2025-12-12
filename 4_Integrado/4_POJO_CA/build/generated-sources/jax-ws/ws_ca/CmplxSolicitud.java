
package ws_ca;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cmplx_solicitud complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cmplx_solicitud">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idCllte" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lista_items" type="{http://xml.netbeans.org/schema/BpelIntegrado}cmplx_ClsItem" maxOccurs="unbounded"/>
 *         &lt;element name="restriccionCalidad" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cmplx_solicitud", propOrder = {
    "idCllte",
    "listaItems",
    "restriccionCalidad"
})
public class CmplxSolicitud {

    protected int idCllte;
    @XmlElement(name = "lista_items", required = true)
    protected List<CmplxClsItem> listaItems;
    protected boolean restriccionCalidad;

    /**
     * Gets the value of the idCllte property.
     * 
     */
    public int getIdCllte() {
        return idCllte;
    }

    /**
     * Sets the value of the idCllte property.
     * 
     */
    public void setIdCllte(int value) {
        this.idCllte = value;
    }

    /**
     * Gets the value of the listaItems property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaItems property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CmplxClsItem }
     * 
     * 
     */
    public List<CmplxClsItem> getListaItems() {
        if (listaItems == null) {
            listaItems = new ArrayList<CmplxClsItem>();
        }
        return this.listaItems;
    }

    /**
     * Gets the value of the restriccionCalidad property.
     * 
     */
    public boolean isRestriccionCalidad() {
        return restriccionCalidad;
    }

    /**
     * Sets the value of the restriccionCalidad property.
     * 
     */
    public void setRestriccionCalidad(boolean value) {
        this.restriccionCalidad = value;
    }

}
