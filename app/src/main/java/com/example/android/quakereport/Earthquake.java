package com.example.android.quakereport;

/**
 * @link Earthquake represents a single earthquake event.
 * Each object has three properties: magnitude, city, date
 */

public class Earthquake {

    //size of the earthquake magnitude
    private double mMagnitude;

    //nearest city
    private String mLoc;

    //date of the earthquake
    private long mDate;

    //url of the USGS page for that earthquake
    private String mEarthquakeUrl;

    /**
     * Create a new earthquake object
     * @param magnitude
     * @param city
     * @param date
     */
    public Earthquake(double magnitude, String city, long date, String earthquakeUrl)
    {
        mMagnitude = magnitude;
        mLoc = city;
        mDate = date;
        mEarthquakeUrl = earthquakeUrl;
    }

    //get the magnitude of the earthquake
    public double getmMagnitude(){
        return mMagnitude;
    }

    //get the nearest city of the earthquake
    public String getmLoc(){
        return mLoc;
    }

    //get the date of the earthquake
    public long getmDate(){
        return mDate;
    }

    //get the earthquake url
    public String getmEarthquakeUrl() { return mEarthquakeUrl;}


}
