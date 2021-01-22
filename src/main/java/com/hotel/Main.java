package com.hotel;

import com.hotel.dto.BookingQueue;
import com.hotel.producer.Producer;
import com.hotel.service.Booker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);

        BookingQueue bookingQueue = new BookingQueue(logger);

        Thread producer1 = new Producer("producer 1", bookingQueue);
        Thread producer2 = new Producer("producer 2", bookingQueue);
        Thread producer3 = new Producer("producer 3", bookingQueue);

        Thread booker1 = new Booker("booker 1", bookingQueue);
        Thread booker2 = new Booker("booker 2", bookingQueue);
        Thread booker3 = new Booker("booker 3", bookingQueue);
        Thread booker4 = new Booker("booker 4", bookingQueue);
        Thread booker5 = new Booker("booker 5", bookingQueue);
        Thread booker6 = new Booker("booker 6", bookingQueue);

        producer1.start();
        producer2.start();
        producer3.start();

        booker1.start();
        booker2.start();
        booker3.start();
        booker4.start();
        booker5.start();
        booker6.start();

    }

}
