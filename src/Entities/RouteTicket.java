/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YavuzSelim
 */
@Entity
@Table(name = "ROUTE_TICKET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RouteTicket.findAll", query = "SELECT r FROM RouteTicket r")
    , @NamedQuery(name = "RouteTicket.findById", query = "SELECT r FROM RouteTicket r WHERE r.id = :id")
    , @NamedQuery(name = "RouteTicket.findByRouteId", query = "SELECT r FROM RouteTicket r WHERE r.routeId = :routeId")
    , @NamedQuery(name = "RouteTicket.findByPrice", query = "SELECT r FROM RouteTicket r WHERE r.price = :price")
    , @NamedQuery(name = "RouteTicket.findByFrom", query = "SELECT r FROM RouteTicket r WHERE r.from = :from")
    , @NamedQuery(name = "RouteTicket.findByTo", query = "SELECT r FROM RouteTicket r WHERE r.to = :to")
    , @NamedQuery(name = "RouteTicket.findByTravelDate", query = "SELECT r FROM RouteTicket r WHERE r.travelDate = :travelDate")})
public class RouteTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ROUTE_ID")
    private int routeId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Column(name = "FROM")
    private String from;
    @Column(name = "TO")
    private String to;
    @Column(name = "TRAVEL_DATE")
    @Temporal(TemporalType.DATE)
    private Date travelDate;
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Company companyId;
    @JoinColumn(name = "TICKET_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ticket ticketId;

    public RouteTicket() {
    }

    public RouteTicket(Integer id) {
        this.id = id;
    }

    public RouteTicket(Integer id, int routeId) {
        this.id = id;
        this.routeId = routeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public Company getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    public Ticket getTicketId() {
        return ticketId;
    }

    public void setTicketId(Ticket ticketId) {
        this.ticketId = ticketId;
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
        if (!(object instanceof RouteTicket)) {
            return false;
        }
        RouteTicket other = (RouteTicket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.RouteTicket[ id=" + id + " ]";
    }
    
}
