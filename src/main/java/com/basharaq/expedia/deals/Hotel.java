package com.basharaq.expedia.deals;

public class Hotel {

    private final String name;
    private final String description;
    private final String address;
    private final String city;
    private final String country;
    private final double starRating;
    private final double reviewRating;
    private final String imageUrl;
    private final String infoUrl;

    public Hotel(
            String name,
            String description,
            String address,
            String city,
            String country,
            double starRating,
            double reviewRating,
            String imageUrl,
            String infoUrl
    ) {

        this.name = name;
        this.description = description;
        this.address = address;
        this.city = city;
        this.country = country;
        this.starRating = starRating;
        this.reviewRating = reviewRating;
        this.imageUrl = imageUrl;
        this.infoUrl = infoUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public double getStarRating() {
        return starRating;
    }

    public double getReviewRating() {
        return reviewRating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getInfoUrl() {
        return infoUrl;
    }
}
