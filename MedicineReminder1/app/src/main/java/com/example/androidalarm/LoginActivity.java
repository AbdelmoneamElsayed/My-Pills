package com.example.androidalarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {
    ImageView imageView;
    EditText edt_email2;
    EditText edt_pass2;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        imageView = findViewById(R.id.img_arrow);
        edt_email2=(EditText)findViewById(R.id.edt_email2);
        edt_pass2=(EditText)findViewById(R.id.edt_pass2);
        btn_login=(Button)findViewById(R.id.btn_login);
    }

    public void goback(View view) {
        Intent intent = new Intent(LoginActivity.this, MainActivity2.class);
        startActivity(intent);
    }

    public void nextpage(View view) {
        if(TextUtils.isEmpty(edt_email2.getText())&&TextUtils.isEmpty(edt_pass2.getText())){
            edt_email2.setError("This Feild is required");
            edt_email2.requestFocus();
            edt_pass2.setError("This Feild is required");
            edt_pass2.requestFocus();



        }
        else  {
            String a=edt_email2.getText().toString();

            String e=edt_pass2.getText().toString();

 Intent tap= new Intent(LoginActivity.this,MainActivity.class);
        startActivity(tap);
        }

    }


}