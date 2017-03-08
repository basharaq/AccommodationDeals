<%@ page import="com.basharaq.expedia.deals.HotelDealsCollection" %>
<%@ page import="com.basharaq.expedia.deals.HotelDeal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <% HotelDealsCollection deals = (HotelDealsCollection) request.getAttribute("deals"); %>
        <div style="margin: 10px; width: 100%; text-align: center;">
            <h2>Hotels available from <%= deals.getStartDate() %> to <%= deals.getEndDate() %></h2>
        </div>

        <% for (HotelDeal deal: deals.getDeals()) { %>
            <div style="height: 120px; width: 90%; margin-bottom: 10px; border: solid 1px; border-color: darkgray; padding: 5px;">
                <div style="display: inline-block; float: left; margin-right: 10px; height: 100%; width: 10%;">
                    <a href="<%= deal.getHotel().getInfoUrl() %>"><img src="<%= deal.getHotel().getImageUrl() %>"></a>
                </div>
                <div style="display: inline-block; height: 100%; width: 60%; margin-right: 10px;">
                    <div style="margin-bottom: 10px"><%= deal.getHotel().getName() %></div>
                    <div style="margin-bottom: 10px"><%= deal.getHotel().getStarRating() %> star hotel</div>
                    <div style="margin-bottom: 10px"><%= deal.getHotel().getAddress() %>, <%= deal.getHotel().getCity() %>, <%= deal.getHotel().getCountry() %></div>
                    <div style="margin-bottom: 10px">Guest rating <%= deal.getHotel().getReviewRating() %></div>
                </div>
                <div style="display: inline-block; float:right; height: 100%; width: 25%; text-align: center">
                    <div style="margin-bottom: 10px;">
                        <%= deal.getPrice() %> <%= deals.getCurrency() %>
                    </div>
                    <% if (deal.isAlmostSold()) { %>
                        <div style="margin-bottom: 10px;">Almost Sold Out!</div>
                    <% } %>
                    <% if (deal.getNumberOfPeopleViewing() > 0) { %>
                        <div style="margin-bottom: 10px;"><%= deal.getNumberOfPeopleViewing() %> people viewing this</div>
                    <% } %>
                    <% if (deal.getNumberOfPeopleBooked() > 0) { %>
                    <div style="margin-bottom: 10px;"><%= deal.getNumberOfPeopleBooked() %> people booked this</div>
                    <% } %>
                </div>
            </div>
        <% } %>
    </body>
</html>
