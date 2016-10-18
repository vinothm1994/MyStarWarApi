package com.example.vinoth.mystarwarapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vinoth on 17/10/16.
 */

public class AllStarShip {
    @SerializedName("count")
    private int count;
    @SerializedName("next")
    private String next;
    @SerializedName("previous")
    private String previous;
    @SerializedName("results")
    private List<StarShip>results;

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<StarShip> getResults() {

        return results;
    }
}
