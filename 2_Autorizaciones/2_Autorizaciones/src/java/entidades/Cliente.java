/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rafael
 */
@Entity
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :id")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email")
    , @NamedQuery(name = "Cliente.findByTel", query = "SELECT c FROM Cliente c WHERE c.tel = :tel")
    , @NamedQuery(name = "Cliente.findByCalleNum", query = "SELECT c FROM Cliente c WHERE c.calleNum = :calleNum")
    , @NamedQuery(name = "Cliente.findByColonia", query = "SELECT c FROM Cliente c WHERE c.colonia = :colonia")
    , @NamedQuery(name = "Cliente.findByMunicipio", query = "SELECT c FROM Cliente c WHERE c.municipio = :municipio")
    , @NamedQuery(name = "Cliente.findByEntidad", query = "SELECT c FROM Cliente c WHERE c.entidad = :entidad")
    , @NamedQuery(name = "Cliente.findByRfc", query = "SELECT c FROM Cliente c WHERE c.rfc = :rfc")
    , @NamedQuery(name = "Cliente.findByLineaCredito", query = "SELECT c FROM Cliente c WHERE c.lineaCredito = :lineaCredito")
    , @NamedQuery(name = "Cliente.findByMontoDisponible", query = "SELECT c FROM Cliente c WHERE c.montoDisponible = :montoDisponible")
    , @NamedQuery(name = "Cliente.findByMontoUtilizado", query = "SELECT c FROM Cliente c WHERE c.montoUtilizado = :montoUtilizado")
    , @NamedQuery(name = "Cliente.findByMontoMax", query = "SELECT c FROM Cliente c WHERE c.montoMax = :montoMax")
    , @NamedQuery(name = "Cliente.findByStatus", query = "SELECT c FROM Cliente c WHERE c.status = :status")
    , @NamedQuery(name = "Cliente.findByFechaStatus", query = "SELECT c FROM Cliente c WHERE c.fechaStatus = :fechaStatus")
    , @NamedQuery(name = "Cliente.findByFechaUltSolicitud", query = "SELECT c FROM Cliente c WHERE c.fechaUltSolicitud = :fechaUltSolicitud")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TEL")
    private String tel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "CALLE_NUM")
    private String calleNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "COLONIA")
    private String colonia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "MUNICIPIO")
    private String municipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ENTIDAD")
    private String entidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "RFC")
    private String rfc;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "LINEA_CREDITO")
    private BigDecimal lineaCredito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO_DISPONIBLE")
    private BigDecimal montoDisponible;
    @Column(name = "MONTO_UTILIZADO")
    private BigDecimal montoUtilizado;
    @Column(name = "MONTO_MAX")
    private BigDecimal montoMax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STATUS")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_STATUS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaStatus;
    @Column(name = "FECHA_ULT_SOLICITUD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltSolicitud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private List<Operacion> operacionList;

    public Cliente() {
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    public Cliente(Integer id, String nombre, String email, String tel, String calleNum, String colonia, String municipio, String entidad, String rfc, BigDecimal lineaCredito, BigDecimal montoDisponible, String status, Date fechaStatus) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.tel = tel;
        this.calleNum = calleNum;
        this.colonia = colonia;
        this.municipio = municipio;
        this.entidad = entidad;
        this.rfc = rfc;
        this.lineaCredito = lineaCredito;
        this.montoDisponible = montoDisponible;
        this.status = status;
        this.fechaStatus = fechaStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCalleNum() {
        return calleNum;
    }

    public void setCalleNum(String calleNum) {
        this.calleNum = calleNum;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public BigDecimal getLineaCredito() {
        return lineaCredito;
    }

    public void setLineaCredito(BigDecimal lineaCredito) {
        this.lineaCredito = lineaCredito;
    }

    public BigDecimal getMontoDisponible() {
        return montoDisponible;
    }

    public void setMontoDisponible(BigDecimal montoDisponible) {
        this.montoDisponible = montoDisponible;
    }

    public BigDecimal getMontoUtilizado() {
        return montoUtilizado;
    }

    public void setMontoUtilizado(BigDecimal montoUtilizado) {
        this.montoUtilizado = montoUtilizado;
    }

    public BigDecimal getMontoMax() {
        return montoMax;
    }

    public void setMontoMax(BigDecimal montoMax) {
        this.montoMax = montoMax;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFechaStatus() {
        return fechaStatus;
    }

    public void setFechaStatus(Date fechaStatus) {
        this.fechaStatus = fechaStatus;
    }

    public Date getFechaUltSolicitud() {
        return fechaUltSolicitud;
    }

    public void setFechaUltSolicitud(Date fechaUltSolicitud) {
        this.fechaUltSolicitud = fechaUltSolicitud;
    }

    @XmlTransient
    public List<Operacion> getOperacionList() {
        return operacionList;
    }

    public void setOperacionList(List<Operacion> operacionList) {
        this.operacionList = operacionList;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cliente[ id=" + id + " ]";
    }
    
}
