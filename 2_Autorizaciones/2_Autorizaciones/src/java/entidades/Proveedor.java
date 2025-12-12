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
@Table(name = "PROVEEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findById", query = "SELECT p FROM Proveedor p WHERE p.id = :id")
    , @NamedQuery(name = "Proveedor.findByNombre", query = "SELECT p FROM Proveedor p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proveedor.findByEmail", query = "SELECT p FROM Proveedor p WHERE p.email = :email")
    , @NamedQuery(name = "Proveedor.findByTel", query = "SELECT p FROM Proveedor p WHERE p.tel = :tel")
    , @NamedQuery(name = "Proveedor.findByCalleNum", query = "SELECT p FROM Proveedor p WHERE p.calleNum = :calleNum")
    , @NamedQuery(name = "Proveedor.findByColonia", query = "SELECT p FROM Proveedor p WHERE p.colonia = :colonia")
    , @NamedQuery(name = "Proveedor.findByMunicipio", query = "SELECT p FROM Proveedor p WHERE p.municipio = :municipio")
    , @NamedQuery(name = "Proveedor.findByEntidad", query = "SELECT p FROM Proveedor p WHERE p.entidad = :entidad")
    , @NamedQuery(name = "Proveedor.findByRfc", query = "SELECT p FROM Proveedor p WHERE p.rfc = :rfc")
    , @NamedQuery(name = "Proveedor.findByMontoAdeudado", query = "SELECT p FROM Proveedor p WHERE p.montoAdeudado = :montoAdeudado")
    , @NamedQuery(name = "Proveedor.findByFechaStatus", query = "SELECT p FROM Proveedor p WHERE p.fechaStatus = :fechaStatus")
    , @NamedQuery(name = "Proveedor.findByStatus", query = "SELECT p FROM Proveedor p WHERE p.status = :status")
    , @NamedQuery(name = "Proveedor.findByFechaUltOperacion", query = "SELECT p FROM Proveedor p WHERE p.fechaUltOperacion = :fechaUltOperacion")
    , @NamedQuery(name = "Proveedor.findByTipoOp", query = "SELECT p FROM Proveedor p WHERE p.tipoOp = :tipoOp")})
public class Proveedor implements Serializable {

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
    @Column(name = "MONTO_ADEUDADO")
    private BigDecimal montoAdeudado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_STATUS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "FECHA_ULT_OPERACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltOperacion;
    @Size(max = 1)
    @Column(name = "TIPO_OP")
    private String tipoOp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private List<Operacion> operacionList;

    public Proveedor() {
    }

    public Proveedor(Integer id) {
        this.id = id;
    }

    public Proveedor(Integer id, String nombre, String email, String tel, String calleNum, String colonia, String municipio, String entidad, String rfc, BigDecimal montoAdeudado, Date fechaStatus, String status) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.tel = tel;
        this.calleNum = calleNum;
        this.colonia = colonia;
        this.municipio = municipio;
        this.entidad = entidad;
        this.rfc = rfc;
        this.montoAdeudado = montoAdeudado;
        this.fechaStatus = fechaStatus;
        this.status = status;
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

    public BigDecimal getMontoAdeudado() {
        return montoAdeudado;
    }

    public void setMontoAdeudado(BigDecimal montoAdeudado) {
        this.montoAdeudado = montoAdeudado;
    }

    public Date getFechaStatus() {
        return fechaStatus;
    }

    public void setFechaStatus(Date fechaStatus) {
        this.fechaStatus = fechaStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFechaUltOperacion() {
        return fechaUltOperacion;
    }

    public void setFechaUltOperacion(Date fechaUltOperacion) {
        this.fechaUltOperacion = fechaUltOperacion;
    }

    public String getTipoOp() {
        return tipoOp;
    }

    public void setTipoOp(String tipoOp) {
        this.tipoOp = tipoOp;
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
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Proveedor[ id=" + id + " ]";
    }
    
}
