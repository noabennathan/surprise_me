package com.example.demo;
public class SurpriseMe {

    private Surprise type;
    private final String result;

    public SurpriseMe(Surprise surprise, String result) {
        this.type = surprise;
        this.result = result;
    }

    public Surprise getType() {
        return type;
    }

    public String getResult() {
        return result;
    }
}

