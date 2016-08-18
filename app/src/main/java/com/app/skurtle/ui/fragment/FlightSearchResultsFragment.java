package com.app.skurtle.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.skurtle.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by brando on 8/16/16.
 */
public class FlightSearchResultsFragment extends Fragment {

    private Unbinder unbinder;

    public static FlightSearchResultsFragment newInstance(String airlineName, String carrierCode, String flightNumber, String arrCity, String arrCityCode, String depCity, String depCityCode, String arrivalTime, String departureTime, String status) {

        Bundle args = new Bundle();
       // args.putInt("ARG", arg);

        FlightSearchResultsFragment flightSearchResultsFragment = new FlightSearchResultsFragment();
        flightSearchResultsFragment.setArguments(args);
        return flightSearchResultsFragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_results, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }



    }
