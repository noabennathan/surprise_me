package com.example.demo;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
/**
 * generates a random Kanye West quote
 */
public class KanyeWestQuote {
    public static String generateKanyeQuote() throws IOException, JSONException {
        JSONObject json = JsonReader.readJsonFromUrl("https://api.kanye.rest");
        String result = (String) json.get("quote");
//        String result = "this is check";
        return result;
    }
}

