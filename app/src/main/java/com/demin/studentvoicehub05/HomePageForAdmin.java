package com.demin.studentvoicehub05;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

public class HomePageForAdmin extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_for_admin);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Dashboard");

        CardView events = (CardView) findViewById(R.id.events);
        events.setOnClickListener(CardEventsHandler);


        CardView campusInformation = (CardView) findViewById(R.id.campus_Information);
        campusInformation.setOnClickListener(CardcampusInformationHandler);

        CardView studentrecommendations = (CardView) findViewById(R.id.recommendations);
        studentrecommendations.setOnClickListener(CardstudentrecommendationsHandler);

        CardView externallinks = (CardView) findViewById(R.id.External_links);
        externallinks.setOnClickListener(CardExternalHandler);

        CardView jobs = (CardView) findViewById(R.id.Jobs);
        jobs.setOnClickListener(CardjobsHandler);

        CardView studentvoice = (CardView) findViewById(R.id.Student_Voice);
        studentvoice.setOnClickListener(CardstudentvoiceHandler);

        CardView helplineservices = (CardView) findViewById(R.id.Helpline_Services);
        helplineservices.setOnClickListener(CardhelplineservicesHandler);

        CardView report = (CardView) findViewById(R.id.Report);
        report.setOnClickListener(CardReportHandler);

    }

    View.OnClickListener CardEventsHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent events=new Intent(getBaseContext(),Events.class).
                    putExtra(Intent.EXTRA_TEXT, "A message form MainActivity");
            startActivity(events);
            overridePendingTransition(R.anim.silde_in_left,R.anim.silde_in_right);
        }};

    View.OnClickListener CardcampusInformationHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent campusInformation=new Intent(getBaseContext(),CampusInformation.class).
                    putExtra(Intent.EXTRA_TEXT, "A message form MainActivity");
            startActivity(campusInformation);
            overridePendingTransition(R.anim.silde_in_left,R.anim.silde_in_right);
        }};

    View.OnClickListener CardstudentrecommendationsHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent studentrecommendations=new Intent(getBaseContext(),StudentRecommendations.class).
                    putExtra(Intent.EXTRA_TEXT, "A message form MainActivity");
            startActivity(studentrecommendations);
            overridePendingTransition(R.anim.silde_in_left,R.anim.silde_in_right);
        }};

    View.OnClickListener CardstudentvoiceHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent studentvoice=new Intent(getBaseContext(),StudentVoice.class).
                    putExtra(Intent.EXTRA_TEXT, "A message form MainActivity");
            startActivity(studentvoice);
            overridePendingTransition(R.anim.silde_in_left,R.anim.silde_in_right);
        }};

    View.OnClickListener CardjobsHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent jobs=new Intent(getBaseContext(),Jobs.class).
                    putExtra(Intent.EXTRA_TEXT, "A message form MainActivity");
            startActivity(jobs);
            overridePendingTransition(R.anim.silde_in_left,R.anim.silde_in_right);
        }};

    View.OnClickListener CardhelplineservicesHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent helplineservices=new Intent(getBaseContext(),HelplineServices.class).
                    putExtra(Intent.EXTRA_TEXT, "A message form MainActivity");
            startActivity(helplineservices);
            overridePendingTransition(R.anim.silde_in_left,R.anim.silde_in_right);
        }};

    View.OnClickListener CardExternalHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent externallinks=new Intent(getBaseContext(),ExternalLinks.class).
                    putExtra(Intent.EXTRA_TEXT, "A message form MainActivity");
            startActivity(externallinks);
            overridePendingTransition(R.anim.silde_in_left,R.anim.silde_in_right);
        }};

    View.OnClickListener CardReportHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent report=new Intent(getBaseContext(),Report.class).
                    putExtra(Intent.EXTRA_TEXT, "A message form MainActivity");
            startActivity(report);
            overridePendingTransition(R.anim.silde_in_left,R.anim.silde_in_right);
        }};
}