package com.hotel.producer;

import com.hotel.dto.BookingQueue;
import com.hotel.factory.BookingRequestFactory;

public class Producer extends Thread {
    private BookingQueue bookingQueue;

    public Producer(String name, BookingQueue bookingQueue) {
        super(name);
        this.bookingQueue = bookingQueue;
    }

    @Override
    public void run() {//todo: set repat count
        while (true) {
            try {
                bookingQueue.offer(BookingRequestFactory.createRandomRequest());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
