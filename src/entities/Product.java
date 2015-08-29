/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author macbookpro
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByCode", query = "SELECT p FROM Product p WHERE p.code = :code"),
    @NamedQuery(name = "Product.findByStock", query = "SELECT p FROM Product p WHERE p.stock = :stock"),
    @NamedQuery(name = "Product.findByMinvalue", query = "SELECT p FROM Product p WHERE p.minvalue = :minvalue"),
    @NamedQuery(name = "Product.findByActive", query = "SELECT p FROM Product p WHERE p.active = :active"),
    @NamedQuery(name = "Product.findByPurchaseprice", query = "SELECT p FROM Product p WHERE p.purchaseprice = :purchaseprice"),
    @NamedQuery(name = "Product.findByCodeOrName", query = "SELECT p FROM Product p WHERE p.code like :field or p.name like :field"),
    @NamedQuery(name = "Product.findBySaleprice", query = "SELECT p FROM Product p WHERE p.saleprice = :saleprice")})
//    @NamedQuery(name = "Product.findByNameOrCode",
//            query = "SELECT p FROM Product p "
//            + "WHERE p.nombre like :criteria or "
//            + "lower(p.code) like :criteria")})

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @Column(name = "stock")
    private BigDecimal stock;
    @Column(name = "minvalue")
    private BigDecimal minvalue;
    @Basic(optional = false)
    @Column(name = "active")
    private Boolean active;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "purchaseprice")
    private BigDecimal purchaseprice;
    @Column(name = "saleprice")
    private BigDecimal saleprice;
    @Column(name = "percentageiva")
    private BigDecimal percentageIva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private List<DetailBilling> detailBillingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private List<Inventary> inventaryList;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public BigDecimal getMinvalue() {
        return minvalue;
    }

    public void setMinvalue(BigDecimal minvalue) {
        this.minvalue = minvalue;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getEstado() {
        return (active) ? "Activo" : "Inactivo";
    }

    public BigDecimal getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(BigDecimal purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public BigDecimal getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(BigDecimal saleprice) {
        this.saleprice = saleprice;
    }

    public BigDecimal getPercentageIva() {
        return percentageIva;
    }

    public void setPercentageIva(BigDecimal percentageIva) {
        this.percentageIva = percentageIva;
    }

    @XmlTransient
    public List<DetailBilling> getDetailBillingList() {
        return detailBillingList;
    }

    public void setDetailBillingList(List<DetailBilling> detailBillingList) {
        this.detailBillingList = detailBillingList;
    }

    @XmlTransient
    public List<Inventary> getInventaryList() {
        return inventaryList;
    }

    public void setInventaryList(List<Inventary> inventaryList) {
        this.inventaryList = inventaryList;
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
        return "entities.Product[ id=" + id + " ]";
    }

}
