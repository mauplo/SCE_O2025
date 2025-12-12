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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author RGAMBOAH
 */
@Entity
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id")
    , @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name")
    , @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price")
    , @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description")
    , @NamedQuery(name = "Product.findByLastUpdate", query = "SELECT p FROM Product p WHERE p.lastUpdate = :lastUpdate")
    , @NamedQuery(name = "Product.findByExistencia", query = "SELECT p FROM Product p WHERE p.existencia = :existencia")
    , @NamedQuery(name = "Product.findByGrosor", query = "SELECT p FROM Product p WHERE p.grosor = :grosor")
    , @NamedQuery(name = "Product.findByFibra", query = "SELECT p FROM Product p WHERE p.fibra = :fibra")
    , @NamedQuery(name = "Product.findByMarca", query = "SELECT p FROM Product p WHERE p.marca = :marca")
    // QUERY PARA SUSTITUTOS: Busca productos con mismo grosor y fibra, diferente ID, y con existencia suficiente
    , @NamedQuery(name = "Product.findSubstitutes", query = "SELECT p FROM Product p WHERE p.grosor = :grosor AND p.fibra = :fibra AND p.id <> :originalId AND p.existencia >= :cantidadRequerida")
})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;
    @Size(max = 50)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LAST_UPDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EXISTENCIA")
    private int existencia;
    
    // NEW FIELDS FOR ESTAMBRES
    @Size(max = 45)
    @Column(name = "GROSOR")
    private String grosor;
    @Size(max = 45)
    @Column(name = "FIBRA")
    private String fibra;
    @Size(max = 45)
    @Column(name = "MARCA")
    private String marca;

    // NUEVOS CAMPOS REQUERIDOS
    @Size(max = 20)
    @Column(name = "LOTE")
    private String lote;

    @Column(name = "ES_TEMPORADA")
    private Short esTemporada;

    @Column(name = "DESCUENTO")
    private BigDecimal descuento;

    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Category categoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<OrderedProduct> orderedProductList;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String name, BigDecimal price, Date lastUpdate, int existencia) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.lastUpdate = lastUpdate;
        this.existencia = existencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    
    // Getters and Setters for new fields
    public String getGrosor() { return grosor; }
    public void setGrosor(String grosor) { this.grosor = grosor; }

    public String getFibra() { return fibra; }
    public void setFibra(String fibra) { this.fibra = fibra; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getLote() { return lote; }
    public void setLote(String lote) { this.lote = lote; }

    public Short getEsTemporada() { return esTemporada; }
    public void setEsTemporada(Short esTemporada) { this.esTemporada = esTemporada; }

    public BigDecimal getDescuento() { return descuento; }
    public void setDescuento(BigDecimal descuento) { this.descuento = descuento; }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    @XmlTransient
    public List<OrderedProduct> getOrderedProductList() {
        return orderedProductList;
    }

    public void setOrderedProductList(List<OrderedProduct> orderedProductList) {
        this.orderedProductList = orderedProductList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Product[ id=" + id + " ]";
    }
}