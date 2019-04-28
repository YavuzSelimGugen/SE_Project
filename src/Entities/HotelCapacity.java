/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YavuzSelim
 */
@Entity
@Table(name = "HOTEL_CAPACITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HotelCapacity.findAll", query = "SELECT h FROM HotelCapacity h")
    , @NamedQuery(name = "HotelCapacity.findById", query = "SELECT h FROM HotelCapacity h WHERE h.id = :id")
    , @NamedQuery(name = "HotelCapacity.findByDailyCapacity", query = "SELECT h FROM HotelCapacity h WHERE h.dailyCapacity = :dailyCapacity")
    , @NamedQuery(name = "HotelCapacity.findByPrice", query = "SELECT h FROM HotelCapacity h WHERE h.price = :price")})
public class HotelCapacity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DAILY_CAPACITY")
    private Integer dailyCapacity;
    @Column(name = "PRICE")
    private Integer price;
    @JoinColumn(name = "HOTEL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Hotel hotelId;

    public HotelCapacity() {
    }

    public HotelCapacity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDailyCapacity() {
        return dailyCapacity;
    }

    public void setDailyCapacity(Integer dailyCapacity) {
        this.dailyCapacity = dailyCapacity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Hotel getHotelId() {
        return hotelId;
    }

    public void setHotelId(Hotel hotelId) {
        this.hotelId = hotelId;
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
        if (!(object instanceof HotelCapacity)) {
            return false;
        }
        HotelCapacity other = (HotelCapacity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.HotelCapacity[ id=" + id + " ]";
    }
    
}
