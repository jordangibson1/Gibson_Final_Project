package com.example.gibson_final_project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ConcertSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concert_selection);
    }

    public void picClick(View v) {
        Intent intent = new Intent(this, EnterInfo.class);
        switch (v.getId()) {
            case R.id.maroon5Pic:
                intent.putExtra("band name", "Maroon 5");
                intent.putExtra("tour date", "9/1 - 9/30");
                break;
            case R.id.postPic:
                intent.putExtra("band name", "Post Malone");
                intent.putExtra("tour date", "5/1 - 5/31");
                break;
            case R.id.sabatonPic:
                intent.putExtra("band name", "Sabaton");
                intent.putExtra("tour date", "7/1 - 7/31");
                break;
            case R.id.powerPic:
                intent.putExtra("band name", "Powerwolf");
                intent.putExtra("tour date", "6/1 - 6/30");
                break;
            default:
                throw new RuntimeException("Unknown button ID");
        }
        startActivity(intent);
    }

    public void toastClick(View v) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, "", duration);
        switch (v.getId()) {

            case R.id.maroon5:
                toast.setText("Maroon 5, Genre: Pop");
                break;
            case R.id.post:
                toast.setText("Post Malone, Genre: Pop");
                break;
            case R.id.sabaton:
                toast.setText("Sabaton, Genre: Metal/ Rock");
                break;
            case R.id.powerwolf:
                toast.setText("Powerwolf, Genre: Metal/ Rock");
                break;

            case R.id.marDate:
                toast.setText("September 1 - 30, 2020");
                break;
            case R.id.postDate:
                toast.setText("May 1 - 31, 2020");
                break;
            case R.id.sabDate:
                toast.setText("July 1 - 31, 2020");
                break;
            case R.id.powDate:
                toast.setText("June 1 - 30, 2020");
                break;

            case R.id.marCost:
                toast.setText("125 USD");
                break;
            case R.id.postCost:
                toast.setText("150 USD");
                break;
            case R.id.sabCost:
                toast.setText("170 USD");
                break;
            case R.id.powCost:
                toast.setText("120 USD");
                break;

            default:
                throw new RuntimeException("Unknown button ID");
        }
        toast.show();
    }
}
