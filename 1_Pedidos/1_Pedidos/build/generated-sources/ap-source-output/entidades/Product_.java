package entidades;

import entidades.Category;
import entidades.OrderedProduct;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2025-12-11T21:08:48")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> fibra;
    public static volatile SingularAttribute<Product, Short> esTemporada;
    public static volatile SingularAttribute<Product, String> lote;
    public static volatile SingularAttribute<Product, BigDecimal> descuento;
    public static volatile ListAttribute<Product, OrderedProduct> orderedProductList;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, String> grosor;
    public static volatile SingularAttribute<Product, Integer> existencia;
    public static volatile SingularAttribute<Product, String> marca;
    public static volatile SingularAttribute<Product, BigDecimal> price;
    public static volatile SingularAttribute<Product, Date> lastUpdate;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, Category> categoryId;

}