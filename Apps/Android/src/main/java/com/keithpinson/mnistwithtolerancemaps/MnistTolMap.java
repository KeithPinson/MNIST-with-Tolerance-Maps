package com.keithpinson.mnistwithtolerancemaps;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.content.Context;
import android.util.Log;

import com.keithpinson.mnistwithtolerancemaps.Mnist;

/**
 *
 */

class MnistTolMap extends Mnist {

    boolean useTolMap(Context context) {

        boolean result = true;

        if (context != null) {
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
            result = sharedPref.getBoolean("useToleranceMap", true);
        }

        return result;
    }

    void setTolMap( boolean useTolMap, Context context) {
        if (context != null) {
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
            sharedPref.edit().putBoolean("useToleranceMap", useTolMap).apply();
        }
    }
}
