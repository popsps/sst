package com.ss.utopia.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table
@IdClass(BookingId.class)
public class Booking {
    @Id
    @Column(nullable = false)
    @NonNull
    private Long bookerId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookingId;
    @NonNull
    private Boolean isActive;
    @NotBlank
    private String stripeId;

    public Booking() {
    }

    public Booking(long bookingId, @NonNull Long bookerId,
                   @NonNull Boolean isActive,
                   @NotBlank String stripeId) {
        this.bookingId = bookingId;
        this.bookerId = bookerId;
        this.isActive = isActive;
        this.stripeId = stripeId;
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

    @NonNull
    public Boolean getActive() {
        return isActive;
    }

    public void setActive(@NonNull Boolean active) {
        isActive = active;
    }

    public String getStripeId() {
        return stripeId;
    }

    public void setStripeId(String stripeId) {
        this.stripeId = stripeId;
    }
}

