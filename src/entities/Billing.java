/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author macbookpro
 */
@Entity
@Table(name = "billing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Billing.findAll", query = "SELECT b FROM Billing b"),
    @NamedQuery(name = "Billing.findById", query = "SELECT b FROM Billing b WHERE b.id = :id"),
    @NamedQuery(name = "Billing.findByType", query = "SELECT b FROM Billing b WHERE b.type = :type"),
    @NamedQuery(name = "Billing.findBySubtotal", query = "SELECT b FROM Billing b WHERE b.subtotal = :subtotal"),
    @NamedQuery(name = "Billing.findByFilter",
            query = "SELECT b FROM Billing b"
            + " WHERE b.emissiondate between :startDate"
            + " and :endDate"
            + " and (b.clientProviderid.personId.passport like :rucci or"
            + " lower(b.number) like :numReceipt)"),
    @NamedQuery(name = "Billing.findByTaxes", query = "SELECT b FROM Billing b WHERE b.totaliva = :totaliva"),
    @NamedQuery(name = "Billing.findByTotal", query = "SELECT b FROM Billing b WHERE b.total = :total")})
@SuppressWarnings("ValidAttributes")
public class Billing implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billingId")
    private Collection<Account> accountCollection;
 

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "type")
    private String type;
    @Column(name = "emissiondate")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date emissiondate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "subtotal")
    private BigDecimal subtotal;
    @Column(name = "totaliva")
    private BigDecimal totaliva;
    @Column(name = "total")
    private BigDecimal total;
    @Column(name = "totaldiscount")
    private BigDecimal totaldiscount;
    @Column(name = "state")
    private String state;
    @Column(name = "sequential")
    private String sequential;
    @Column(name = "number")
    private String number;
    @Column(name = "emissionpoint_id")
    private Integer emissionpoint_id;
    @Column(name = "shop_id")
    private Integer shop_id;
    @JoinColumn(name = "clientProvider_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ClientProvider clientProviderid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billingId")
    private List<DetailBilling> detailBillingList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billingId")
    private List<Inventary> inventaryList;

    public Billing() {
    }

    public Billing(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getEmissiondate() {
        return emissiondate;
    }

    public void setEmissiondate(Date emissiondate) {
        this.emissiondate = emissiondate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotaldiscount() {
        return totaldiscount;
    }

    public void setTotaldiscount(BigDecimal totaldiscount) {
        this.totaldiscount = totaldiscount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSequential() {
        return sequential;
    }

    public void setSequential(String sequential) {
        this.sequential = sequential;
    }

    public BigDecimal getTotaliva() {
        return totaliva;
    }

    public void setTotaliva(BigDecimal totaliva) {
        this.totaliva = totaliva;
    }

    public Integer getEmissionpoint_id() {
        return emissionpoint_id;
    }

    public void setEmissionpoint_id(Integer emissionpoint_id) {
        this.emissionpoint_id = emissionpoint_id;
    }

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public ClientProvider getClientProviderid() {
        return clientProviderid;
    }

    public void setClientProviderid(ClientProvider clientProviderid) {
        this.clientProviderid = clientProviderid;
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
        if (!(object instanceof Billing)) {
            return false;
        }
        Billing other = (Billing) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Billing[ id=" + id + " ]";
    }

    public String getFecha() {
        return emissiondate.toString();
    }

    public String getCliente() {
        return clientProviderid.getNombres() + " " + clientProviderid.getApellidos();
    }

    public String getNumero() {
        return number;
    }

    public String getEstado() {
        return state;
    }

    @XmlTransient
    public Collection<Account> getAccountCollection() {
        return accountCollection;
    }

    public void setAccountCollection(Collection<Account> accountCollection) {
        this.accountCollection = accountCollection;
    }
 
}
