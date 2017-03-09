package com.basharaq.expedia.deals;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelDealsRepository {

    public HotelDealsCollection getHotelDeals(String json) {
        Map main;

        try {
            main = (Map) (new JSONParser()).parse(json);
        } catch (ParseException e) {
            return null;
        } catch (Exception e) {
            return null;
        }

        if (main == null) {
            return null;
        }

        Map offerInfo = (Map) main.get("offerInfo");

        if (offerInfo == null) {
            return null;
        }

        Map offers = (Map) main.get("offers");

        if (offers == null) {
            return null;
        }

        List<Map> offersList = (List<Map>)offers.get("Hotel");
        List<HotelDeal> hotelDeals = new ArrayList<HotelDeal>();

        for (Map offer: offersList) {
            hotelDeals.add(this.createHotelDeal(offer));
        }

        Map dateRange = (Map) offersList.get(0).get("offerDateRange");

        return new HotelDealsCollection(
                (String) offerInfo.get("language"),
                (String) offerInfo.get("currency"),
                this.getFormattedDate((List<Long>)dateRange.get("travelStartDate")),
                this.getFormattedDate((List<Long>)dateRange.get("travelEndDate")),
                hotelDeals
        );
    }

    private HotelDeal createHotelDeal(Map offer) {
        //ideally, proper validation should be done here as well like above
        //however, i will avoid doing that now to keep things simple
        Map hotelInfo = (Map) offer.get("hotelInfo");
        Map priceInfo = (Map) offer.get("hotelPricingInfo");
        Map urgencyInfo = (Map) offer.get("hotelUrgencyInfo");
        Map hotelUrls = (Map) offer.get("hotelUrls");
        String hotelUrl = "";

        try {
            hotelUrl = java.net.URLDecoder.decode(
                    (String) hotelUrls.get("hotelInfositeUrl"),
                    "UTF-8"
            );
        } catch (UnsupportedEncodingException e) {
            //do nothing
        }

        Hotel hotel = new Hotel(
                (String) hotelInfo.get("hotelName"),
                (String) hotelInfo.get("description"),
                (String) hotelInfo.get("hotelStreetAddress"),
                (String) hotelInfo.get("hotelCity"),
                (String) hotelInfo.get("hotelCountryCode"),
                Double.parseDouble((String) hotelInfo.get("hotelStarRating")),
                (Double) hotelInfo.get("hotelGuestReviewRating"),
                (String) hotelInfo.get("hotelImageUrl"),
                hotelUrl
        );

        return new HotelDeal(
                hotel,
                Math.round((Double) priceInfo.get("totalPriceValue")),
                (urgencyInfo.get("almostSoldStatus")).equals("ALMOST_SOLD"),
                (Long) urgencyInfo.get("numberOfPeopleBooked"),
                (Long) urgencyInfo.get("numberOfPeopleViewing")
        );
    }

    private String getFormattedDate(List<Long> date) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(
                date.get(0).intValue(),
                date.get(1).intValue() - 1,
                date.get(2).intValue()
        );
        Date formattedDate = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMMM-yyyy");

        return formatter.format(formattedDate);
    }

}
