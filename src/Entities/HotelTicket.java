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
@Table(name = "HOTEL_TICKET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HotelTicket.findAll", query = "SELECT h FROM HotelTicket h")
    , @NamedQuery(name = "HotelTicket.findById", query = "SELECT h FROM HotelTicket h WHERE h.id = :id")
    , @NamedQuery(name = "HotelTicket.findByCheckIn", query = "SELECT h FROM HotelTicket h WHERE h.checkIn = :checkIn")
    , @NamedQuery(name = "HotelTicket.findByCheckOut", query = "SELECT h FROM HotelTicket h WHERE h.checkOut = :checkOut")})
public class HotelTicket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CHECK_IN")
    @Temporal(TemporalType.DATE)
    private Date checkIn;
    @Column(name = "CHECK_OUT")
    @Temporal(TemporalType.DATE)
    private Date checkOut;
    @JoinColumn(name = "HOTEL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Hotel hotelId;
    @JoinColumn(name = "TICKET_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ticket ticketId;

    public HotelTicket() {
    }

    public HotelTicket(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
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
        if (!(object instanceof HotelTicket)) {
            return false;
        }
        HotelTicket other = (HotelTicket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HotelTicket[ id=" + id + " ]";
    }
    
}
