package com.blogspot.hu2di.checkidlib;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by HUNGDH on 3/24/2017.
 */

public class SharePref {

    private Context context;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String LAST_TIME = Build.LAST_TIME;

    private final String RESULT = Build.RESULT;

    public SharePref(Context context) {
        this.context = context;
    }

    public boolean isCheckDay() {
        if (getToday() == getLastTime()) {
            return true;
        } else {
            saveLastTime(getToday());
            return false;
        }
    }

    private int getToday() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd", Locale.US);
        String day = sdf.format(new Date());
        return Integer.parseInt(day);
    }

    private int getLastTime() {
        preferences = context.getSharedPreferences(LAST_TIME, Context.MODE_PRIVATE);
        return preferences.getInt(LAST_TIME, 0);
    }

    private void saveLastTime(int day) {
        preferences = context.getSharedPreferences(LAST_TIME, Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.clear();
        editor.putInt(LAST_TIME, day);
        editor.commit();
    }

    public String getResult() {
        preferences = context.getSharedPreferences(RESULT, Context.MODE_PRIVATE);
        return preferences.getString(RESULT, "");
    }

    public void saveResult(String s) {
        preferences = context.getSharedPreferences(RESULT, Context.MODE_PRIVATE);
        editor = preferences.edit();
        editor.clear();
        editor.putString(RESULT, s);
        editor.commit();
    }
}
