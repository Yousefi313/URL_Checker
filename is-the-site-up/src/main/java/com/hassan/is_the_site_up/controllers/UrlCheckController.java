package com.hassan.is_the_site_up.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This controller handles HTTP requests to check whether a provided website URL is up or down.
 */
@RestController
public class UrlCheckController {

    // Constants for response messages
    private static final String SITE_IS_UP = "Site is up!";
    private static final String SITE_IS_DOWN = "Site is down!";
    private static final String INCORRECT_URL = "URL is incorrect!";

    /**
     * This method handles GET requests to the "/check" endpoint and checks the status of the given URL.
     *
     * @param url The URL to check
     * @return A string message indicating whether the site is up, down, or if the URL is incorrect
     */
    @GetMapping("/check")
    public String getUrlStatusMessage(@RequestParam String url) {
        String returnMessage = ""; // Holds the response message

        try {
            // Create a URL object and open an HTTP connection
            URL urlObj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();

            // Set the request method to "GET"
            conn.setRequestMethod("GET");

            // Connect to the URL and get the response code category (e.g., 2xx, 3xx, etc.)
            conn.connect();
            int responseCodeCategory = conn.getResponseCode() / 100;

            // Check if the response code category indicates the site is up (2xx or 3xx)
            returnMessage = (responseCodeCategory != 2 && responseCodeCategory != 3) ? SITE_IS_DOWN : SITE_IS_UP;

        } catch (MalformedURLException e) {
            // If the URL is invalid, return the "incorrect URL" message
            returnMessage = INCORRECT_URL;
        } catch (IOException e) {
            // If there's an I/O error (e.g., network issues), return the "site is down" message
            returnMessage = SITE_IS_DOWN;
        }

        // Return the appropriate message to the client
        return returnMessage;
    }
}
