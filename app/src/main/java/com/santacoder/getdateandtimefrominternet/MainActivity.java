package com.santacoder.getdateandtimefrominternet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.santacoder.getdatetimefrominternet.GetDateTime;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);
        GetDateTime getDateTime = new GetDateTime(MainActivity.this);
        getDateTime.onGetDateTime(new GetDateTime.DateTimeInterface() {
            @Override
            public void onGetDateTime(String day, String month, String year, String hour, String minute, String second) {
                txt.setText(day+"-"+month+"-"+year+" || "+ hour+":"+minute+":"+second);
            }
        });
    }
}