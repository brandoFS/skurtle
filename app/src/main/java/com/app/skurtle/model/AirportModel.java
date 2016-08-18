package com.app.skurtle.model;


import com.google.gson.annotations.SerializedName;

//Model for Airport objects
public class AirportModel {

    @SerializedName("airport")
    public Airport airport;


    public class Airport {
        public String fs;
        public String iata;
        public String icao;
        public String faa;
        public String name;
        public String street1;
        public String street2;
        public String city;
        public String cityCode;
        public String stateCode;
        public String postalCode;
        public String countryCode;
        public String countryName;
        public String regionName;
        public String timeZoneRegionName;
        public String weatherZone;
        public String localTime;


    }
}
