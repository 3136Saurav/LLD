package entity;

import enums.SeatCategory;

public class Seat {
    long seatId;
    int seatNumber;
    Double price;
    SeatCategory seatCategory;

    public long getSeatId() {


        return seatId;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }
}
