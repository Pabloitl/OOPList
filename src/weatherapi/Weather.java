package weatherapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/*
 Info: list.opproject@gmail.com
 whatever1928
 */

public class Weather{

    public float getRequest(String city) throws Exception{

        String apiKey = "&APPID=ddbd11a9ccc6800fbe3bc970e5dcfe18",
               urlString = "http://api.openweathermap.org/data/2.5/weather?q=",
               units = "&units=metric";
        float response;
        
        URL url = new URL(urlString + city + units + apiKey);
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if(conn.getResponseCode() != 200)
            throw new RuntimeException("Failed getting weather\n"+
            "HTTP error code: " + conn.getResponseCode());

        BufferedReader input =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));

        JSONObject toparse = new JSONObject(input.readLine());

        response = toparse.getJSONObject("main").getFloat("temp");

        conn.disconnect();

        return response;
    }
}
