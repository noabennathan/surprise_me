package com.example.demo;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
/**
 * generates the statistics on preivios calls for the API
 * presents how many times each surprise was called
 */
@JsonPropertyOrder({ "request" })
public class Stats {
    private int requests;
    private StatsInfo[] distribution = new StatsInfo[3];
    public Stats(int requests, int[] requestDistribution){
        int i;
        this.requests = requests;
        Surprise arr[] = Surprise.values();
        if (requests != 0) {
            for (i = 0; i < SurpriseMeController.numOfSurprises; i++) {
                this.distribution[i] = new StatsInfo(arr[i].label, requestDistribution[i]);
            }
        }
        else{
            this.distribution = new StatsInfo[]{};
        }
    }
    public int getRequests(){
        return this.requests;
    }
    public StatsInfo[] getDistribution(){
        return this.distribution;
    }

    public class StatsInfo {
        private String type;
        private int count;

        public StatsInfo(String type,int count){
            this.type = type;
            this.count = count;
        }
        public int getCount(){
            return this.count;
        }
        public String getType(){
            return this.type;
        }
    }
}
