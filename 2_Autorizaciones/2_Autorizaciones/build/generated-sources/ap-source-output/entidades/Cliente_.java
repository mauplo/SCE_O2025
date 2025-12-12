package entidades;

import entidades.Operacion;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.0.v20170811-rNA", date="2025-12-11T18:24:56")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> calleNum;
    public static volatile SingularAttribute<Cliente, BigDecimal> montoMax;
    public static volatile SingularAttribute<Cliente, String> municipio;
    public static volatile SingularAttribute<Cliente, String> nombre;
    public static volatile SingularAttribute<Cliente, String> rfc;
    public static volatile SingularAttribute<Cliente, BigDecimal> lineaCredito;
    public static volatile SingularAttribute<Cliente, String> colonia;
    public static volatile SingularAttribute<Cliente, BigDecimal> montoDisponible;
    public static volatile SingularAttribute<Cliente, Date> fechaUltSolicitud;
    public static volatile ListAttribute<Cliente, Operacion> operacionList;
    public static volatile SingularAttribute<Cliente, Date> fechaStatus;
    public static volatile SingularAttribute<Cliente, String> entidad;
    public static volatile SingularAttribute<Cliente, String> tel;
    public static volatile SingularAttribute<Cliente, BigDecimal> montoUtilizado;
    public static volatile SingularAttribute<Cliente, Integer> id;
    public static volatile SingularAttribute<Cliente, String> email;
    public static volatile SingularAttribute<Cliente, String> status;

}