package com.basharaq.expedia.deals;

import java.util.List;

public class HotelDealsCollection {

    private final String language;
    private final String currency;
    private final String startString;
    private final String endString;
    private final List<HotelDeal> deals;

    public HotelDealsCollection(
            String language,
            String currency,
            String startString,
            String endString,
            List<HotelDeal> deals
    ) {
        this.language = language;
        this.currency = currency;
        this.startString = startString;
        this.endString = endString;
        this.deals = deals;
    }

    public String getLanguage() {
        return language;
    }

    public String getCurrency() {
        return currency;
    }

    public String getStartDate() {
        return startString;
    }

    public String getEndDate() {
        return endString;
    }

    public List<HotelDeal> getDeals() {
        return deals;
    }

}