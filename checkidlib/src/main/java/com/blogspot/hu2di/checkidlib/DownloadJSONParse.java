package com.blogspot.hu2di.checkidlib;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by HUNGDH on 3/24/2017.
 */

public class DownloadJSONParse {

    public static ArrayList<String> parseData(String strData) {
        ArrayList<String> result = new ArrayList<String>();

        try {
            JSONObject root = new JSONObject(strData);
            JSONArray data = root.getJSONArray("data");
            for (int i = 0; i < data.length(); i++) {
                String packageName = data.getJSONObject(i).getString("package");
                result.add(packageName);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }

}
