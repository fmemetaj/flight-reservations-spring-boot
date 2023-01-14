package com.example.demo.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Getter
public enum Airport {
    ISTANBUL(41.27559523585344, 28.73202786075612),
    ROME(41.79280640600638, 12.255197677473978),
    PARIS(48.96236047758658, 2.438322685123278),
    LONDON(51.47002227963273, -0.45442424840283596),
    TOKYO(35.54935826367351, 139.77990296999727);

    private Double latitude;
    private Double longitude;

    Airport(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static List<Airport> retainList(){
        List<Airport> airports = new ArrayList<>(EnumSet.allOf(Airport.class));
        return airports;
    }
}
