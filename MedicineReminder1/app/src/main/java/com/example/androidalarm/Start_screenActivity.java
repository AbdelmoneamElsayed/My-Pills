package com.example.androidalarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

import com.ebanx.swipebtn.OnStateChangeListener;
import com.ebanx.swipebtn.SwipeButton;

public class Start_screenActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_start_screen);
            SwipeButton swipeButton = findViewById(R.id.Swipe_button);
            swipeButton.setOnStateChangeListener(new OnStateChangeListener() {
                @Override
                public void onStateChange(boolean active) {
                    startActivity(new Intent(Start_screenActivity.this,MainActivity2.class));
                }
            });
    }
}