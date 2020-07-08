package com.example.demo;

import java.util.HashMap;
/**
 * creates a dictionary that assigns each letter a value
 * sums the value of the name that is given
 */

public class UserNameSum {
    public static String generateNameSum(String name){
        String lowerName = name.toLowerCase();
        int i, currVal, sum = 0;
        char currChar;
        String result;
        HashMap<Character, Integer> dict = generateDict();
        for (i = 0; i < name.length(); i++){
            currChar = lowerName.charAt(i);
            currVal = dict.get(currChar);
            sum += currVal;
        }
        result = Integer.toString(sum);
        return result;
    }
    public static HashMap<Character, Integer> generateDict(){
        char ch;
        int j = 1;
        HashMap<Character, Integer> dict = new HashMap<>();
        for (ch = 'a'; ch <= 'z'; ch++){
            dict.put(ch,j);
            j++;
        }
        return dict;
    }
}
