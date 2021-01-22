package com.hotel.factory;

import com.hotel.dto.BookingRequest;

import java.time.LocalDate;
import java.util.Random;

public class BookingRequestFactory {
    private static Random random;

    private BookingRequestFactory() {
    }

    public static BookingRequest createRandomRequest() {
        if (random == null) {
            random = new Random();
        }

        return new BookingRequest(random.nextInt(100000), "RANDOM HOTEL", LocalDate.now(), LocalDate.of(2021, 8, 22));
    }
}
