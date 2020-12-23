package com.ss.utopia.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ss.utopia.entity.Booking;
import com.ss.utopia.entity.BookingId;
import com.ss.utopia.service.BookingService;
import net.minidev.json.parser.JSONParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
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

import javax.persistence.EntityNotFoundException;
import javax.print.attribute.standard.Media;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
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
  @DisplayName("Test to get all bookings")
  void getAllBookings() throws Exception {
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
  @DisplayName("Test to post a booking at /api/bookings")
  void makeABooking() throws Exception {
    Booking bookingToPost = new Booking(234L,
        true, "543");
    Booking bookingToReturn = new Booking(0, 234L,
        true, "543");
    //    given(bookingService.makeABooking(any())).willReturn(bookingToReturn);
    //    when(bookingService.makeABooking(bookingToPost)).thenReturn(bookingToReturn);
    doReturn(bookingToReturn).when(bookingService).makeABooking(any());

    ObjectMapper objectMapper = new ObjectMapper();
    String bookingString = objectMapper.writeValueAsString(bookingToPost);
    this.mockMvc
        .perform(MockMvcRequestBuilders.post(URI)
            .contentType(MediaType.APPLICATION_JSON)
            .content(bookingString)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andDo(mvcResult -> System.out.println(mvcResult.getResponse().getContentAsString()))
        .andExpect(MockMvcResultMatchers.content()
            .json(bookingString));


  }

  @Test
  @DisplayName("Test to get my bookings")
  void getMyBookings() throws Exception {
    Booking bookingToReturn = new Booking(12, 234L,
        true, "543");
    when(bookingService.getMyBookings(any())).thenReturn(List.of(bookingToReturn));
    ObjectMapper objectMapper = new ObjectMapper();
    String bookingString = objectMapper.writeValueAsString(List.of(bookingToReturn));
    this.mockMvc
        .perform(MockMvcRequestBuilders.get(URI + "/234")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andDo(mvcResult -> System.out.println(mvcResult.getResponse().getContentAsString()))
        .andExpect(MockMvcResultMatchers.content()
            .json(bookingString));
  }

  @Test
  @DisplayName("Test to delete a non-existent booking")
  void deleteMyBooking() throws Exception {
    Booking bookingToDelete = new Booking(234L,
        true, "543");
    Mockito.doThrow(EntityNotFoundException.class)
        .when(bookingService).deleteMyBooking(234L, 12L);

    this.mockMvc
        .perform(MockMvcRequestBuilders.delete(URI
            + "/{bookerId}/{bookingId}", 234, 12))
        .andExpect(status().isNotFound());
  }
}