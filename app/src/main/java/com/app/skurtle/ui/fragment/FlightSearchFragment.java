package com.app.skurtle.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.skurtle.R;
import com.app.skurtle.model.FlightModel;
import com.app.skurtle.rest.RetrofitApi;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by brando on 8/16/16.
 */
public class FlightSearchFragment extends Fragment {

    @BindView(R.id.flight_search_airline_text)
    EditText airlineText;
    @BindView(R.id.flight_search_flight_number_text)
    EditText flightNumberText;
    @BindView(R.id.flight_search_date_text)
    EditText dateText;
    @BindView(R.id.flight_search_loading)
    ProgressBar searchLoading;

    private Unbinder unbinder;

    OnResultsFoundListener mCallback;

    // Container Activity must implement this interface
    public interface OnResultsFoundListener {
        public void showResultsFragment(String airlineName, String carrierCode, String flightNumber, String arrCity, String arrCityCode, String depCity, String depCityCode, String arrivalTime, String departureTime, String status);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_flight_search, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnResultsFoundListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }


    @OnClick(R.id.flight_search_button)
    void searchForFlight() {
        if (airlineText.getText().toString().isEmpty()) {
            airlineText.setError(getString(R.string.airline_error));
        }
        else if (flightNumberText.getText().toString().isEmpty()) {
            flightNumberText.setError(getString(R.string.flight_error));
            flightNumberText.requestFocus();
        }
        else if (dateText.getText().toString().isEmpty()) {
            dateText.setError(getString(R.string.date_error));
            dateText.requestFocus();
        } else {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.flightstats.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            RetrofitApi retrofitApi = retrofit.create(RetrofitApi.class);

            Call<FlightModel> call2 = retrofitApi.getFlightStatus(airlineText.getText().toString(), flightNumberText.getText().toString(), dateText.getText().toString(), "91b929e6", "2eebba75c50ce13c31b9ef0b331fb93a");
            call2.enqueue(new Callback<FlightModel>() {
                @Override
                public void onResponse(Call<FlightModel> call, Response<FlightModel> response) {
                    FlightModel flightModel = response.body();
                    if (flightModel == null || flightModel.flightStatuses.size() == 0) {
                        new android.support.v7.app.AlertDialog.Builder(getActivity())
                                .setTitle("Sorry")
                                .setMessage("No Results found. Please Adjust your search terms and try again.")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .show();
                    } else  {
                     mCallback.showResultsFragment(flightModel.appendix.airlines.get(flightModel.flightStatuses.get(0).carrierFsCode.toString()).name,
                             flightModel.flightStatuses.get(0).carrierFsCode, flightModel.flightStatuses.get(0).flightNumber,
                             flightModel.appendix.airports.get(0).city,flightModel.appendix.airports.get(0).cityCode,
                             flightModel.appendix.airports.get(1).city, flightModel.appendix.airports.get(1).cityCode,
                             flightModel.flightStatuses.get(0).operationalTimes.scheduledGateArrival.dateLocal,
                             flightModel.flightStatuses.get(0).operationalTimes.publishedDeparture.dateLocal,
                             flightModel.flightStatuses.get(0).status);
                    }

                }

                @Override
                public void onFailure(Call<FlightModel> call, Throwable t) {
                    System.out.println("Request failed");

                }
            });
        }
    }


}