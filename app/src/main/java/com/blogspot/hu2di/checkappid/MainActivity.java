package com.blogspot.hu2di.checkappid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blogspot.hu2di.checkidlib.CheckAppID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CheckAppID(this,
                "https://raw.githubusercontent.com/hu2di/CheckAppID/master/Server/CheckAppIds.json",
                "hebitaxy@gmail.com")
                .execute();
    }
}
