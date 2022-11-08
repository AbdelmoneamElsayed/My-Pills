package com.example.androidalarm;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidalarm.database.DBHandler;
import com.example.androidalarm.database.MedicineModel;

public class activity_medicineDetail extends AppCompatActivity {

    private TextView nameText, dosageText, timeText;


    String id;
    private ImageView typeImageView;
    Button delete_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_detail);

        nameText = findViewById(R.id.title);
        dosageText = findViewById(R.id.dosage);
        timeText = findViewById(R.id.time);
        typeImageView = findViewById(R.id.type);
        delete_button = findViewById(R.id.delete_button);

        //getting data from intent
        String name = getIntent().getStringExtra("name");
        final String dosage = getIntent().getStringExtra("dosage");
        String type = getIntent().getStringExtra("type");
        String time = getIntent().getStringExtra("time");


        //setting data to ui
        nameText.setText(name);
        dosageText.setText(dosage);
        timeText.setText(time);

        if (type.equals("Capsule")) {
            typeImageView.setImageResource(R.drawable.capsule_large);
        } else {
            typeImageView.setImageResource(R.drawable.bottle_large);
        }
        //del

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }
        void confirmDialog(){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Delete " + getTitle() + " ?");
            builder.setMessage("Are you sure you want to delete " + getTitle() + " ?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    DBHandler myDB = new DBHandler(activity_medicineDetail.this);
                    myDB.deleteOneRow(id);
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.create().show();
        }
    }
