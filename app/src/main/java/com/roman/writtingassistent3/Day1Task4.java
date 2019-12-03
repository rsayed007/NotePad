package com.roman.writtingassistent3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.HashMap;
import java.util.Map;
public class Day1Task4 extends AppCompatActivity implements View.OnClickListener {

    EditText editTextItemName,editTextBrand,editTextDescription;
    Button buttonAddItem;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day1_task4);

        MobileAds.initialize(this,
                "ca-app-pub-5376079706371809~3812378426");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        editTextItemName = findViewById(R.id.et_item_name);
        editTextBrand = findViewById(R.id.et_brand);
        editTextDescription = findViewById(R.id.et_description);

        buttonAddItem = findViewById(R.id.btn_add_item);
        buttonAddItem.setOnClickListener(this);


    }

    //This is the part where data is transafeered from Your Android phone to Sheet by using HTTP Rest API calls

    private void   addItemToSheet() {

        final ProgressDialog loading = ProgressDialog.show(this,"Adding Item","Please wait");
        final String name    = editTextItemName.getText().toString().trim();
        final String brand   = editTextBrand.getText().toString().trim();
        final String descrip = editTextDescription.getText().toString().trim();




        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbyHbdpLorOTOI5PUygX-D07CyMIKxTKrNfrugZWkFSHrBh5XEI/exec",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        loading.dismiss();
                        Toast.makeText(Day1Task4.this,response,Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parmas = new HashMap<>();

                //here we pass params
                parmas.put("action","addItem");
                parmas.put("itemName",name);
                parmas.put("brand",brand);
                parmas.put("descrip",descrip);

                return parmas;
            }
        };

        int socketTimeOut = 50000;// u can change this .. here it is 50 seconds

        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(this);

        queue.add(stringRequest);


    }




    @Override
    public void onClick(View v) {

        if(v==buttonAddItem){
            addItemToSheet();

            //Define what to do when button is clicked
        }
    }
}
