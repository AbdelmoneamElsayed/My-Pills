package com.example.androidalarm;

import android.support.v7.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity {
    private static final String Tag = "MainActivity2";
    private EditText mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Button btn;
    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText edt_email;
    EditText edt_pass;
    EditText edt_date;
    EditText edt_usr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn = findViewById(R.id.btn_reg);
        edt_date=(EditText)findViewById(R.id.edt_date);
        edt_usr=(EditText)findViewById(R.id.edt_usr);
        edt_pass=(EditText)findViewById(R.id.edt_pass);
        edt_email=(EditText)findViewById(R.id.edt_email);

        mDisplayDate = (EditText) findViewById(R.id.edt_date);
        radioGroup = findViewById(R.id.radio_g);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(edt_date.getText())&&TextUtils.isEmpty(edt_usr.getText())&&TextUtils.isEmpty(edt_email.getText())&&TextUtils.isEmpty(edt_pass.getText())){
                    edt_usr.setError("This Feild is required");
                    edt_usr.requestFocus();
                    edt_email.setError("This Feild is required");
                    edt_email.requestFocus();
                    edt_pass.setError("This Feild is required");
                    edt_pass.requestFocus();
                    edt_date.setError("This Feild is required");
                    edt_date.requestFocus();


                }
                else  {
                    String a=edt_usr.getText().toString();

                    String e=edt_email.getText().toString();

                    String l=edt_pass.getText().toString();

                    String p=edt_date.getText().toString();
                    Intent dap = new Intent(MainActivity2.this, LoginActivity.class);
                    startActivity(dap);

                }

            }

        });
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog daialog = new DatePickerDialog(MainActivity2.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener, year, month, day);
                daialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                daialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(Tag, "onDateSet : mm//dd//yyy" + month + "/" + day + year);
                String date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);

            }
        };
    }

    public void oncheck(View view) {   int radioId=radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(radioId);
        Toast.makeText(MainActivity2.this,"Selcted gender is:"+radioButton.getText(),Toast.LENGTH_LONG).show();


    }

    public void goforward(View view) {
        Intent dap = new Intent(MainActivity2.this, LoginActivity.class);
        startActivity(dap);
    }

    public void returnback(View view) {
        Intent yup = new Intent(MainActivity2.this, Start_screenActivity.class);
        startActivity(yup);
    }
}
