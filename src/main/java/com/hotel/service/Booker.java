package com.hotel.service;

import com.hotel.dto.BookingQueue;


public class Booker extends Thread {
    private BookingQueue bookingQueue;

    public Booker(String name, BookingQueue bookingQueue) {
        super(name);
        this.bookingQueue = bookingQueue;
    }


    @Override
    public void run() {
        try {
            while (true){
                bookingQueue.poll();
                sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
