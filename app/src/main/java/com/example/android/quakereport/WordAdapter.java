package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.quakereport.EarthquakeDetails;
import com.example.android.quakereport.R;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Harshit Maheshwari on 03-07-2017.
 */
public class WordAdapter extends ArrayAdapter<EarthquakeDetails> {


    public WordAdapter(Activity context, ArrayList<EarthquakeDetails> objects) {
        super(context, 0 , objects);
    }



    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }


    private int getMagnitudeColor(char magnitudeFloor) {
        int magnitudeColorResourceId;
        switch (magnitudeFloor) {
            case '0':
            case '1':
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case '2':
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case '3':
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case '4':
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case '5':
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case '6':
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case '7':
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case '8':
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case '9':
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.layout_item, parent, false);
        }

        EarthquakeDetails earthquakeDetails = getItem(position);

        TextView magText = (TextView) listItemView.findViewById(R.id.mag);

        String mag = earthquakeDetails.getMag();

        magText.setText(mag);

        int magnitudeColor = getMagnitudeColor(mag.charAt(0));

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magText.getBackground();
        magnitudeCircle.setColor(magnitudeColor);



        String location = earthquakeDetails.getLocation();

        int splitter = location.indexOf("of");

        String offsetString;
        String primaryString;

        if (splitter != -1) {
            offsetString = location.substring(0,splitter+2);
            primaryString = location.substring(splitter+3,location.length());
        }

        else{
            offsetString = "Near the";
            primaryString = location;
        }

        TextView offsetlocationText = (TextView) listItemView.findViewById(R.id.offset_location);
        offsetlocationText.setText(offsetString);

        TextView primaryLocationText = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryLocationText.setText(primaryString);




        Date dateObject = new Date(earthquakeDetails.getmTime());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.clock);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);





        return listItemView;
    }
}

