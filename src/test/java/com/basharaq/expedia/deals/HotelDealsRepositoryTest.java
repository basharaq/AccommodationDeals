package com.basharaq.expedia.deals;

import java.util.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class HotelDealsRepositoryTest {

    @Parameters
    public static Collection<Object[]> data() {
        Hotel hotel = new Hotel(
                "Muyan Suites",
                "Located in Fatih, this hotel is within a 5-minute walk of Hippodrome and Cemberlitas Bath. Grand Bazaar and Basilica Cistern are also within 10 minutes. ",
                "Binbirdirek Mah, Dizdariye Medresesi",
                "Istanbul",
                "TUR",
                4.0,
                4.6,
                "https://images.trvl-media.com/hotels/5000000/4790000/4783400/4783383/4783383_33_t.jpg",
                "http://deals.expedia.com/beta/hotel_redirect?gde_deep_link=http%253A%252F%252Fwww.expedia.com%252Fgo%252Fhotel%252Finfo%252F4783383%252F2017-04-08%252F2017-04-11%253FNumRooms%253D1%2526NumAdult-Room1%253D2%2526rateplanid%253D204548624_24%2526tpid%253D1%2526langid%253D1033&gde_index=2&gde_hash=7320258ca79516fbcf46df4f35c1ae69&gde_type=Hotel&gde_hotel=true&gde_hotel_id=4783383&gde_check_in_date=2017-04-08&gde_check_out_date=2017-04-11&gde_price=135.36"
        );
        HotelDeal deal = new HotelDeal(
                hotel,
                135,
                false,
                1,
                7
        );
        List<HotelDeal> dealsList = new ArrayList<HotelDeal>();
        dealsList.add(deal);

        HotelDealsCollection collection = new HotelDealsCollection(
                "en_US",
                "USD",
                "08-April-2017",
                "11-April-2017",
                dealsList
        );

        return Arrays.asList(new Object[][] {
                { "{invalid json", null },
                { "2", null },
                { "valid json but not valid response json", null },
                //valid case
                { "{\"offerInfo\":{\"siteID\":\"1\",\"language\":\"en_US\",\"currency\":\"USD\"},\"userInfo\":{\"persona\":{\"personaType\":\"OTHERS\"},\"userId\":\"foo\"},\"offers\":{\"Hotel\":[{\"offerDateRange\":{\"travelStartDate\":[2017,4,8],\"travelEndDate\":[2017,4,11],\"lengthOfStay\":3},\"destination\":{\"regionID\":\"178267\",\"longName\":\"Istanbul (and vicinity), Turkey\",\"country\":\"TUR\",\"province\":\"Istanbul\",\"city\":\"Istanbul\"},\"hotelInfo\":{\"hotelId\":\"4783383\",\"hotelName\":\"Muyan Suites\",\"hotelDestination\":\"Istanbul\",\"hotelDestinationRegionID\":\"178267\",\"hotelLongDestination\":\"Istanbul (and vicinity), Turkey\",\"hotelStreetAddress\":\"Binbirdirek Mah, Dizdariye Medresesi\",\"hotelCity\":\"Istanbul\",\"hotelProvince\":\"Istanbul\",\"hotelCountryCode\":\"TUR\",\"hotelLocation\":\"28.972127,41.006287\",\"hotelLatitude\":41.006287,\"hotelLongitude\":28.972127,\"hotelStarRating\":\"4.0\",\"hotelGuestReviewRating\":4.6,\"travelStartDate\":\"04/08/2017\",\"travelEndDate\":\"04/11/2017\",\"hotelImageUrl\":\"https://images.trvl-media.com/hotels/5000000/4790000/4783400/4783383/4783383_33_t.jpg\",\"carPackageScore\":2.6113,\"description\":\"Located in Fatih, this hotel is within a 5-minute walk of Hippodrome and Cemberlitas Bath. Grand Bazaar and Basilica Cistern are also within 10 minutes. \",\"distanceFromUser\":0,\"language\":\"en\",\"movingAverageScore\":-0.85,\"promotionAmount\":13.92,\"promotionDescription\":\"Save 10%\",\"promotionTag\":\"GDE\",\"rawAppealScore\":2.6113,\"relevanceScore\":0,\"statusCode\":\"0\",\"statusDescription\":\"\",\"carPackage\":false,\"allInclusive\":false},\"hotelUrgencyInfo\":{\"airAttachRemainingTime\":0,\"numberOfPeopleViewing\":7,\"numberOfPeopleBooked\":1,\"numberOfRoomsLeft\":0,\"lastBookedTime\":1489006152773,\"almostSoldStatus\":\"AVAILABLE\",\"link\":\"/Hotel-Search#selected=4783383\",\"almostSoldOutRoomTypeInfoCollection\":[],\"airAttachEnabled\":false},\"hotelPricingInfo\":{\"averagePriceValue\":41.78,\"totalPriceValue\":135.36,\"originalPricePerNight\":\"46.42\",\"hotelTotalBaseRate\":139.26,\"hotelTotalTaxesAndFees\":10.02,\"currency\":\"USD\",\"hotelTotalMandatoryTaxesAndFees\":0,\"percentSavings\":10,\"drr\":true},\"hotelUrls\":{\"hotelInfositeUrl\":\"http%3A%2F%2Fdeals.expedia.com%2Fbeta%2Fhotel_redirect%3Fgde_deep_link%3Dhttp%25253A%25252F%25252Fwww.expedia.com%25252Fgo%25252Fhotel%25252Finfo%25252F4783383%25252F2017-04-08%25252F2017-04-11%25253FNumRooms%25253D1%252526NumAdult-Room1%25253D2%252526rateplanid%25253D204548624_24%252526tpid%25253D1%252526langid%25253D1033%26gde_index%3D2%26gde_hash%3D7320258ca79516fbcf46df4f35c1ae69%26gde_type%3DHotel%26gde_hotel%3Dtrue%26gde_hotel_id%3D4783383%26gde_check_in_date%3D2017-04-08%26gde_check_out_date%3D2017-04-11%26gde_price%3D135.36\",\"hotelSearchResultUrl\":\"http%3A%2F%2Fdeals.expedia.com%2Fbeta%2Fhotel_redirect%3Fgde_deep_link%3Dhttp%25253A%25252F%25252Fwww.expedia.com%25252Fpubspec%25252Fscripts%25252Feap.asp%25253FGOTO%25253DHOTSEARCH%252526SearchType%25253DPlace%252526PlaceName%25253DIstanbul%25252C%252BIstanbul%25252C%252BTUR%252526InDate%25253D4%25252F8%25252F17%252526OutDate%25253D4%25252F11%25252F17%252526langid%25253D1033%26gde_index%3D2%26gde_hash%3D7320258ca79516fbcf46df4f35c1ae69%26gde_type%3DHotel%26gde_hotel%3Dtrue%26gde_hotel_id%3D4783383%26gde_check_in_date%3D2017-04-08%26gde_check_out_date%3D2017-04-11%26gde_price%3D135.36\"},\"hotelScores\":{\"rawAppealScore\":2.6113,\"movingAverageScore\":-0.85}}]}}", collection },
                //missing offers
                { "{\"offerInfo\":{\"siteID\":\"1\",\"language\":\"en_US\",\"currency\":\"USD\"},\"userInfo\":{\"persona\":{\"personaType\":\"OTHERS\"},\"userId\":\"foo\"}}", null },
                //missing offerInfo
                { "{\"userInfo\":{\"persona\":{\"personaType\":\"OTHERS\"},\"userId\":\"foo\"},\"offers\":{\"Hotel\":[{\"offerDateRange\":{\"travelStartDate\":[2017,4,8],\"travelEndDate\":[2017,4,11],\"lengthOfStay\":3},\"destination\":{\"regionID\":\"178267\",\"longName\":\"Istanbul (and vicinity), Turkey\",\"country\":\"TUR\",\"province\":\"Istanbul\",\"city\":\"Istanbul\"},\"hotelInfo\":{\"hotelId\":\"4783383\",\"hotelName\":\"Muyan Suites\",\"hotelDestination\":\"Istanbul\",\"hotelDestinationRegionID\":\"178267\",\"hotelLongDestination\":\"Istanbul (and vicinity), Turkey\",\"hotelStreetAddress\":\"Binbirdirek Mah, Dizdariye Medresesi\",\"hotelCity\":\"Istanbul\",\"hotelProvince\":\"Istanbul\",\"hotelCountryCode\":\"TUR\",\"hotelLocation\":\"28.972127,41.006287\",\"hotelLatitude\":41.006287,\"hotelLongitude\":28.972127,\"hotelStarRating\":\"4.0\",\"hotelGuestReviewRating\":4.6,\"travelStartDate\":\"04/08/2017\",\"travelEndDate\":\"04/11/2017\",\"hotelImageUrl\":\"https://images.trvl-media.com/hotels/5000000/4790000/4783400/4783383/4783383_33_t.jpg\",\"carPackageScore\":2.6113,\"description\":\"Located in Fatih, this hotel is within a 5-minute walk of Hippodrome and Cemberlitas Bath. Grand Bazaar and Basilica Cistern are also within 10 minutes. \",\"distanceFromUser\":0,\"language\":\"en\",\"movingAverageScore\":-0.85,\"promotionAmount\":13.92,\"promotionDescription\":\"Save 10%\",\"promotionTag\":\"GDE\",\"rawAppealScore\":2.6113,\"relevanceScore\":0,\"statusCode\":\"0\",\"statusDescription\":\"\",\"carPackage\":false,\"allInclusive\":false},\"hotelUrgencyInfo\":{\"airAttachRemainingTime\":0,\"numberOfPeopleViewing\":7,\"numberOfPeopleBooked\":1,\"numberOfRoomsLeft\":0,\"lastBookedTime\":1489006152773,\"almostSoldStatus\":\"AVAILABLE\",\"link\":\"/Hotel-Search#selected=4783383\",\"almostSoldOutRoomTypeInfoCollection\":[],\"airAttachEnabled\":false},\"hotelPricingInfo\":{\"averagePriceValue\":41.78,\"totalPriceValue\":135.36,\"originalPricePerNight\":\"46.42\",\"hotelTotalBaseRate\":139.26,\"hotelTotalTaxesAndFees\":10.02,\"currency\":\"USD\",\"hotelTotalMandatoryTaxesAndFees\":0,\"percentSavings\":10,\"drr\":true},\"hotelUrls\":{\"hotelInfositeUrl\":\"http%3A%2F%2Fdeals.expedia.com%2Fbeta%2Fhotel_redirect%3Fgde_deep_link%3Dhttp%25253A%25252F%25252Fwww.expedia.com%25252Fgo%25252Fhotel%25252Finfo%25252F4783383%25252F2017-04-08%25252F2017-04-11%25253FNumRooms%25253D1%252526NumAdult-Room1%25253D2%252526rateplanid%25253D204548624_24%252526tpid%25253D1%252526langid%25253D1033%26gde_index%3D2%26gde_hash%3D7320258ca79516fbcf46df4f35c1ae69%26gde_type%3DHotel%26gde_hotel%3Dtrue%26gde_hotel_id%3D4783383%26gde_check_in_date%3D2017-04-08%26gde_check_out_date%3D2017-04-11%26gde_price%3D135.36\",\"hotelSearchResultUrl\":\"http%3A%2F%2Fdeals.expedia.com%2Fbeta%2Fhotel_redirect%3Fgde_deep_link%3Dhttp%25253A%25252F%25252Fwww.expedia.com%25252Fpubspec%25252Fscripts%25252Feap.asp%25253FGOTO%25253DHOTSEARCH%252526SearchType%25253DPlace%252526PlaceName%25253DIstanbul%25252C%252BIstanbul%25252C%252BTUR%252526InDate%25253D4%25252F8%25252F17%252526OutDate%25253D4%25252F11%25252F17%252526langid%25253D1033%26gde_index%3D2%26gde_hash%3D7320258ca79516fbcf46df4f35c1ae69%26gde_type%3DHotel%26gde_hotel%3Dtrue%26gde_hotel_id%3D4783383%26gde_check_in_date%3D2017-04-08%26gde_check_out_date%3D2017-04-11%26gde_price%3D135.36\"},\"hotelScores\":{\"rawAppealScore\":2.6113,\"movingAverageScore\":-0.85}},{\"offerDateRange\":{\"travelStartDate\":[2017,4,8],\"travelEndDate\":[2017,4,11],\"lengthOfStay\":3},\"destination\":{\"regionID\":\"178267\",\"longName\":\"Istanbul (and vicinity), Turkey\",\"country\":\"TUR\",\"province\":\"Istanbul\",\"city\":\"Istanbul\"},\"hotelInfo\":{\"hotelId\":\"1461646\",\"hotelName\":\"Cosmopolitan Park Hotel\",\"hotelDestination\":\"Istanbul\",\"hotelDestinationRegionID\":\"178267\",\"hotelLongDestination\":\"Istanbul (and vicinity), Turkey\",\"hotelStreetAddress\":\"Sultanahmet, Cankurtaran Kutlugun Sk 16\",\"hotelCity\":\"Istanbul\",\"hotelProvince\":\"Istanbul\",\"hotelCountryCode\":\"TUR\",\"hotelLocation\":\"28.979605,41.005632\",\"hotelLatitude\":41.005632,\"hotelLongitude\":28.979605,\"hotelStarRating\":\"3.0\",\"hotelGuestReviewRating\":4.2,\"travelStartDate\":\"04/08/2017\",\"travelEndDate\":\"04/11/2017\",\"hotelImageUrl\":\"https://images.trvl-media.com/hotels/2000000/1470000/1461700/1461646/1461646_38_t.jpg\",\"carPackageScore\":5.4244,\"description\":\"Located in Fatih, this hotel is within a 5-minute walk of Mosaic Museum and Hagia Sophia. Basilica Cistern and Blue Mosque are also within 10 minutes. \",\"distanceFromUser\":0,\"language\":\"en\",\"movingAverageScore\":-0.86,\"promotionAmount\":0,\"promotionDescription\":\"\",\"promotionTag\":\"GDE\",\"rawAppealScore\":5.4244,\"relevanceScore\":0,\"statusCode\":\"0\",\"statusDescription\":\"\",\"carPackage\":false,\"allInclusive\":false},\"hotelUrgencyInfo\":{\"airAttachRemainingTime\":0,\"numberOfPeopleViewing\":2,\"numberOfPeopleBooked\":0,\"numberOfRoomsLeft\":0,\"lastBookedTime\":0,\"almostSoldStatus\":\"ALMOST_SOLD\",\"link\":\"/Hotel-Search#selected=1461646\",\"almostSoldOutRoomTypeInfoCollection\":[],\"airAttachEnabled\":false},\"hotelPricingInfo\":{\"averagePriceValue\":48.82,\"totalPriceValue\":158.16,\"originalPricePerNight\":\"48.82\",\"hotelTotalBaseRate\":146.46,\"hotelTotalTaxesAndFees\":11.7,\"currency\":\"USD\",\"hotelTotalMandatoryTaxesAndFees\":0,\"percentSavings\":0,\"drr\":false},\"hotelUrls\":{\"hotelInfositeUrl\":\"http%3A%2F%2Fdeals.expedia.com%2Fbeta%2Fhotel_redirect%3Fgde_deep_link%3Dhttp%25253A%25252F%25252Fwww.expedia.com%25252Fgo%25252Fhotel%25252Finfo%25252F1461646%25252F2017-04-08%25252F2017-04-11%25253FNumRooms%25253D1%252526NumAdult-Room1%25253D2%252526rateplanid%25253D203723852_24%252526tpid%25253D1%252526langid%25253D1033%26gde_index%3D1%26gde_hash%3D7320258ca79516fbcf46df4f35c1ae69%26gde_type%3DHotel%26gde_hotel%3Dtrue%26gde_hotel_id%3D1461646%26gde_check_in_date%3D2017-04-08%26gde_check_out_date%3D2017-04-11%26gde_price%3D158.16\",\"hotelSearchResultUrl\":\"http%3A%2F%2Fdeals.expedia.com%2Fbeta%2Fhotel_redirect%3Fgde_deep_link%3Dhttp%25253A%25252F%25252Fwww.expedia.com%25252Fpubspec%25252Fscripts%25252Feap.asp%25253FGOTO%25253DHOTSEARCH%252526SearchType%25253DPlace%252526PlaceName%25253DIstanbul%25252C%252BIstanbul%25252C%252BTUR%252526InDate%25253D4%25252F8%25252F17%252526OutDate%25253D4%25252F11%25252F17%252526langid%25253D1033%26gde_index%3D1%26gde_hash%3D7320258ca79516fbcf46df4f35c1ae69%26gde_type%3DHotel%26gde_hotel%3Dtrue%26gde_hotel_id%3D1461646%26gde_check_in_date%3D2017-04-08%26gde_check_out_date%3D2017-04-11%26gde_price%3D158.16\"},\"hotelScores\":{\"rawAppealScore\":5.4244,\"movingAverageScore\":-0.86}}]}}", null },
        });
    }

    private String input;
    private HotelDealsCollection expected;

    public HotelDealsRepositoryTest(
            String input,
            HotelDealsCollection expected
    ) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void testGetHotelDeals() {
        HotelDealsCollection actual = (new HotelDealsRepository()).getHotelDeals(this.input);
        if (this.expected == null) {
            assertEquals(
                    this.expected, actual
            );
        } else {
            this.assertCollectionsEqual(this.expected, actual);
        }
    }

    private void assertCollectionsEqual(
            HotelDealsCollection expected,
            HotelDealsCollection actual
    ) {
        assertTrue(expected.getLanguage().equals(actual.getLanguage()));
        assertTrue(expected.getCurrency().equals(actual.getCurrency()));
        //and we continue like this for all properties and sub-objects
        //i will not do all because it is the same idea.
    }

}
