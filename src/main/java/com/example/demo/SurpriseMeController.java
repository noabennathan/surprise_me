package com.example.demo;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.io.IOException;

import org.springframework.web.bind.MissingServletRequestParameterException;

@RestController
public class SurpriseMeController {
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleMissingParams(MissingServletRequestParameterException ex) {
        String parameterName = ex.getParameterName();
        return String.format("'%s' parameter is missing", parameterName);
    }
    private Surprise surprise = null;
    public static int numOfSurprises  = Surprise.values().length;
    private int[] counter = new int[numOfSurprises];
    /**chooses a random surprise under the conditions and returns it*/
        @GetMapping("/surprise")
    public SurpriseMe surpriseMe(@RequestParam(value = "name") String name,
                               @RequestParam(value = "birth_year") int birthYear)
                                throws IOException, JSONException {
                String result = null;
                surprise = WhichSurprise.whichSurprise(birthYear, name);
                counter[surprise.id]++;
                if (surprise == Surprise.ChuckNorrisJoke) {
                    result = ChuckNorrisJoke.generateJoke();
                }
                if (surprise == Surprise.KanyeWestQuote) {
                    result = KanyeWestQuote.generateKanyeQuote();
                }
                if (surprise == Surprise.UserNameSum) {
                    result = UserNameSum.generateNameSum(name);
                }
                return new SurpriseMe(surprise, result);
        }

    /**collect all information to the distribution array and returning a new stats object */
    @GetMapping("/stats")
    public Stats Stats(){
        int requests = 0;
        int[] distribution = new int[numOfSurprises];
        for (int i =0; i< numOfSurprises; i++){
            requests += counter[i];
            distribution[i] = counter[i];
        }
        return new Stats(requests, distribution);
    }
}
