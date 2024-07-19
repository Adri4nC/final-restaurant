package com.example.demo.service;

import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
    }

    public Booking updateBooking(Long id, Booking bookingDetails) {
        Booking existingBooking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));


        existingBooking.setidUser(bookingDetails.getidUser());
        existingBooking.setidRestaurant(bookingDetails.getidRestaurant());
        existingBooking.setdate(bookingDetails.getdate());
        existingBooking.settime(bookingDetails.gettime());
        existingBooking.setnumPeople(bookingDetails.getnumPeople());

        return bookingRepository.save(existingBooking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
