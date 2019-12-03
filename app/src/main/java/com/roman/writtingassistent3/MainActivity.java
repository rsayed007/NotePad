package com.roman.writtingassistent3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    private Button      homeBtn_1;
    private Button      homeBtn_2;
    private Button      homeBtn_3;

    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,
                "ca-app-pub-5376079706371809~3812378426");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        /* Id inisialise*/
        homeBtn_1 = (Button) findViewById(R.id.homeBtn_1);
        homeBtn_2 = (Button) findViewById(R.id.homeBtn_2);
        homeBtn_3 = (Button) findViewById(R.id.homeBtn_3);

        /*Main to other activity */
        homeBtn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        homeBtn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNotes();
            }
        });
        homeBtn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLesson();
            }
        });

    }

    public void openActivity2(){
        Intent intent = new Intent(this, Intro.class);
        startActivity(intent);
    }
    public  void openNotes(){
        Intent intent = new Intent(this, Notes.class);
        startActivity(intent);
    }
    public  void openLesson(){
        Intent intent = new Intent(this, lesson.class);
        startActivity(intent);
    }


}
