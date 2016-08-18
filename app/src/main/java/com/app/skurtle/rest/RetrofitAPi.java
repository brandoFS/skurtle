package com.app.skurtle.rest;

import com.app.skurtle.model.AirportModel;
import com.app.skurtle.model.FlightModel;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;


/**
 * Created by brando on 8/12/16.
 */
public interface RetrofitApi {

    // Airport Status
    @GET("flex/airports/rest/v1/json/LAX/2016/08/14")
    Call<AirportModel> getAirportStatus(@Query("appId") String appId, @Query("appKey") String appKey);

    // Flight Status
    @GET("flex/flightstatus/rest/v2/json/flight/status/{airline}/{flightnum}/arr/{date}")
    Call<FlightModel> getFlightStatus(@Path("airline") String airline, @Path("flightnum") String flightNumber, @Path(value = "date", encoded = true)String date,  @Query("appId") String appId, @Query("appKey") String appKey);

}
