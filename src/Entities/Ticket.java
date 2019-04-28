/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YavuzSelim
 */
@Entity
@Table(name = "TICKET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT t FROM Ticket t")
    , @NamedQuery(name = "Ticket.findById", query = "SELECT t FROM Ticket t WHERE t.id = :id")
    , @NamedQuery(name = "Ticket.findByPaymentType", query = "SELECT t FROM Ticket t WHERE t.paymentType = :paymentType")
    , @NamedQuery(name = "Ticket.findByDate", query = "SELECT t FROM Ticket t WHERE t.date = :date")
    , @NamedQuery(name = "Ticket.findByPaymentAmount", query = "SELECT t FROM Ticket t WHERE t.paymentAmount = :paymentAmount")
    , @NamedQuery(name = "Ticket.findByBonusPointEarned", query = "SELECT t FROM Ticket t WHERE t.bonusPointEarned = :bonusPointEarned")
    , @NamedQuery(name = "Ticket.findByUsedPoints", query = "SELECT t FROM Ticket t WHERE t.usedPoints = :usedPoints")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "PAYMENT_TYPE")
    private String paymentType;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PAYMENT_AMOUNT")
    private Double paymentAmount;
    @Column(name = "BONUS_POINT_EARNED ")
    private Double bonusPointEarned;
    @Column(name = "USED_POINTS")
    private Double usedPoints;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Customer customerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketId")
    private Collection<HotelTicket> hotelTicketCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketId")
    private Collection<RouteTicket> routeTicketCollection;

    public Ticket() {
    }

    public Ticket(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Double getBonusPointEarned() {
        return bonusPointEarned;
    }

    public void setBonusPointEarned(Double bonusPointEarned) {
        this.bonusPointEarned = bonusPointEarned;
    }

    public Double getUsedPoints() {
        return usedPoints;
    }

    public void setUsedPoints(Double usedPoints) {
        this.usedPoints = usedPoints;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @XmlTransient
    public Collection<HotelTicket> getHotelTicketCollection() {
        return hotelTicketCollection;
    }

    public void setHotelTicketCollection(Collection<HotelTicket> hotelTicketCollection) {
        this.hotelTicketCollection = hotelTicketCollection;
    }

    @XmlTransient
    public Collection<RouteTicket> getRouteTicketCollection() {
        return routeTicketCollection;
    }

    public void setRouteTicketCollection(Collection<RouteTicket> routeTicketCollection) {
        this.routeTicketCollection = routeTicketCollection;
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
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ticket[ id=" + id + " ]";
    }
    
}
