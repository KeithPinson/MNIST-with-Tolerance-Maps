package com.keithpinson.mnistwithtolerancemaps;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.keithpinson.mnistwithtolerancemaps.Mnist;

/**
 *
 */

class MnistTolMap extends Mnist {

    boolean useTolMap(android.content.Context context) {

        boolean result = false;

        if (context != null) {
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
//        sharedPref.getBoolean("")
        }

        return result;
    }
}
