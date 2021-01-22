package com.hotel.service;

import com.hotel.dto.BookingQueue;
import com.hotel.factory.BookingRequestFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends Thread {
    private BookingQueue bookingQueue;
    private static final AtomicInteger SHOULD_REPEAT = new AtomicInteger(15);
    private static final AtomicInteger REPEAT_COUNT = new AtomicInteger(0);

    public Producer(String name, BookingQueue bookingQueue) {
        super(name);
        this.bookingQueue = bookingQueue;
    }

    @Override
    public void run() {
        try {
            while (REPEAT_COUNT.intValue() < SHOULD_REPEAT.intValue()) {
                REPEAT_COUNT.incrementAndGet();
                bookingQueue.offer(BookingRequestFactory.createRandomRequest());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
