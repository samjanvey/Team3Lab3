
package team3week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * Add your name here once you've cloned the repository
 * 
 * Sam Janvey
 * 
 * 
 */
public class Team3Week3 {

    public static void main(String[] args) throws MalformedURLException {
        // NOAA Dataset API Endpoint
        // Change this value to any API endpoint
        URL url = new URL("https://www.ncdc.noaa.gov/cdo-web/api/v2/datasets");
        String apiToken = "WNfaIizSBbltHBSITycOiRCEsVhlcEvS"; // API Request Token
        
        try {
            // Open connection to API Endpoint
            HttpURLConnection connection = (HttpURLConnection) url
                .openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("GET"); // Change to any HTTP method
            connection.setRequestProperty("Authorization", apiToken);
            
            // Same as Week 1 - Create I/O reader
            PrintStream out = new PrintStream(connection.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            out.println("GET " + "/" + " HTTP/1.0");
            out.println();
            
            String lineIn = in.readLine();
            while (lineIn != null) {
                System.out.println(lineIn);
                lineIn = in.readLine();
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
