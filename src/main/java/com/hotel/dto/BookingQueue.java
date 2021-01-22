package com.hotel.dto;

import org.slf4j.Logger;

import java.util.LinkedList;

public class BookingQueue {
    private Logger logger;
    private final LinkedList<BookingRequest> queue = new LinkedList<>();

    public BookingQueue(Logger logger) {
        this.logger = logger;
    }

    public synchronized void offer(BookingRequest element) throws InterruptedException {

        while (queue.size() == 5) {
            wait();
        }
        queue.offer(element);
        logger.info("{} sent {}", Thread.currentThread().getName(), element.getId());
        notifyAll();

    }

    public synchronized BookingRequest poll() throws InterruptedException {

        while (queue.isEmpty()) {
            wait();
        }
        BookingRequest request = queue.poll();
        logger.info("{} received {}", Thread.currentThread().getName(), request.getId());
        notifyAll();

        return request;
    }
}
