package com.example.demo;

public enum Surprise {
    ChuckNorrisJoke("chuck-norris-joke", 0),
    KanyeWestQuote("kanye-quote", 1),
    UserNameSum("name-sum", 2);

    public final String label;
    public final int id;

    Surprise(String label, int id) {
        this.label = label;
        this.id = id;
    }
}
