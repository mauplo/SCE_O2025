package entidades;

import entidades.Customer;
import entidades.OrderedProduct;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2025-12-11T17:51:41")
@StaticMetamodel(CustomerOrder.class)
public class CustomerOrder_ { 

    public static volatile SingularAttribute<CustomerOrder, BigDecimal> amount;
    public static volatile SingularAttribute<CustomerOrder, Date> dateCreated;
    public static volatile SingularAttribute<CustomerOrder, Integer> confirmationNumber;
    public static volatile SingularAttribute<CustomerOrder, Customer> customerId;
    public static volatile ListAttribute<CustomerOrder, OrderedProduct> orderedProductList;
    public static volatile SingularAttribute<CustomerOrder, Integer> id;

}