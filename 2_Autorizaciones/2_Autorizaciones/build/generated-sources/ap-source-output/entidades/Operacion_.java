package entidades;

import entidades.Cliente;
import entidades.Proveedor;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2025-12-11T18:24:56")
@StaticMetamodel(Operacion.class)
public class Operacion_ { 

    public static volatile SingularAttribute<Operacion, Integer> autorizacion;
    public static volatile SingularAttribute<Operacion, BigDecimal> monto;
    public static volatile SingularAttribute<Operacion, Cliente> idCliente;
    public static volatile SingularAttribute<Operacion, Date> fechaOp;
    public static volatile SingularAttribute<Operacion, Proveedor> idProveedor;
    public static volatile SingularAttribute<Operacion, String> statusOp;
    public static volatile SingularAttribute<Operacion, Integer> id;

}