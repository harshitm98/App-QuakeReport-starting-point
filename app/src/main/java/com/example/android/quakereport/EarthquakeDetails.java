package com.example.android.quakereport;

/**
 * Created by Harshit Maheshwari on 03-07-2017.
 */
public class EarthquakeDetails {

    private double mMag;

    private String mLocation;

    private String mTime;

    public EarthquakeDetails(double vMag, String vLocation, String vTime){
        mMag = vMag;
        mLocation = vLocation;
        mTime = vTime;
    }

    public String getMag(){
        return "" + mMag;
    }

    public String getLocation(){
        return mLocation;
    }

    public String getmTime(){
        return mTime;
    }


}
