package com.ss.utopia.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.service.BookingService;
import net.minidev.json.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author shayhoss
 * @SpringBootTest(classes = BookingController.class)
 * @ExtendWith(SpringExtension.class)
 * @WebMvcTest
 * @JsonTest - for testing the JSON marshalling and unmarshalling
 * @DataJpaTest - for testing the repository layer
 * @RestClientTests - for testing REST clients
 */

@WebMvcTest(BookingController.class)
public class BookingControllerTest {
    private final static String URI = "/api/bookings";
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BookingService bookingService;

    @Test
    void getAllBookings() {

    }

    @Test
    void makeABooking() throws Exception {
        Booking booking = new Booking(12, 234L,
                true, "543");
        Booking booking2 = new Booking(3412, 4L,
                true, "67");
        Booking booking3 = new Booking(1432, 234L,
                false, "67");
        List<Booking> bookingList = Arrays.asList(booking, booking2, booking3);
        given(bookingService.getAllBookings()).willReturn(bookingList);
        ObjectMapper objectMapper = new ObjectMapper();
        String bookingListString = objectMapper.writeValueAsString(bookingList);
        this.mockMvc
                .perform(MockMvcRequestBuilders.get(URI))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .json(bookingListString));
    }

    @Test
    void getMyBookings() throws Exception {
//        Booking booking = new Booking(12, 234L,
//                true, "343");
//        List<Booking> bookingList = Arrays.asList(booking);
//        given(bookingService.getAllBookings()).willReturn(bookingList);
//
//        this.mockMvc
//                .perform(MockMvcRequestBuilders.get("")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print()).andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.bookerId").value(1));
//    }

    }

    @Test
    void deleteMyBooking() {
    }
}