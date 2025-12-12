
package ws_ca;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws_ca package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EltoRespuesta_QNAME = new QName("http://xml.netbeans.org/schema/BpelIntegrado", "eltoRespuesta");
    private final static QName _EltoExepcion_QNAME = new QName("http://xml.netbeans.org/schema/BpelIntegrado", "eltoExepcion");
    private final static QName _EltoSolicitud_QNAME = new QName("http://xml.netbeans.org/schema/BpelIntegrado", "eltoSolicitud");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws_ca
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CmplxExepcion }
     * 
     */
    public CmplxExepcion createCmplxExepcion() {
        return new CmplxExepcion();
    }

    /**
     * Create an instance of {@link CmplxSolicitud }
     * 
     */
    public CmplxSolicitud createCmplxSolicitud() {
        return new CmplxSolicitud();
    }

    /**
     * Create an instance of {@link CmplxRespuesta }
     * 
     */
    public CmplxRespuesta createCmplxRespuesta() {
        return new CmplxRespuesta();
    }

    /**
     * Create an instance of {@link CmplxClsItem }
     * 
     */
    public CmplxClsItem createCmplxClsItem() {
        return new CmplxClsItem();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CmplxRespuesta }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/BpelIntegrado", name = "eltoRespuesta")
    public JAXBElement<CmplxRespuesta> createEltoRespuesta(CmplxRespuesta value) {
        return new JAXBElement<CmplxRespuesta>(_EltoRespuesta_QNAME, CmplxRespuesta.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CmplxExepcion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/BpelIntegrado", name = "eltoExepcion")
    public JAXBElement<CmplxExepcion> createEltoExepcion(CmplxExepcion value) {
        return new JAXBElement<CmplxExepcion>(_EltoExepcion_QNAME, CmplxExepcion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CmplxSolicitud }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://xml.netbeans.org/schema/BpelIntegrado", name = "eltoSolicitud")
    public JAXBElement<CmplxSolicitud> createEltoSolicitud(CmplxSolicitud value) {
        return new JAXBElement<CmplxSolicitud>(_EltoSolicitud_QNAME, CmplxSolicitud.class, null, value);
    }

}
