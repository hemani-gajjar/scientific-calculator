package com.example.calculator;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

;

public class MainActivity extends Activity {

    // To-do in the code
    //do the empty input one case


    //declaration
    EditText txtnum1, txtnum2;
    TextView txtresult;
    Button btnplus, btnminus, btnmultiply, btndivide, btnsin, btncos, btntan, btnpower, btnsqrt, btnlog, btnclear, btngetlocation;
    FusedLocationProviderClient fusedLocationProviderClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialization

        txtnum1 = (EditText) findViewById(R.id.txtnum1);
        txtnum2 = (EditText) findViewById(R.id.txtnum2);
        txtresult = (TextView) findViewById(R.id.txtresult);

        btnplus = (Button) findViewById(R.id.btnplus);
        btnminus = (Button) findViewById(R.id.btnminus);
        btnmultiply = (Button) findViewById(R.id.btnmultiply);
        btndivide = (Button) findViewById(R.id.btndivide);
        btnsin = (Button) findViewById(R.id.btnsin);
        btncos = (Button) findViewById(R.id.btnscos);
        btntan = (Button) findViewById(R.id.btntan);
        btnpower = (Button) findViewById(R.id.btnpower);
        btnsqrt = (Button) findViewById(R.id.btnsqrt);
        btnlog = (Button) findViewById(R.id.btnlog);
        btnclear = (Button) findViewById(R.id.btnclear);
        btngetlocation = (Button) findViewById(R.id.btngetlocation);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        btngetlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check permission
                if(ActivityCompat.checkSelfPermission(MainActivity.this,
                         Manifest.permission.ACCESS_FINE_LOCATION ) == PackageManager.PERMISSION_GRANTED){

                    //When permission is granted
                    getLocation();
                }else
                {
                    //when permission is denied
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);

                }
            }
        });

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtnum1.getText().toString().matches("")) {
                    txtresult.setText("");
                    Toast.makeText(getApplicationContext(),"Number 1 field is empty!", Toast.LENGTH_SHORT).show();
                } else if (txtnum2.getText().toString().matches("")){
                    txtresult.setText("");
                    Toast.makeText(getApplicationContext(),"Number 2 field is empty!", Toast.LENGTH_SHORT).show();
                }

                else {
                    float num1 = Float.parseFloat(txtnum1.getText().toString());
                    float num2 = Float.parseFloat(txtnum2.getText().toString());
                    float val = num1 + num2;
                    txtresult.setText(String.valueOf(val));
                }
            }
        });

        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtnum1.getText().toString().matches("")) {
                    txtresult.setText("");
                    Toast.makeText(getApplicationContext(),"Number 1 field is empty!", Toast.LENGTH_SHORT).show();
                } else if (txtnum2.getText().toString().matches("")){
                    txtresult.setText("");
                    Toast.makeText(getApplicationContext(),"Number 2 field is empty!", Toast.LENGTH_SHORT).show();
                } else {
                    float num1 = Float.parseFloat(txtnum1.getText().toString());
                    float num2 = Float.parseFloat(txtnum2.getText().toString());
                    float val = num1 - num2;
                    txtresult.setText(String.valueOf(val));
                }
            }
        });

        btnmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtnum1.getText().toString().matches("")) {
                    txtresult.setText("");
                    Toast.makeText(getApplicationContext(),"Number 1 field is empty!", Toast.LENGTH_SHORT).show();
                } else if (txtnum2.getText().toString().matches("")){
                    txtresult.setText("");
                    Toast.makeText(getApplicationContext(),"Number 2 field is empty!", Toast.LENGTH_SHORT).show();
                }else {
                    double num1 = Float.parseFloat(txtnum1.getText().toString());
                    double num2 = Float.parseFloat(txtnum2.getText().toString());
                    double val = num1 * num2;
                    txtresult.setText(String.valueOf(val));
                }
            }
        });

        btndivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtnum1.getText().toString().matches("")) {
                    txtresult.setText("");
                    Toast.makeText(getApplicationContext(),"Number 1 field is empty!", Toast.LENGTH_SHORT).show();
                } else if (txtnum2.getText().toString().matches("")){
                    txtresult.setText("");
                    Toast.makeText(getApplicationContext(),"Number 2 field is empty!", Toast.LENGTH_SHORT).show();
                }else {
                    double num1 = Float.parseFloat(txtnum1.getText().toString());
                    double num2 = Float.parseFloat(txtnum2.getText().toString());
                    double val = num1 / num2;
                    txtresult.setText(String.valueOf(val));
                }
            }
        });


        btnsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtnum1.getText().toString().matches("")) {
                    txtresult.setText("");
                    Toast.makeText(getApplicationContext(),"Number 1 field is empty!", Toast.LENGTH_SHORT).show();
                } else {
                    double num1 = Float.parseFloat(txtnum1.getText().toString());
                    double val = Math.sin(num1);
                    txtresult.setText(String.valueOf(val));
                }
            }
        });

        btncos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtnum1.getText().toString().matches("")) {
                    txtresult.setText("");
                    Toast.makeText(getApplicationContext(),"Number 1 field is empty!", Toast.LENGTH_SHORT).show();
                } else {
                    double num1 = Float.parseFloat(txtnum1.getText().toString());
                    double val = Math.cos(num1);
                    txtresult.setText(String.valueOf(val));
                }
            }
        });

        btntan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtnum1.getText().toString().matches("")) {
                    txtresult.setText("");
                    Toast.makeText(getApplicationContext(),"Number 1 field is empty!", Toast.LENGTH_SHORT).show();
                } else {
                    double num1 = Float.parseFloat(txtnum1.getText().toString());
                    double val = Math.tan(num1);
                    txtresult.setText(String.valueOf(val));
                }
            }
        });

        btnpower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtnum1.getText().toString().matches("")) {
                    txtresult.setText("");
                    Toast.makeText(getApplicationContext(),"Number 1 field is empty!", Toast.LENGTH_SHORT).show();
                } else if (txtnum2.getText().toString().matches("")){
                    txtresult.setText("");
                    Toast.makeText(getApplicationContext(),"Number 2 field is empty!", Toast.LENGTH_SHORT).show();
                }else {
                    boolean digitsOnly1 = TextUtils.isDigitsOnly(txtnum1.getText());
                    boolean digitsOnly2 = TextUtils.isDigitsOnly(txtnum2.getText());
                    if(digitsOnly1){
                        if(digitsOnly2) {
                            float num1 = Integer.parseInt(txtnum1.getText().toString());
                            float num2 = Integer.parseInt(txtnum2.getText().toString());
                            double val = Math.pow(num1, num2);
                            txtresult.setText(String.valueOf(val));
                        } else {
                            Toast.makeText(getApplicationContext(), "Enter an integer value!", Toast.LENGTH_SHORT).show(); }

                    } else{
                        Toast.makeText(getApplicationContext(),"Enter an integer value!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnsqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtnum1.getText().toString().matches("")) {
                    txtresult.setText("");
                    Toast.makeText(getApplicationContext(),"Number 1 field is empty!", Toast.LENGTH_SHORT).show();
                } else {
                    double num1 = Float.parseFloat(txtnum1.getText().toString());
                    double val = Math.sqrt(num1);
                    txtresult.setText(String.valueOf(val));
                }
            }
        });

        btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtnum1.getText().toString().matches("")) {
                    txtresult.setText("");
                    Toast.makeText(getApplicationContext(),"Number 1 field is empty!", Toast.LENGTH_SHORT).show();
                } else {
                    double num1 = Float.parseFloat(txtnum1.getText().toString());
                    double val = Math.log10(num1);
                    txtresult.setText(String.valueOf(val));
                }
            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtresult.setText("");
                txtnum1.setText("");
                txtnum2.setText("");
            }
        });

    }

    //the get location function
    @SuppressLint("MissingPermission")
    private void getLocation() {

        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                //Initialize location
                Location location = task.getResult();
                if(location != null){
                    try {
                        //Initialize GeoCoder
                        Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                        //initialize Address list
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                        //Set the editText to latitude
                        txtnum1.setText(Html.fromHtml(String.valueOf(addresses.get(0).getLatitude())));

                        //Set the editText to longitude
                        txtnum2.setText(Html.fromHtml(String.valueOf(addresses.get(0).getLongitude())));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}