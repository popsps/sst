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
//        throw new ApiRequestException("no...");
        return bookingService.getAllBookings();
    }

    @PostMapping
    public Booking makeABooking(
            @RequestBody @Valid Booking booking) {
        return bookingService.makeABooking(booking);
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"");
    }

    @GetMapping("/{bookerId}")
    public List<Booking> getMyBookings(@PathVariable("bookerId") Long bookerId) {
        return bookingService.getMyBookings(bookerId);
    }

    @GetMapping("/{bookerId}/{bookingId}")
    public Booking getMyBooking(@PathVariable("bookerId") Long bookerId,
                                @PathVariable("bookingId") Long bookingId) {
        return bookingService.getMyBooking(bookerId, bookingId);
    }

    @PostMapping("/payment/{id}")
    public Booking payForMyBooking(@PathVariable("id") Long id) {
        return bookingService.payForMyBooking(id);
    }

    @DeleteMapping("/{bookerId}/{bookingId}")
    public void deleteMyBooking(@PathVariable("bookerId") Long bookerId,
                                @PathVariable("bookingId") Long bookingId) {
        bookingService.deleteMyBooking(bookerId, bookingId);
    }
}
