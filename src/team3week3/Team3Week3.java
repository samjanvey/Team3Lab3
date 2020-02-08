package team3week3;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * Add your name here once you've cloned the repository
 *
 * Sam Janvey
 * Kristina Mantha
 * 
 * Greg Ramos
 */
public class Team3Week3 {

    public static void main(String[] args) throws IOException {
        // NOAA Dataset API Endpoint
        // Change this value to any API endpoint
        URL url = new URL("https://www.ncdc.noaa.gov/cdo-web/api/v2/datasets");
        String apiToken = "WNfaIizSBbltHBSITycOiRCEsVhlcEvS"; // API Request Token
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            // Open connection to API Endpoint
            connection.setDoOutput(true);
            connection.setRequestMethod("GET"); // Change to any HTTP method
            connection.setRequestProperty("Token", apiToken); // Add the API Token to the Request Header
            int responseCode = connection.getResponseCode();
            System.out.println("Response: " + responseCode); // 200 == OK

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Same as Week 1 - Create I/O reader
                try {
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    String response = in.readLine();
                    while (in.readLine() != null) {
                        if (response == null) {
                            System.err.println("Bad API response");
                        } else {
                            System.out.println(String.format(response));
                        }
                    }
                    in.close();

                    System.out.println(response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Something went wrong");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
            System.out.println("Connection Closed");
        }
    }

}
