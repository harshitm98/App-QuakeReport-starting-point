package com.example.android.quakereport;

/**
 * Created by Harshit Maheshwari on 03-07-2017.
 */
public class EarthquakeDetails {

    private String mMag;

    private String mLocation;

    private long mTime;

    private String mUrl;

    public EarthquakeDetails(String vMag, String vLocation, long vTime, String vUrl){
        mMag = vMag;
        mLocation = vLocation;
        mTime = vTime;
        mUrl = vUrl;
    }

    public String getMag(){
        return  mMag;
    }

    public String getLocation(){
        return mLocation;
    }

    public long getmTime(){
        return mTime;
    }

    public String getUrl() { return mUrl; }


}
