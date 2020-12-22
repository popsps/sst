package com.ss.utopia.service;

import com.ss.utopia.dao.BookingDao;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.BookingId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BookingServiceTest {

    //    private BookingDao bookingDao = Mockito.mock(BookingDao.class);
    @Mock
    private BookingDao bookingDao;

    @Test
    @DisplayName("Test should pass when ...")
    void getAllBookings() {
        Booking booking = new Booking(12, 234L,
                true, "543");
        Booking booking2 = new Booking(3412, 4L,
                true, "67");
        Booking booking3 = new Booking(1432, 234L,
                false, "67");
        BookingService bookingService = new BookingService(bookingDao);
        var bookings = List.of(booking, booking2, booking3);
        Mockito.when(bookingDao.findAll())
                .thenReturn(bookings);
        var retrievedBookings = bookingService.getAllBookings();
        assertEquals(bookings, retrievedBookings);
    }

    @Test
    void makeABooking() {
        BookingService bookingService = new BookingService(bookingDao);
        Booking booking = new Booking(12, 234L,
                true, "543");
        Mockito.when(bookingDao.saveAndFlush(booking)).thenReturn(booking);
        var actualBooking = bookingService.makeABooking(booking);
        assertEquals(booking, actualBooking);
    }

    @Test
    void getMyBooking() {
    }

    @Test
    void deleteMyBooking() {
    }

    @Test
    void getMyBookings() {
        Booking booking = new Booking(123L, 34L, true, "343");
        var bookingId = new BookingId(123, 34);
        BookingService bookingService = new BookingService(bookingDao);
        Mockito.when(bookingDao.findById(bookingId))
                .thenReturn(Optional.of(booking));
        Booking retrievedBooking = bookingService.getMyBooking(123L, 34L);
        assertEquals(booking, retrievedBooking);
    }
}