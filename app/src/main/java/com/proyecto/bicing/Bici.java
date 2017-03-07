package com.proyecto.bicing;

/**
 * Created by alex on 21/02/2017.
 */

public class Bici {

    private String bikes,latitude,longitude,streetName,type;
    private int slots;

    public Bici() {
    }

    public String getBikes() {
        return bikes;
    }

    public void setBikes(String bikes) {
        this.bikes = bikes;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Bici{" +
                "bikes='" + bikes + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", slots='" + slots + '\'' +
                ", streetName='" + streetName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
