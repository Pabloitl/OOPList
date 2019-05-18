package weatherapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* Sensitive information !!!
 Info: list.opproject@gmail.com
 whatever1928
 */

public class Weather{
    
    private static String apiKey = "&APPID=ddbd11a9ccc6800fbe3bc970e5dcfe18";

    public static float askTemp(String city) throws Exception{

        String
            apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=",
            units = "&units=metric";
        
        return parseTemp(sendGET(apiUrl + city + units + apiKey));
    }
    
    private static String sendGET(String request) throws Exception{
        URL url = new URL(request);
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if(conn.getResponseCode() != 200)
            throw new Exception("Failed getting weather\n"+
            "HTTP error code: " + conn.getResponseCode());

        BufferedReader input =
            new BufferedReader(new InputStreamReader(conn.getInputStream()));
        
        conn.disconnect();
        
        return input.readLine();
    }
    
    private static float parseTemp(String json){
        JSONObject toparse = new JSONObject(json);

        return toparse.getJSONObject("main").getFloat("temp");
    }
}
