package com.example.gibson_final_project;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

public class EnterInfo extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private String band;
    private String tour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_info);

        Intent intent = getIntent();
        band = intent.getStringExtra("band name");
        tour = intent.getStringExtra("tour date");

        TextView text = (TextView) findViewById(R.id.bandDisplay);
        text.setText(band);

        TextView text2 = (TextView) findViewById(R.id.tourDisplay);
        text2.setText(tour);

        Button button = (Button) findViewById(R.id.dateButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "DatePicker");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDate = DateFormat.getDateInstance().format(c.getTime());
        TextView date = (TextView) findViewById(R.id.dateDisplay);
        date.setText(currentDate);
    }

    public void submitInfo(View view) {
        TextView b = (TextView) findViewById(R.id.bandDisplay);
        String band = b.getText().toString();
        TextView n = (TextView) findViewById(R.id.nameEntry);
        String name = n.getText().toString();
        TextView d = (TextView) findViewById(R.id.dateDisplay);
        String date = d.getText().toString();
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, "Thank you " + name + ", enjoy your experience with " + band + " on " + date + "!", duration);
        toast.show();
    }
}
