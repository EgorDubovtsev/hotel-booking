package com.hotel;

import com.hotel.dto.BookingQueue;
import com.hotel.service.Booker;
import com.hotel.service.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {


    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        BookingQueue bookingQueue = new BookingQueue(logger);

        for (int i = 1; i <= 3; i++) {

            Thread producer = new Producer("producer " + i, bookingQueue);
            producer.start();
        }
        for (int i = 1; i <= 6; i++) {
            Thread booker = new Booker("booker " + i, bookingQueue);
            booker.start();
        }

    }

}
