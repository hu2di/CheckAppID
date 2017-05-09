package com.blogspot.hu2di.checkidlib;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by HUNGDH on 3/24/2017.
 */

public class CheckAppID implements DownloadListener {

    private Context context = null;

    private String linkJSON = null;

    private String warningTitle = "Warning";
    private String warningContent = "Please Contact Us to Get your License!";
    private String sendText = "Send";

    private String emailAddress = null;
    private String subjectEmail = "GET LICENSE";
    private String bodyEmail = "Dear, ";
    private String warningNoEmail = "There are no email clients installed.";

    private CheckAppID() {

    }

    public CheckAppID(@NonNull Context context, @NonNull String linkJSON, @NonNull String emailAddress) {
        this.context = context;
        this.linkJSON = linkJSON;
        this.emailAddress = emailAddress;
    }

    public CheckAppID(@NonNull Context context, @NonNull String linkJSON,
                      @NonNull String warningTitle, @NonNull String warningContent,
                      @NonNull String sendText, @NonNull String emailAddress,
                      @NonNull String subjectEmail, @NonNull String bodyEmail, @NonNull String warningNoEmail) {
        this.context = context;
        this.linkJSON = linkJSON;
        this.warningTitle = warningTitle;
        this.warningContent = warningContent;
        this.sendText = sendText;
        this.emailAddress = emailAddress;
        this.subjectEmail = subjectEmail;
        this.bodyEmail = bodyEmail;
        this.warningNoEmail = warningNoEmail;
    }

    public void executeDayByDay() {
        SharePref sharePref = new SharePref(context);
        if (!sharePref.isCheckDay()) {
            getData();
        }
    }

    public void execute() {
        getData();
    }

    private void getData() {
        DownloadAsync downloadAsync = new DownloadAsync(this);
        downloadAsync.execute(linkJSON);
    }

    @Override
    public void onSuccess(String s) {
        if (s != null && !s.equals("")) {
            saveResult(s);
            checkAppId(s);
        } else {
            runCheck();
        }
    }

    private void saveResult(String s) {
        SharePref sharePref = new SharePref(context);
        sharePref.saveResult(s);
    }

    private void runCheck() {
        String s = new SharePref(context).getResult();
        if (s != null && !s.equals("")) {
            checkAppId(s);
        }
    }

    private void checkAppId(String s) {
        ArrayList<String> result = DownloadJSONParse.parseData(s);
        String appId = context.getPackageName();
        if (result.contains(appId)) {
            //Toast.makeText(context, "OK", Toast.LENGTH_SHORT).show();
            Log.d("myLog", "OK");
        } else {
            //Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show();
            Log.d("myLog", "ERROR");
            showDialog();
        }
    }

    private void showDialog() {
        new AlertDialog.Builder(context)
                .setTitle(warningTitle)
                .setMessage(warningContent)
                .setPositiveButton(sendText, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        showDialog();
                        sendEmail();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setCancelable(false)
                .show();
    }

    private void sendEmail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddress});
        i.putExtra(Intent.EXTRA_SUBJECT, subjectEmail);
        i.putExtra(Intent.EXTRA_TEXT, bodyEmail);
        try {
            context.startActivity(Intent.createChooser(i, sendText));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, warningNoEmail, Toast.LENGTH_SHORT).show();
        }
    }
}
