/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rafael
 */
@Entity
@Table(name = "ENVIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Envio.findAll", query = "SELECT e FROM Envio e")
    , @NamedQuery(name = "Envio.findById", query = "SELECT e FROM Envio e WHERE e.id = :id")
    , @NamedQuery(name = "Envio.findByIdCliente", query = "SELECT e FROM Envio e WHERE e.idCliente = :idCliente")
    , @NamedQuery(name = "Envio.findByNumPedido", query = "SELECT e FROM Envio e WHERE e.numPedido = :numPedido")
    , @NamedQuery(name = "Envio.findByFechaRegistro", query = "SELECT e FROM Envio e WHERE e.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Envio.findByDias", query = "SELECT e FROM Envio e WHERE e.dias = :dias")
    , @NamedQuery(name = "Envio.findByFechaEntrega", query = "SELECT e FROM Envio e WHERE e.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Envio.findByStatusEnvio", query = "SELECT e FROM Envio e WHERE e.statusEnvio = :statusEnvio")})
public class Envio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENTE")
    private int idCliente;
    @Column(name = "NUM_PEDIDO")
    private Integer numPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIAS")
    private int dias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_ENTREGA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STATUS_ENVIO")
    private String statusEnvio;

    public Envio() {
    }

    public Envio(Integer id) {
        this.id = id;
    }

    public Envio(Integer id, int idCliente, Date fechaRegistro, int dias, Date fechaEntrega, String statusEnvio) {
        this.id = id;
        this.idCliente = idCliente;
        this.fechaRegistro = fechaRegistro;
        this.dias = dias;
        this.fechaEntrega = fechaEntrega;
        this.statusEnvio = statusEnvio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(Integer numPedido) {
        this.numPedido = numPedido;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getStatusEnvio() {
        return statusEnvio;
    }

    public void setStatusEnvio(String statusEnvio) {
        this.statusEnvio = statusEnvio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Envio)) {
            return false;
        }
        Envio other = (Envio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Envio[ id=" + id + " ]";
    }
    
}
