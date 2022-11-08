package com.example.androidalarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

public class CalanderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calander);
        CalendarView calendarView = findViewById(R.id.calendarView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange( CalendarView calendarView, int i, int i1, int i2) {
                String date = i + "/" + i1 + "/" + i2;
                Intent intent = new Intent(CalanderActivity.this, InputActivity.class);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });
    }
}