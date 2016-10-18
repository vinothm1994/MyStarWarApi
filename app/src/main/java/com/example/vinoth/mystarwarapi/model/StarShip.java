package com.example.vinoth.mystarwarapi.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by vinoth on 17/10/16.
 */

public class StarShip {
    @SerializedName("name")
    private String name;
    @SerializedName("model")
    private String model;
    @SerializedName("manufacturer")
    private String manufacturer;
    @SerializedName("cost_in_credits")
    private String cost_in_credits;
    @SerializedName("length")
    private String length;
    @SerializedName("max_atmosphering_speed")
    private String max_atmosphering_speed;

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCost_in_credits(String cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public void setMax_atmosphering_speed(String max_atmosphering_speed) {
        this.max_atmosphering_speed = max_atmosphering_speed;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public void setCargo_capacity(String cargo_capacity) {
        this.cargo_capacity = cargo_capacity;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public void setHyperdrive_rating(String hyperdrive_rating) {
        this.hyperdrive_rating = hyperdrive_rating;
    }

    public void setMGLT(String MGLT) {
        this.MGLT = MGLT;
    }

    @SerializedName("crew")

    private String crew;
    @SerializedName("passengers")
    private String passengers;
    @SerializedName("cargo_capacity")
    private String cargo_capacity;
    @SerializedName("consumables")
    private String consumables;
    @SerializedName("hyperdrive_rating")
    private String hyperdrive_rating;
    @SerializedName("MGLT")
    private String MGLT;

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCost_in_credits() {
        return cost_in_credits;
    }

    public String getLength() {
        return length;
    }

    public String getMax_atmosphering_speed() {
        return max_atmosphering_speed;
    }

    public String getCrew() {
        return crew;
    }

    public String getPassengers() {
        return passengers;
    }

    public String getCargo_capacity() {
        return cargo_capacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public String getHyperdrive_rating() {
        return hyperdrive_rating;
    }

    public String getMGLT() {
        return MGLT;
    }
}

