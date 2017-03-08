package com.basharaq.expedia.deals;

import javax.servlet.RequestDispatcher;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@javax.servlet.annotation.WebServlet(name = "Deals", urlPatterns = {"/deals"})
public class Deals extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        URL url = new URL("https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream())
        );

        String json = br.readLine();
        conn.disconnect();

        HotelDealsRepository repository = new HotelDealsRepository();
        HotelDealsCollection deals = repository.getHotelDeals(json);
        RequestDispatcher dispatcher;

        if (deals != null) {
            request.setAttribute("deals", deals);
            dispatcher = request
                    .getRequestDispatcher("/deals.jsp");
        } else {
            dispatcher = request
                    .getRequestDispatcher("/error.jsp");
        }

        if (dispatcher != null){
            dispatcher.forward(request, response);
        }
    }
}
