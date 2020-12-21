package com.ss.utopia.service;

import com.ss.utopia.dao.BookingDao;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.BookingId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
        var AddedBooking = bookingDao.saveAndFlush(booking);
        return AddedBooking;
    }

    public Booking getMyBooking(Long bookerId, Long bookingId) {
        return bookingDao.findById(new BookingId(bookerId, bookingId))
                .orElse(null);
    }

    public Booking payForMyBooking(Long id) {
        return null;
    }

    public void deleteMyBooking(Long bookerId, Long bookingId) {
        bookingDao.deleteById(new BookingId(bookerId, bookingId));
    }

    public List<Booking> getMyBookings(Long bookerId) {
        return bookingDao.findByBookerId(bookerId);
    }
}
