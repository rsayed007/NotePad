package com.roman.writtingassistent3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class lesson extends AppCompatActivity {

    private ListView lessonList;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        MobileAds.initialize(this,
                "ca-app-pub-5376079706371809~3812378426");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        if(!isConnected(this)) buildDialog(this).show();
        else {
            Toast.makeText(this,"Welcome to da  ", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_lesson);
        }

        lessonList = (ListView) findViewById(R.id.lessonList);

        final String[] lessionList = getResources().getStringArray(R.array.lesson_list);

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,R.layout.activity_list,R.id.customList,lessionList);
        lessonList.setAdapter(adapter);

        lessonList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = lessionList[position];
                Toast.makeText(lesson.this,value,Toast.LENGTH_SHORT).show();

                if (position == 0){
                    Intent intent = new Intent(lesson.this,Day01.class);
                    startActivity(intent);
                }
                if (position == 1){
                    Intent intent = new Intent(lesson.this,Day02.class);
                    startActivity(intent);
                }
                if (position == 2){
                    Intent intent = new Intent(lesson.this,Day03.class);
                    startActivity(intent);
                }
                if (position == 3){
                    Intent intent = new Intent(lesson.this,Day04.class);
                    startActivity(intent);
                }
                if (position == 4){
                    Intent intent = new Intent(lesson.this,Day05.class);
                    startActivity(intent);
                }
                if (position == 5){
                    Intent intent = new Intent(lesson.this,Day06.class);
                    startActivity(intent);
                }
                if (position == 6){
                    Intent intent = new Intent(lesson.this,Day07.class);
                    startActivity(intent);
                }if (position == 7){
                    Intent intent = new Intent(lesson.this,Day08.class);
                    startActivity(intent);
                }if (position == 8){
                    Intent intent = new Intent(lesson.this,Day09.class);
                    startActivity(intent);
                }if (position == 9){
                    Intent intent = new Intent(lesson.this,Day10.class);
                    startActivity(intent);
                }


            }
        });
    }

    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting())) return true;
            else return false;
        } else
            return false;
    }
    public AlertDialog.Builder buildDialog(Context c) {

        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have Mobile Data or wifi to access this. Press ok to Exit");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish();
            }
        });

        return builder;
    }
}
