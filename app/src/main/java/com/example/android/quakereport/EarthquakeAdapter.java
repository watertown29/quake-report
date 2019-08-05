package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * @link EarthquakeAdapter is an ArrayAdapter that can provide the layout for each list
 * based on a data source, which is a list of @link Earthquake objects
 */

public class EarthquakeAdapter extends ArrayAdapter{

    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();

    private static final String LOCATION_SEPARATOR = " of ";

    /**
     * This is our own customer constructor
     * @param context
     * @param earthquakes
     */

    public EarthquakeAdapter (Activity context, List<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    /**
     * Provides a view for an adapter View
     * @param position
     * @param convertView
     * @param parent
     * @return View
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = (Earthquake) getItem(position);

        TextView magText = (TextView) listItemView.findViewById(R.id.magnitude_text);
        double magFull = currentEarthquake.getmMagnitude();
        DecimalFormat magFormatter = new DecimalFormat("0.0");
        String magForm = magFormatter.format(magFull);

        magText.setText(magForm);

        GradientDrawable magnitudeCircle = (GradientDrawable) magText.getBackground();
//        int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMagnitude());
        int magnitudeColor;

        int val = (int) Math.floor(currentEarthquake.getmMagnitude());

//        private int getMagnitudeColor(){
            switch (val) {
                case 1:
                    magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                    break;
                case 2:
                    magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
                    break;
                case 3:
                    magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
                    break;

                case 4:
                    magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
                    break;

                case 5:
                    magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
                    break;

                case 6:
                    magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
                    break;

                case 7:
                    magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
                    break;

                case 8:
                    magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
                    break;

                case 9:
                    magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
                    break;
                case 10:
                    magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                    break;
                default:
                    magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                    break;
            }
//        }

        magnitudeCircle.setColor(magnitudeColor);

        String fullLoc = currentEarthquake.getmLoc();

        String city;
        String offSet = "";

        if (fullLoc.contains(LOCATION_SEPARATOR)){
            String[] parts = fullLoc.split(LOCATION_SEPARATOR);
            offSet = parts[0] + LOCATION_SEPARATOR;
            city = parts[1];

        } else {
            offSet = getContext().getString(R.string.near_the);
            city = fullLoc;
        }

        TextView offText = (TextView) listItemView.findViewById(R.id.off_text);
        offText.setText(offSet);

        TextView locText = (TextView) listItemView.findViewById(R.id.loc_text);
        locText.setText(city);

        TextView dateText = (TextView) listItemView.findViewById(R.id.date_text);
        long timeInMilliseconds = currentEarthquake.getmDate();
        Date dateObject = new Date(timeInMilliseconds);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("LLL dd, yyyy");
        String dateToDisplay = dateFormatter.format(dateObject);

        dateText.setText(dateToDisplay);

        TextView timeText = (TextView) listItemView.findViewById(R.id.time_text);
        long timeInMseconds = currentEarthquake.getmDate();
        Date timeObject = new Date(timeInMseconds);
        SimpleDateFormat timeFormatter = new SimpleDateFormat("h:mm a");
        String timeToDisplay = timeFormatter.format(timeObject);

        timeText.setText(timeToDisplay);

        return listItemView;
    }
}
