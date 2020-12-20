package com.ss.utopia.entity;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table
public class Booking {
    @EmbeddedId
    private BookingId bookingId;
    private Boolean isActive;
    private String stripeId;


    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }


    public String getStripeId() {
        return stripeId;
    }

    public void setStripeId(String stripeId) {
        this.stripeId = stripeId;
    }

    public BookingId getBookingId() {
        return bookingId;
    }

    public void setBookingId(BookingId bookingId) {
        this.bookingId = bookingId;
    }
}

@Embeddable
class BookingId implements Serializable {
    private long bookingId;
    private long bookerId;

    public BookingId(long bookingId, long bookerId) {
        this.bookingId = bookingId;
        this.bookerId = bookerId;
    }

    public BookingId() {

    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }


    public long getBookerId() {
        return bookerId;
    }

    public void setBookerId(long bookerId) {
        this.bookerId = bookerId;
    }
}