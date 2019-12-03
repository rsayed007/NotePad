package com.roman.writtingassistent3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Day4Task1 extends AppCompatActivity {
    TextView day4Task1;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day4_task1);

        MobileAds.initialize(this,
                "ca-app-pub-5376079706371809~3812378426");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        day4Task1 = findViewById(R.id.day_4_tsk1);
        day4Task1.setMovementMethod(new ScrollingMovementMethod());
    }
}
