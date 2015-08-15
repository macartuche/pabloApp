/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author macbookpro
 */
@Entity
@Table(name = "detailBilling")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailBilling.findAll", query = "SELECT d FROM DetailBilling d"),
    @NamedQuery(name = "DetailBilling.findById", query = "SELECT d FROM DetailBilling d WHERE d.id = :id"),
    @NamedQuery(name = "DetailBilling.findByQuantity", query = "SELECT d FROM DetailBilling d WHERE d.quantity = :quantity"),
    @NamedQuery(name = "DetailBilling.findByUnitaryPrice", query = "SELECT d FROM DetailBilling d WHERE d.unitaryPrice = :unitaryPrice"),
    @NamedQuery(name = "DetailBilling.findByTotal", query = "SELECT d FROM DetailBilling d WHERE d.total = :total"),
    @NamedQuery(name = "DetailBilling.findByDate", query = "SELECT d FROM DetailBilling d WHERE d.date = :date"),
    @NamedQuery(name = "DetailBilling.findByAutorizationCode", query = "SELECT d FROM DetailBilling d WHERE d.autorizationCode = :autorizationCode"),
    @NamedQuery(name = "DetailBilling.findByDateauthorization", query = "SELECT d FROM DetailBilling d WHERE d.dateauthorization = :dateauthorization")})
public class DetailBilling implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "quantity")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "unitaryPrice")
    private BigDecimal unitaryPrice;
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "autorizationCode")
    private String autorizationCode;
    @Column(name = "dateauthorization")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateauthorization;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "billing_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Billing billingId;

    public DetailBilling() {
    }

    public DetailBilling(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitaryPrice() {
        return unitaryPrice;
    }

    public void setUnitaryPrice(BigDecimal unitaryPrice) {
        this.unitaryPrice = unitaryPrice;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAutorizationCode() {
        return autorizationCode;
    }

    public void setAutorizationCode(String autorizationCode) {
        this.autorizationCode = autorizationCode;
    }

    public Date getDateauthorization() {
        return dateauthorization;
    }

    public void setDateauthorization(Date dateauthorization) {
        this.dateauthorization = dateauthorization;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Billing getBillingId() {
        return billingId;
    }

    public void setBillingId(Billing billingId) {
        this.billingId = billingId;
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
        if (!(object instanceof DetailBilling)) {
            return false;
        }
        DetailBilling other = (DetailBilling) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DetailBilling[ id=" + id + " ]";
    }
    
}
