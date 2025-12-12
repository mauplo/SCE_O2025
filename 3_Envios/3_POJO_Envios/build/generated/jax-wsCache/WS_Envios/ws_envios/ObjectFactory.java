
package ws_envios;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws_envios package. 
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

    private final static QName _AltaEnvio_QNAME = new QName("http://ws_envios/", "alta_envio");
    private final static QName _FindAllResponse_QNAME = new QName("http://ws_envios/", "findAllResponse");
    private final static QName _Create_QNAME = new QName("http://ws_envios/", "create");
    private final static QName _FindRangeResponse_QNAME = new QName("http://ws_envios/", "findRangeResponse");
    private final static QName _Envio_QNAME = new QName("http://ws_envios/", "envio");
    private final static QName _Find_QNAME = new QName("http://ws_envios/", "find");
    private final static QName _AltaEnvioResponse_QNAME = new QName("http://ws_envios/", "alta_envioResponse");
    private final static QName _CountResponse_QNAME = new QName("http://ws_envios/", "countResponse");
    private final static QName _FindResponse_QNAME = new QName("http://ws_envios/", "findResponse");
    private final static QName _Count_QNAME = new QName("http://ws_envios/", "count");
    private final static QName _Remove_QNAME = new QName("http://ws_envios/", "remove");
    private final static QName _FindAll_QNAME = new QName("http://ws_envios/", "findAll");
    private final static QName _FindRange_QNAME = new QName("http://ws_envios/", "findRange");
    private final static QName _Edit_QNAME = new QName("http://ws_envios/", "edit");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws_envios
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Edit }
     * 
     */
    public Edit createEdit() {
        return new Edit();
    }

    /**
     * Create an instance of {@link FindRange }
     * 
     */
    public FindRange createFindRange() {
        return new FindRange();
    }

    /**
     * Create an instance of {@link Count }
     * 
     */
    public Count createCount() {
        return new Count();
    }

    /**
     * Create an instance of {@link AltaEnvioResponse }
     * 
     */
    public AltaEnvioResponse createAltaEnvioResponse() {
        return new AltaEnvioResponse();
    }

    /**
     * Create an instance of {@link CountResponse }
     * 
     */
    public CountResponse createCountResponse() {
        return new CountResponse();
    }

    /**
     * Create an instance of {@link FindResponse }
     * 
     */
    public FindResponse createFindResponse() {
        return new FindResponse();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link Remove }
     * 
     */
    public Remove createRemove() {
        return new Remove();
    }

    /**
     * Create an instance of {@link Envio }
     * 
     */
    public Envio createEnvio() {
        return new Envio();
    }

    /**
     * Create an instance of {@link FindRangeResponse }
     * 
     */
    public FindRangeResponse createFindRangeResponse() {
        return new FindRangeResponse();
    }

    /**
     * Create an instance of {@link Find }
     * 
     */
    public Find createFind() {
        return new Find();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link AltaEnvio }
     * 
     */
    public AltaEnvio createAltaEnvio() {
        return new AltaEnvio();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaEnvio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_envios/", name = "alta_envio")
    public JAXBElement<AltaEnvio> createAltaEnvio(AltaEnvio value) {
        return new JAXBElement<AltaEnvio>(_AltaEnvio_QNAME, AltaEnvio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_envios/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_envios/", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRangeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_envios/", name = "findRangeResponse")
    public JAXBElement<FindRangeResponse> createFindRangeResponse(FindRangeResponse value) {
        return new JAXBElement<FindRangeResponse>(_FindRangeResponse_QNAME, FindRangeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Envio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_envios/", name = "envio")
    public JAXBElement<Envio> createEnvio(Envio value) {
        return new JAXBElement<Envio>(_Envio_QNAME, Envio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Find }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_envios/", name = "find")
    public JAXBElement<Find> createFind(Find value) {
        return new JAXBElement<Find>(_Find_QNAME, Find.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaEnvioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_envios/", name = "alta_envioResponse")
    public JAXBElement<AltaEnvioResponse> createAltaEnvioResponse(AltaEnvioResponse value) {
        return new JAXBElement<AltaEnvioResponse>(_AltaEnvioResponse_QNAME, AltaEnvioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_envios/", name = "countResponse")
    public JAXBElement<CountResponse> createCountResponse(CountResponse value) {
        return new JAXBElement<CountResponse>(_CountResponse_QNAME, CountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_envios/", name = "findResponse")
    public JAXBElement<FindResponse> createFindResponse(FindResponse value) {
        return new JAXBElement<FindResponse>(_FindResponse_QNAME, FindResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Count }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_envios/", name = "count")
    public JAXBElement<Count> createCount(Count value) {
        return new JAXBElement<Count>(_Count_QNAME, Count.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Remove }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_envios/", name = "remove")
    public JAXBElement<Remove> createRemove(Remove value) {
        return new JAXBElement<Remove>(_Remove_QNAME, Remove.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_envios/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindRange }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_envios/", name = "findRange")
    public JAXBElement<FindRange> createFindRange(FindRange value) {
        return new JAXBElement<FindRange>(_FindRange_QNAME, FindRange.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Edit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_envios/", name = "edit")
    public JAXBElement<Edit> createEdit(Edit value) {
        return new JAXBElement<Edit>(_Edit_QNAME, Edit.class, null, value);
    }

}
