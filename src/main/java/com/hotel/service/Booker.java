package com.hotel.service;

import com.hotel.dto.BookingQueue;

import java.util.concurrent.atomic.AtomicInteger;


public class Booker extends Thread {
    private BookingQueue bookingQueue;
    private static final AtomicInteger SHOULD_REPEAT = new AtomicInteger();
    private static final AtomicInteger REPEAT_COUNT = new AtomicInteger(0);

    public Booker(String name, BookingQueue bookingQueue, int shouldRepeat) {
        super(name);
        this.bookingQueue = bookingQueue;
        SHOULD_REPEAT.set(shouldRepeat);
    }


    @Override
    public void run() {
        try {
            while (REPEAT_COUNT.intValue() < SHOULD_REPEAT.intValue()) {

                REPEAT_COUNT.incrementAndGet();
                bookingQueue.poll();
                sleep(5000);

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
