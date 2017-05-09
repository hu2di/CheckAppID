package com.blogspot.hu2di.checkidlib;

import android.os.AsyncTask;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by HUNGDH on 3/24/2017.
 */

public class DownloadAsync extends AsyncTask<String, Void, String> {

    private DownloadListener listener = null;

    public DownloadAsync(DownloadListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... strings) {
        return downloadFile(strings[0]);
    }

    private String downloadFile(String url) {
        StringBuilder sb = new StringBuilder();
        InputStream inStream = null;
        try {
            URL link = new URL(url);
            inStream = link.openStream();
            int i;
            int total = 0;
            byte[] buffer = new byte[8 * 1024];
            while ((i = inStream.read(buffer)) != -1) {
                if (total >= (1024 * 1024)) {
                    return "";
                }
                total += i;
                sb.append(new String(buffer, 0, i));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
        return sb.toString();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        listener.onSuccess(s);
    }
}
