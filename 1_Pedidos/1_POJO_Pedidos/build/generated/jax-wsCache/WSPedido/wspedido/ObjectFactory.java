
package wspedido;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wspedido package. 
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

    private final static QName _SugerirSustitutos_QNAME = new QName("http://wspedido/", "sugerirSustitutos");
    private final static QName _MontoCOResponse_QNAME = new QName("http://wspedido/", "montoCOResponse");
    private final static QName _CatalogoCltes_QNAME = new QName("http://wspedido/", "catalogoCltes");
    private final static QName _CatalogoProdsResponse_QNAME = new QName("http://wspedido/", "catalogoProdsResponse");
    private final static QName _Product_QNAME = new QName("http://wspedido/", "product");
    private final static QName _SugerirSustitutosResponse_QNAME = new QName("http://wspedido/", "sugerirSustitutosResponse");
    private final static QName _AltaPedido_QNAME = new QName("http://wspedido/", "altaPedido");
    private final static QName _RestituyeProductosCO_QNAME = new QName("http://wspedido/", "restituyeProductosCO");
    private final static QName _MontoCO_QNAME = new QName("http://wspedido/", "montoCO");
    private final static QName _RestituyeProductosCOResponse_QNAME = new QName("http://wspedido/", "restituyeProductosCOResponse");
    private final static QName _Category_QNAME = new QName("http://wspedido/", "category");
    private final static QName _CatalogoProds_QNAME = new QName("http://wspedido/", "catalogoProds");
    private final static QName _Customer_QNAME = new QName("http://wspedido/", "customer");
    private final static QName _CatalogoCltesResponse_QNAME = new QName("http://wspedido/", "catalogoCltesResponse");
    private final static QName _AltaPedidoResponse_QNAME = new QName("http://wspedido/", "altaPedidoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wspedido
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MontoCOResponse }
     * 
     */
    public MontoCOResponse createMontoCOResponse() {
        return new MontoCOResponse();
    }

    /**
     * Create an instance of {@link CatalogoProdsResponse }
     * 
     */
    public CatalogoProdsResponse createCatalogoProdsResponse() {
        return new CatalogoProdsResponse();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link SugerirSustitutosResponse }
     * 
     */
    public SugerirSustitutosResponse createSugerirSustitutosResponse() {
        return new SugerirSustitutosResponse();
    }

    /**
     * Create an instance of {@link CatalogoCltes }
     * 
     */
    public CatalogoCltes createCatalogoCltes() {
        return new CatalogoCltes();
    }

    /**
     * Create an instance of {@link AltaPedido }
     * 
     */
    public AltaPedido createAltaPedido() {
        return new AltaPedido();
    }

    /**
     * Create an instance of {@link MontoCO }
     * 
     */
    public MontoCO createMontoCO() {
        return new MontoCO();
    }

    /**
     * Create an instance of {@link RestituyeProductosCO }
     * 
     */
    public RestituyeProductosCO createRestituyeProductosCO() {
        return new RestituyeProductosCO();
    }

    /**
     * Create an instance of {@link SugerirSustitutos }
     * 
     */
    public SugerirSustitutos createSugerirSustitutos() {
        return new SugerirSustitutos();
    }

    /**
     * Create an instance of {@link CatalogoCltesResponse }
     * 
     */
    public CatalogoCltesResponse createCatalogoCltesResponse() {
        return new CatalogoCltesResponse();
    }

    /**
     * Create an instance of {@link AltaPedidoResponse }
     * 
     */
    public AltaPedidoResponse createAltaPedidoResponse() {
        return new AltaPedidoResponse();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link RestituyeProductosCOResponse }
     * 
     */
    public RestituyeProductosCOResponse createRestituyeProductosCOResponse() {
        return new RestituyeProductosCOResponse();
    }

    /**
     * Create an instance of {@link CatalogoProds }
     * 
     */
    public CatalogoProds createCatalogoProds() {
        return new CatalogoProds();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link ClsItem }
     * 
     */
    public ClsItem createClsItem() {
        return new ClsItem();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SugerirSustitutos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspedido/", name = "sugerirSustitutos")
    public JAXBElement<SugerirSustitutos> createSugerirSustitutos(SugerirSustitutos value) {
        return new JAXBElement<SugerirSustitutos>(_SugerirSustitutos_QNAME, SugerirSustitutos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MontoCOResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspedido/", name = "montoCOResponse")
    public JAXBElement<MontoCOResponse> createMontoCOResponse(MontoCOResponse value) {
        return new JAXBElement<MontoCOResponse>(_MontoCOResponse_QNAME, MontoCOResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CatalogoCltes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspedido/", name = "catalogoCltes")
    public JAXBElement<CatalogoCltes> createCatalogoCltes(CatalogoCltes value) {
        return new JAXBElement<CatalogoCltes>(_CatalogoCltes_QNAME, CatalogoCltes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CatalogoProdsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspedido/", name = "catalogoProdsResponse")
    public JAXBElement<CatalogoProdsResponse> createCatalogoProdsResponse(CatalogoProdsResponse value) {
        return new JAXBElement<CatalogoProdsResponse>(_CatalogoProdsResponse_QNAME, CatalogoProdsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Product }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspedido/", name = "product")
    public JAXBElement<Product> createProduct(Product value) {
        return new JAXBElement<Product>(_Product_QNAME, Product.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SugerirSustitutosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspedido/", name = "sugerirSustitutosResponse")
    public JAXBElement<SugerirSustitutosResponse> createSugerirSustitutosResponse(SugerirSustitutosResponse value) {
        return new JAXBElement<SugerirSustitutosResponse>(_SugerirSustitutosResponse_QNAME, SugerirSustitutosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspedido/", name = "altaPedido")
    public JAXBElement<AltaPedido> createAltaPedido(AltaPedido value) {
        return new JAXBElement<AltaPedido>(_AltaPedido_QNAME, AltaPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestituyeProductosCO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspedido/", name = "restituyeProductosCO")
    public JAXBElement<RestituyeProductosCO> createRestituyeProductosCO(RestituyeProductosCO value) {
        return new JAXBElement<RestituyeProductosCO>(_RestituyeProductosCO_QNAME, RestituyeProductosCO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MontoCO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspedido/", name = "montoCO")
    public JAXBElement<MontoCO> createMontoCO(MontoCO value) {
        return new JAXBElement<MontoCO>(_MontoCO_QNAME, MontoCO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestituyeProductosCOResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspedido/", name = "restituyeProductosCOResponse")
    public JAXBElement<RestituyeProductosCOResponse> createRestituyeProductosCOResponse(RestituyeProductosCOResponse value) {
        return new JAXBElement<RestituyeProductosCOResponse>(_RestituyeProductosCOResponse_QNAME, RestituyeProductosCOResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Category }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspedido/", name = "category")
    public JAXBElement<Category> createCategory(Category value) {
        return new JAXBElement<Category>(_Category_QNAME, Category.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CatalogoProds }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspedido/", name = "catalogoProds")
    public JAXBElement<CatalogoProds> createCatalogoProds(CatalogoProds value) {
        return new JAXBElement<CatalogoProds>(_CatalogoProds_QNAME, CatalogoProds.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Customer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspedido/", name = "customer")
    public JAXBElement<Customer> createCustomer(Customer value) {
        return new JAXBElement<Customer>(_Customer_QNAME, Customer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CatalogoCltesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspedido/", name = "catalogoCltesResponse")
    public JAXBElement<CatalogoCltesResponse> createCatalogoCltesResponse(CatalogoCltesResponse value) {
        return new JAXBElement<CatalogoCltesResponse>(_CatalogoCltesResponse_QNAME, CatalogoCltesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaPedidoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://wspedido/", name = "altaPedidoResponse")
    public JAXBElement<AltaPedidoResponse> createAltaPedidoResponse(AltaPedidoResponse value) {
        return new JAXBElement<AltaPedidoResponse>(_AltaPedidoResponse_QNAME, AltaPedidoResponse.class, null, value);
    }

}
