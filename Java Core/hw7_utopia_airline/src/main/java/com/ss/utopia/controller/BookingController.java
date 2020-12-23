package com.ss.utopia.controller;

import com.ss.utopia.entity.Booking;
import com.ss.utopia.service.BookingService;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/bookings")
public class BookingController {
  private final BookingService bookingService;

  @Autowired
  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }


  @GetMapping
  public List<Booking> getAllBookings() {
    try {
      return bookingService.getAllBookings();
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping
  public ResponseEntity<Booking> makeABooking(
      @RequestBody @Valid Booking booking) {
    try {
      var bookingDB = bookingService.makeABooking(booking);
      if (booking == null)
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      else
        return new ResponseEntity<>(bookingDB, HttpStatus.CREATED);
    } catch (JpaSystemException | DataIntegrityViolationException
        | NullPointerException | InvalidPropertyException e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/{bookerId}")
  public ResponseEntity<List<Booking>> getMyBookings(
      @PathVariable("bookerId") Long bookerId,
      @RequestParam(name = "bookingId", required = false)
          Long bookingId) {
    try {
      if (bookingId == null) {
        var myBookings = bookingService.getMyBookings(bookerId);
        if (myBookings == null)
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
          return new ResponseEntity<>(myBookings, HttpStatus.OK);
      } else {
        var booking = bookingService.getMyBooking(bookerId, bookingId);
        List<Booking> myBooking = new ArrayList<>();
        myBooking.add(booking);
        if (booking == null)
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
          return new ResponseEntity<>(myBooking, HttpStatus.OK);
      }

    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }


  @PostMapping("/payment/{id}")
  public Booking payForMyBooking(@PathVariable("id") Long id) {
    try {
      return bookingService.payForMyBooking(id);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/{bookerId}/{bookingId}")
  public void deleteMyBooking(@PathVariable("bookerId") Long bookerId,
                              @PathVariable("bookingId") Long bookingId) {
    try {
      bookingService.deleteMyBooking(bookerId, bookingId);
    } catch (EntityNotFoundException | EmptyResultDataAccessException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    } catch (Exception e) {
      e.printStackTrace();
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
  }
}

// Error Handling Strategies
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND,"");
//        throw new ApiRequestException("no...");
// =====================================================================
//    @GetMapping(produces = {"application/xml"})// only support xml