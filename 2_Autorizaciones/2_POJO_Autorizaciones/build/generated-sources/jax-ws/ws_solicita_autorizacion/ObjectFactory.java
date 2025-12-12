
package ws_solicita_autorizacion;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws_solicita_autorizacion package. 
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

    private final static QName _HelloResponse_QNAME = new QName("http://ws_solicita_autorizacion/", "helloResponse");
    private final static QName _SolicitaAutorizacionResponse_QNAME = new QName("http://ws_solicita_autorizacion/", "solicitaAutorizacionResponse");
    private final static QName _Cliente_QNAME = new QName("http://ws_solicita_autorizacion/", "cliente");
    private final static QName _CatalogoProveedores_QNAME = new QName("http://ws_solicita_autorizacion/", "catalogoProveedores");
    private final static QName _ExcepcionNegocio_QNAME = new QName("http://ws_solicita_autorizacion/", "Excepcion_Negocio");
    private final static QName _CatalogoProveedoresResponse_QNAME = new QName("http://ws_solicita_autorizacion/", "catalogoProveedoresResponse");
    private final static QName _Proveedor_QNAME = new QName("http://ws_solicita_autorizacion/", "proveedor");
    private final static QName _SolicitaAutorizacion_QNAME = new QName("http://ws_solicita_autorizacion/", "solicitaAutorizacion");
    private final static QName _CatalogoClientes_QNAME = new QName("http://ws_solicita_autorizacion/", "catalogoClientes");
    private final static QName _Hello_QNAME = new QName("http://ws_solicita_autorizacion/", "hello");
    private final static QName _CatalogoClientesResponse_QNAME = new QName("http://ws_solicita_autorizacion/", "catalogoClientesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws_solicita_autorizacion
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SolicitaAutorizacionResponse }
     * 
     */
    public SolicitaAutorizacionResponse createSolicitaAutorizacionResponse() {
        return new SolicitaAutorizacionResponse();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link CatalogoClientesResponse }
     * 
     */
    public CatalogoClientesResponse createCatalogoClientesResponse() {
        return new CatalogoClientesResponse();
    }

    /**
     * Create an instance of {@link Proveedor }
     * 
     */
    public Proveedor createProveedor() {
        return new Proveedor();
    }

    /**
     * Create an instance of {@link SolicitaAutorizacion }
     * 
     */
    public SolicitaAutorizacion createSolicitaAutorizacion() {
        return new SolicitaAutorizacion();
    }

    /**
     * Create an instance of {@link CatalogoClientes }
     * 
     */
    public CatalogoClientes createCatalogoClientes() {
        return new CatalogoClientes();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link CatalogoProveedoresResponse }
     * 
     */
    public CatalogoProveedoresResponse createCatalogoProveedoresResponse() {
        return new CatalogoProveedoresResponse();
    }

    /**
     * Create an instance of {@link CatalogoProveedores }
     * 
     */
    public CatalogoProveedores createCatalogoProveedores() {
        return new CatalogoProveedores();
    }

    /**
     * Create an instance of {@link ExcepcionNegocio }
     * 
     */
    public ExcepcionNegocio createExcepcionNegocio() {
        return new ExcepcionNegocio();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_solicita_autorizacion/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitaAutorizacionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_solicita_autorizacion/", name = "solicitaAutorizacionResponse")
    public JAXBElement<SolicitaAutorizacionResponse> createSolicitaAutorizacionResponse(SolicitaAutorizacionResponse value) {
        return new JAXBElement<SolicitaAutorizacionResponse>(_SolicitaAutorizacionResponse_QNAME, SolicitaAutorizacionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cliente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_solicita_autorizacion/", name = "cliente")
    public JAXBElement<Cliente> createCliente(Cliente value) {
        return new JAXBElement<Cliente>(_Cliente_QNAME, Cliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CatalogoProveedores }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_solicita_autorizacion/", name = "catalogoProveedores")
    public JAXBElement<CatalogoProveedores> createCatalogoProveedores(CatalogoProveedores value) {
        return new JAXBElement<CatalogoProveedores>(_CatalogoProveedores_QNAME, CatalogoProveedores.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExcepcionNegocio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_solicita_autorizacion/", name = "Excepcion_Negocio")
    public JAXBElement<ExcepcionNegocio> createExcepcionNegocio(ExcepcionNegocio value) {
        return new JAXBElement<ExcepcionNegocio>(_ExcepcionNegocio_QNAME, ExcepcionNegocio.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CatalogoProveedoresResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_solicita_autorizacion/", name = "catalogoProveedoresResponse")
    public JAXBElement<CatalogoProveedoresResponse> createCatalogoProveedoresResponse(CatalogoProveedoresResponse value) {
        return new JAXBElement<CatalogoProveedoresResponse>(_CatalogoProveedoresResponse_QNAME, CatalogoProveedoresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Proveedor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_solicita_autorizacion/", name = "proveedor")
    public JAXBElement<Proveedor> createProveedor(Proveedor value) {
        return new JAXBElement<Proveedor>(_Proveedor_QNAME, Proveedor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitaAutorizacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_solicita_autorizacion/", name = "solicitaAutorizacion")
    public JAXBElement<SolicitaAutorizacion> createSolicitaAutorizacion(SolicitaAutorizacion value) {
        return new JAXBElement<SolicitaAutorizacion>(_SolicitaAutorizacion_QNAME, SolicitaAutorizacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CatalogoClientes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_solicita_autorizacion/", name = "catalogoClientes")
    public JAXBElement<CatalogoClientes> createCatalogoClientes(CatalogoClientes value) {
        return new JAXBElement<CatalogoClientes>(_CatalogoClientes_QNAME, CatalogoClientes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_solicita_autorizacion/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CatalogoClientesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws_solicita_autorizacion/", name = "catalogoClientesResponse")
    public JAXBElement<CatalogoClientesResponse> createCatalogoClientesResponse(CatalogoClientesResponse value) {
        return new JAXBElement<CatalogoClientesResponse>(_CatalogoClientesResponse_QNAME, CatalogoClientesResponse.class, null, value);
    }

}
