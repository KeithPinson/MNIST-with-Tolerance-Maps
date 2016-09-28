package com.keithpinson.mnistwithtolerancemaps;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.Context;
import android.util.Log;

import com.keithpinson.mnistwithtolerancemaps.Mnist;

/**
 *
 */

public class MnistAltStyles extends Mnist {
    boolean useAltStyles(Context context) {

        boolean result = false;

        if (context != null) {
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
            result = sharedPref.getBoolean("useAltStyles", false);
        }

        return result;
    }

    void setAltStyles( boolean useAltStyles, Context context) {
        if (context != null) {
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
            sharedPref.edit().putBoolean("useAltStyles", useAltStyles).apply();
        }
    }
}
