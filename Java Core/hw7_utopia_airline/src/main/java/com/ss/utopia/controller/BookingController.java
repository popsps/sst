package com.ss.utopia.controller;

import com.ss.utopia.entity.Booking;
import com.ss.utopia.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

//    @GetMapping(produces = {"application/xml"})// only support xml
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping
    public Booking makeABooking(
            @RequestBody @Valid Booking booking) {
        return bookingService.makeABooking(booking);
    }

    @GetMapping("/{id}")
    public Booking getMyBooking(@PathVariable("id") Long id) {
        return bookingService.getMyBooking(id);
    }

    @PostMapping("/payment/{id}")
    public Booking payForMyBooking(@PathVariable("id") Long id) {
        return bookingService.payForMyBooking(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMyBooking(@PathVariable("id") Long id) {
        bookingService.deleteMyBooking(id);
    }
}
