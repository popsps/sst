package com.ss.utopia.service;

import com.ss.utopia.dao.BookingDao;
import com.ss.utopia.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingDao bookingDao;

    @Autowired
    public BookingService(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    public List<Booking> getAllBookings() {
        return null;
    }

    public List<Booking> makeABooking() {
    }

    public Booking getMyBooking(Long id) {
    }

    public Booking payForMyBooking(Long id) {
    }

    public Booking deleteMyBooking(Long id) {
    }
}
