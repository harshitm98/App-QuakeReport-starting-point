package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.quakereport.EarthquakeDetails;
import com.example.android.quakereport.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Harshit Maheshwari on 03-07-2017.
 */
public class WordAdapter extends ArrayAdapter<EarthquakeDetails> {


    public WordAdapter(Activity context, ArrayList<EarthquakeDetails> objects) {
        super(context, 0 , objects);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.layout_item, parent, false);
        }

        EarthquakeDetails earthquakeDetails = getItem(position);

        TextView magText = (TextView) listItemView.findViewById(R.id.mag);
        magText.setText(earthquakeDetails.getMag());

        TextView locationText = (TextView) listItemView.findViewById(R.id.location);
        locationText.setText(earthquakeDetails.getLocation());

        TextView timeText = (TextView) listItemView.findViewById(R.id.times);
        timeText.setText(earthquakeDetails.getmTime());

        return listItemView;
    }
}

