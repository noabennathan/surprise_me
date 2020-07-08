package com.example.demo;

import java.util.Random;
/**
 * draws a random surprise and checks if the conditions are met
 * if the conditions doesn't hold, draw a new surprise
 */
public class WhichSurprise {
    public static Surprise surpriseArr[] = Surprise.values();
    public static Surprise surprise;


    public static Surprise whichSurprise(int birthYear, String name) {
        Boolean surpriseIsReady = false;
        while (!surpriseIsReady){
            surprise = chooseRandomSurprise();
            surpriseIsReady = checkConditions(birthYear, name, surprise);
        }
        return surprise;
    }

    public static Boolean checkConditions(int birthYear, String name, Surprise chosenSurprise) {
        if (chosenSurprise == Surprise.ChuckNorrisJoke){
            if (birthYear <= 2000){
                return true;
            }
        }
        if (chosenSurprise == Surprise.KanyeWestQuote){
            if ((birthYear > 2000) & !(name.charAt(0) == 'A' | name.charAt(0) == 'Z')){
                return true;
            }
        }
        if (chosenSurprise == Surprise.UserNameSum){
            if (name.charAt(0) != 'Q'){
                return true;
            }
        }
        return false;
    }
    public static Surprise chooseRandomSurprise() {
        Random rand = new Random();
        int randNum = rand.nextInt(surpriseArr.length);
        return surpriseArr[randNum];
    }
}
