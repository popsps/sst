package com.ss.utopia.service;

import com.ss.utopia.dao.BookingDao;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.BookingId;
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
        return bookingDao.findAll();
    }

    public Booking makeABooking(Booking booking) {
        return bookingDao.save(booking);
    }

    public Booking getMyBooking(Long booker_id, Long booking_id) {
        return bookingDao.findById(new BookingId(booker_id, booking_id))
                .orElse(null);
    }

    public Booking payForMyBooking(Long id) {
        return null;
    }

    public void deleteMyBooking(Long bookerId, Long bookingId) {
        bookingDao.deleteById(new BookingId(bookerId, bookingId));
    }
}
