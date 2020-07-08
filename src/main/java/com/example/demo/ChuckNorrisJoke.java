package com.example.demo;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
/**
 * generates a random Chuck Norris joke West quote
 */

public class ChuckNorrisJoke {
    public static String generateJoke() throws IOException, JSONException {
        JSONObject json = JsonReader.readJsonFromUrl("https://api.chucknorris.io/jokes/random");
        String result = (String) json.get("value");
        return result;
    }
}

