package com.gkmohit.unknown.primenumbers;

/**
 * Created by AirUnknown on 15-09-15.
 */
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class ColorWheel {

    public static final String TAG = ColorWheel.class.getSimpleName();
    //TODO
    //Looking for more CSS Colors.
    //Code from Treehouse.
    public String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };
    public int getColor() {
        Log.d(TAG, "getColor() was called.");
        String color = new String();
        //Randomly select a fact
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mColors.length);
        color = mColors[randomNumber];
        int colorAsInt = Color.parseColor(color);
        Log.d(TAG, "Returning : " + color + " /" + colorAsInt);
        return colorAsInt;
    }


}

