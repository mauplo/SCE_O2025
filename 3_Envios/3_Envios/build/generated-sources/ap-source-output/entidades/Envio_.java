package entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-12-11T17:52:08")
@StaticMetamodel(Envio.class)
public class Envio_ { 

    public static volatile SingularAttribute<Envio, Integer> numPedido;
    public static volatile SingularAttribute<Envio, String> statusEnvio;
    public static volatile SingularAttribute<Envio, Integer> idCliente;
    public static volatile SingularAttribute<Envio, Date> fechaRegistro;
    public static volatile SingularAttribute<Envio, Integer> dias;
    public static volatile SingularAttribute<Envio, Date> fechaEntrega;
    public static volatile SingularAttribute<Envio, Integer> id;

}