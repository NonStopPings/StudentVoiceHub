package com.demin.studentvoicehub05;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExternalLinks extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_links);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("External Links");

    }

    public void openStudentSupport(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.manukau.ac.nz/student-life/student-support/student-voice"));
        startActivity(browserIntent);
    }

    public void openkeyDates(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.manukau.ac.nz/student-life/useful-links/mit-calendar-and-key-dates"));
        startActivity(browserIntent);
    }
    public void openstudentActivities(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.manukau.ac.nz/student-life/student-activities"));
        startActivity(browserIntent);
    }
    public void opendineInwithMIT(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.servedoncampus.co.nz/dine-at-mit"));
        startActivity(browserIntent);
    }
    public void opendjobsLink(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.careers.govt.nz/job-hunting/finding-work/job-vacancy-and-recruitment-websites/"));
        startActivity(browserIntent);
    }
}
