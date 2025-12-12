/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "OPERACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operacion.findAll", query = "SELECT o FROM Operacion o")
    , @NamedQuery(name = "Operacion.findById", query = "SELECT o FROM Operacion o WHERE o.id = :id")
    , @NamedQuery(name = "Operacion.findByFechaOp", query = "SELECT o FROM Operacion o WHERE o.fechaOp = :fechaOp")
    , @NamedQuery(name = "Operacion.findByStatusOp", query = "SELECT o FROM Operacion o WHERE o.statusOp = :statusOp")
    , @NamedQuery(name = "Operacion.findByMonto", query = "SELECT o FROM Operacion o WHERE o.monto = :monto")})
public class Operacion implements Serializable {

    @Column(name = "AUTORIZACION")
    private Integer autorizacion;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_OP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaOp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STATUS_OP")
    private String statusOp;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO")
    private BigDecimal monto;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Proveedor idProveedor;

    public Operacion() {
    }

    public Operacion(Integer id) {
        this.id = id;
    }

    public Operacion(Integer id, Date fechaOp, String statusOp, BigDecimal monto) {
        this.id = id;
        this.fechaOp = fechaOp;
        this.statusOp = statusOp;
        this.monto = monto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaOp() {
        return fechaOp;
    }

    public void setFechaOp(Date fechaOp) {
        this.fechaOp = fechaOp;
    }

    public String getStatusOp() {
        return statusOp;
    }

    public void setStatusOp(String statusOp) {
        this.statusOp = statusOp;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
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
        if (!(object instanceof Operacion)) {
            return false;
        }
        Operacion other = (Operacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Operacion[ id=" + id + " ]";
    }

    public Integer getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(Integer autorizacion) {
        this.autorizacion = autorizacion;
    }
    
}
