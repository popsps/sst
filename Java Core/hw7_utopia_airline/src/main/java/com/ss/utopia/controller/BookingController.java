package com.ss.utopia.controller;

import com.ss.utopia.entity.Booking;
import com.ss.utopia.exception.ApiRequestException;
import com.ss.utopia.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
//        throw new ApiRequestException("no...");
        return bookingService.getAllBookings();
    }

    @PostMapping
    public Booking makeABooking(
            @RequestBody @Valid Booking booking) {
        return bookingService.makeABooking(booking);
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"");
    }

    @GetMapping("/{booker_id}/{booking_id}")
    public Booking getMyBooking(@PathVariable("booker_id") Long booker_id,
                                @PathVariable("booking_id") Long booking_id) {
        return bookingService.getMyBooking(booker_id, booking_id);
    }

    @PostMapping("/payment/{id}")
    public Booking payForMyBooking(@PathVariable("id") Long id) {
        return bookingService.payForMyBooking(id);
    }

    @DeleteMapping("/{booker_id}/{booking_id}")
    public void deleteMyBooking(@PathVariable("booker_id") Long bookerId,
                                @PathVariable("booking_id") Long bookingId) {
        bookingService.deleteMyBooking(bookerId, bookingId);
    }
}
