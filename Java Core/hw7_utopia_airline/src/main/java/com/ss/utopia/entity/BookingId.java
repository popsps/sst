package com.ss.utopia.entity;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Embeddable
public class BookingId implements Serializable {
    @GeneratedValue
    private long bookingId;
    private long bookerId;

    public BookingId(long bookerId) {
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
