package entidades;

import entidades.Operacion;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2025-12-11T17:51:56")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, Date> fechaUltOperacion;
    public static volatile SingularAttribute<Proveedor, String> calleNum;
    public static volatile SingularAttribute<Proveedor, String> municipio;
    public static volatile SingularAttribute<Proveedor, String> nombre;
    public static volatile SingularAttribute<Proveedor, String> rfc;
    public static volatile SingularAttribute<Proveedor, String> colonia;
    public static volatile ListAttribute<Proveedor, Operacion> operacionList;
    public static volatile SingularAttribute<Proveedor, Date> fechaStatus;
    public static volatile SingularAttribute<Proveedor, String> entidad;
    public static volatile SingularAttribute<Proveedor, String> tel;
    public static volatile SingularAttribute<Proveedor, Integer> id;
    public static volatile SingularAttribute<Proveedor, String> tipoOp;
    public static volatile SingularAttribute<Proveedor, String> email;
    public static volatile SingularAttribute<Proveedor, BigDecimal> montoAdeudado;
    public static volatile SingularAttribute<Proveedor, String> status;

}