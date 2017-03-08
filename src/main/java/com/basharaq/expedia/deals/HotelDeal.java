package com.basharaq.expedia.deals;

public class HotelDeal {

    private final Hotel hotel;
    private final long price;
    private final boolean almostSold;
    private final long numberOfPeopleBooked;
    private final long numberOfPeopleViewing;

    public HotelDeal(Hotel hotel, long price, boolean almostSold, long numberOfPeopleBooked, long numberOfPeopleViewing) {
        this.hotel = hotel;
        this.price = price;
        this.almostSold = almostSold;
        this.numberOfPeopleBooked = numberOfPeopleBooked;
        this.numberOfPeopleViewing = numberOfPeopleViewing;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public long getPrice() {
        return price;
    }

    public boolean isAlmostSold() {
        return almostSold;
    }

    public long getNumberOfPeopleBooked() {
        return numberOfPeopleBooked;
    }

    public long getNumberOfPeopleViewing() {
        return numberOfPeopleViewing;
    }

}
