package com.hotel.dto;

import java.time.LocalDate;

public class BookingRequest {
    private final long id;
    private final String hotel;
    private final LocalDate startDate;
    private final LocalDate finishDate;

    public BookingRequest(long id, String hotel, LocalDate startDate, LocalDate finishDate) {
        this.id = id;
        this.hotel = hotel;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public long getId() {
        return id;
    }

    public String getHotel() {
        return hotel;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }
}
