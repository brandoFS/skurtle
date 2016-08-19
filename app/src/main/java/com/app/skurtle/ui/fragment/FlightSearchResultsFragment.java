package com.app.skurtle.ui.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.skurtle.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by brando on 8/16/16.
 */
public class FlightSearchResultsFragment extends Fragment {

    @BindView(R.id.search_results_flight)
    TextView flightView;
    @BindView(R.id.search_results_depart_airport)
    TextView departAirportView;
    @BindView(R.id.search_results_depart_time)
    TextView departTimeView;
    @BindView(R.id.search_results_depart_gate)
    TextView departGateView;
    @BindView(R.id.search_results_arrive_airport)
    TextView arriveAirportView;
    @BindView(R.id.search_results_arrive_time)
    TextView arriveTimeView;
    @BindView(R.id.search_results_arrive_gate)
    TextView arriveGateView;
    @BindView(R.id.search_results_status)
    TextView statusView;

    BookCarListener mCallback;


    private Unbinder unbinder;

    public static FlightSearchResultsFragment newInstance(String airlineName, String carrierCode, String flightNumber, String arrCity, String arrCityCode, String depCity, String depCityCode, String arrivalTime, String departureTime, String arrivalGate, String departureGate, String arrivalTerminal, String departureTerminal, String status) {

        Bundle args = new Bundle();
        args.putString("airline_name", airlineName);
        args.putString("carrier_code", carrierCode);
        args.putString("flight_number", flightNumber);
        args.putString("arrival_city", arrCity);
        args.putString("arrival_city_code", arrCityCode);
        args.putString("arrival_time", arrivalTime);
        args.putString("arrival_terminal", arrivalTerminal);
        args.putString("arrival_gate", arrivalGate);
        args.putString("departure_city", depCity);
        args.putString("departure_city_code", depCityCode);
        args.putString("departure_time", departureTime);
        args.putString("departure_terminal", departureTerminal);
        args.putString("departure_gate", departureGate);
        args.putString("status", status);


        FlightSearchResultsFragment flightSearchResultsFragment = new FlightSearchResultsFragment();
        flightSearchResultsFragment.setArguments(args);
        return flightSearchResultsFragment;
    }

    // Container Activity must implement this interface
    public interface BookCarListener{
        public void carConfirmation(boolean confirmed);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_results, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupUi();
    }

    private void setupUi() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            flightView.setText("Flight" + " " + arguments.getString("carrier_code") + " " + arguments.getString("flight_number"));
            arriveAirportView.setText(arguments.getString("arrival_city_code") + " " + arguments.getString("arrival_city"));
            arriveTimeView.setText(arguments.getString("arrival_time"));
            departAirportView.setText(arguments.getString("departure_city_code") + " " + arguments.getString("departure_city"));
            departTimeView.setText(arguments.getString("departure_time"));
            statusView.setText("Status: " + arguments.getString("status"));
            arriveGateView.setText("Terminal: " + arguments.getString("arrival_terminal") + " Gate: " + arguments.getString("arrival_gate"));
            departGateView.setText("Terminal: " + arguments.getString("departure_terminal") + " Gate: " + arguments.getString("departure_gate"));
        }
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
            mCallback = (BookCarListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @OnClick(R.id.search_results_car_button)
    void bookCar(){
        new android.support.v7.app.AlertDialog.Builder(getActivity())
                .setTitle("Confirmation")
                .setMessage("Would you like to rent a Skurt for your arrival? Your car will be ready when you arrive and status updates are available in the push notification settings")
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        mCallback.carConfirmation(true);
                    }
                }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                mCallback.carConfirmation(false);
            }
        })
                .show();
    }


}
