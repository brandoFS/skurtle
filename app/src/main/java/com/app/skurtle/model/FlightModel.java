package com.app.skurtle.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

//Model for Flight Objects
public class FlightModel {


    @SerializedName("appendix")
    @Expose
    public Appendix appendix;
    @SerializedName("flightStatuses")
    @Expose
    public List<FlightStatus> flightStatuses = new ArrayList<FlightStatus>();

    public class Appendix {

        @SerializedName("airlines")
        @Expose
        public List<Airline> airlines = new ArrayList<Airline>();
        @SerializedName("airports")
        @Expose
        public List<Airport> airports = new ArrayList<Airport>();

    }

    public class Airport {

        @SerializedName("fs")
        @Expose
        public String fs;
        @SerializedName("iata")
        @Expose
        public String iata;
        @SerializedName("icao")
        @Expose
        public String icao;
        @SerializedName("faa")
        @Expose
        public String faa;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("street1")
        @Expose
        public String street1;
        @SerializedName("street2")
        @Expose
        public String street2;
        @SerializedName("city")
        @Expose
        public String city;
        @SerializedName("cityCode")
        @Expose
        public String cityCode;
        @SerializedName("stateCode")
        @Expose
        public String stateCode;
        @SerializedName("postalCode")
        @Expose
        public String postalCode;
        @SerializedName("countryCode")
        @Expose
        public String countryCode;
        @SerializedName("countryName")
        @Expose
        public String countryName;
        @SerializedName("regionName")
        @Expose
        public String regionName;
        @SerializedName("timeZoneRegionName")
        @Expose
        public String timeZoneRegionName;
        @SerializedName("weatherZone")
        @Expose
        public String weatherZone;
        @SerializedName("localTime")
        @Expose
        public String localTime;
        @SerializedName("utcOffsetHours")
        @Expose
        public Integer utcOffsetHours;
        @SerializedName("latitude")
        @Expose
        public Double latitude;
        @SerializedName("longitude")
        @Expose
        public Double longitude;
        @SerializedName("elevationFeet")
        @Expose
        public Integer elevationFeet;
        @SerializedName("classification")
        @Expose
        public Integer classification;
        @SerializedName("active")
        @Expose
        public Boolean active;
        @SerializedName("delayIndexUrl")
        @Expose
        public String delayIndexUrl;
        @SerializedName("weatherUrl")
        @Expose
        public String weatherUrl;

    }

    public class Airline {

        @SerializedName("fs")
        @Expose
        public String fs;
        @SerializedName("iata")
        @Expose
        public String iata;
        @SerializedName("icao")
        @Expose
        public String icao;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("phoneNumber")
        @Expose
        public String phoneNumber;
        @SerializedName("active")
        @Expose
        public Boolean active;

    }


    public class FlightStatus {

        @SerializedName("flightId")
        @Expose
        public Integer flightId;
        @SerializedName("carrierFsCode")
        @Expose
        public String carrierFsCode;
        @SerializedName("flightNumber")
        @Expose
        public String flightNumber;
        @SerializedName("departureAirportFsCode")
        @Expose
        public String departureAirportFsCode;
        @SerializedName("arrivalAirportFsCode")
        @Expose
        public String arrivalAirportFsCode;
        @SerializedName("departureDate")
        @Expose
        public DepartureDate departureDate;
        @SerializedName("arrivalDate")
        @Expose
        public ArrivalDate arrivalDate;
        @SerializedName("status")
        @Expose
        public String status;
        @SerializedName("operationalTimes")
        @Expose
        public OperationalTimes operationalTimes;
        @SerializedName("airportResources")
        @Expose
        public AirportResources airportResources;

    }


    public class AirportResources {

        @SerializedName("departureTerminal")
        @Expose
        public String departureTerminal;
        @SerializedName("departureGate")
        @Expose
        public String departureGate;
        @SerializedName("arrivalTerminal")
        @Expose
        public String arrivalTerminal;
        @SerializedName("arrivalGate")
        @Expose
        public String arrivalGate;

    }


    public class OperationalTimes {

        @SerializedName("publishedDeparture")
        @Expose
        public PublishedDeparture publishedDeparture;
        @SerializedName("publishedArrival")
        @Expose
        public PublishedArrival publishedArrival;

        @SerializedName("scheduledGateArrival")
        @Expose
        public ScheduledGateArrival scheduledGateArrival;
        @SerializedName("estimatedGateArrival")
        @Expose
        public EstimatedGateArrival estimatedGateArrival;


    }

    public class PublishedDeparture {
        public String dateLocal;
        public String dateUtc;
    }

    public class PublishedArrival {
        public String dateLocal;
        public String dateUtc;
    }

    public class ScheduledGateArrival {
        public String dateLocal;
        public String dateUtc;
    }

    public class EstimatedGateArrival {
        public String dateLocal;
        public String dateUtc;
    }

    public class DepartureDate {

        public String dateLocal;
        public String dateUtc;

    }

    public class ArrivalDate {

        public String dateLocal;
        public String dateUtc;

    }

    public static String getStatus(String code) {
        switch (code) {
            case "S":
                return "Scheduled";
            case "A":
                return "Active";
            case "U":
                return "Unknown";
            case "R":
                return "Redirected";
            case "L":
                return "Landed";
            case "D":
                return "Diverted";
            case "C":
                return "Cancelled";
            case "NO":
                return "Not Operatonal";
            default:
                break;

        }
        return "Unknown";
    }

}

