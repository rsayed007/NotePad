package com.roman.writtingassistent3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Day6Task6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day6_task6);
    }

    public void day_6_tsk6(View view) {
        Intent intent = new Intent(this,Day1Task4.class);
        startActivity(intent);
    }
}
