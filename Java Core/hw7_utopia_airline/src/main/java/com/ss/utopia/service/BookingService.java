package com.ss.utopia.service;

import com.ss.utopia.dao.BookingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private final BookingDao bookingDao;

    @Autowired
    public BookingService(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }
}
