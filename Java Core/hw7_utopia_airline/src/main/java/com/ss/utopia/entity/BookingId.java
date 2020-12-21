package com.ss.utopia.entity;

import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.Objects;


public class BookingId implements Serializable {
    private long bookingId;
    private long bookerId;

    public BookingId() {
    }

    public BookingId(long bookerId) {
        this.bookerId = bookerId;
    }

    public BookingId(long bookerId, long bookingId) {
        this.bookingId = bookingId;
        this.bookerId = bookerId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingId bookingId1 = (BookingId) o;
        return bookingId == bookingId1.bookingId && bookerId == bookingId1.bookerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, bookerId);
    }
}
