package com.demin.studentvoicehub05;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Hompage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hompage);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Dashboard");


        CardView events = (CardView) findViewById(R.id.events_student);
        events.setOnClickListener(CardEventsHandler);

        CardView recommendations = (CardView) findViewById(R.id.student_recommendations_student);
        recommendations.setOnClickListener(CardRecommendationsHandler);

        CardView campusInformation = (CardView) findViewById(R.id.campus_Information_student);
        campusInformation.setOnClickListener(CardCampusInformationHandler);

        CardView externalLinks = (CardView) findViewById(R.id.External_links_student);
        externalLinks.setOnClickListener(CardExternalHandler);

        CardView studentVoice = (CardView) findViewById(R.id.Student_Voice_student);
        studentVoice.setOnClickListener(CardStudentVoiceHandler);

        CardView helplineServices = (CardView) findViewById(R.id.Helpline_Services_student);
        helplineServices.setOnClickListener(CardHelplineServicesHandler);

        CardView jobs = (CardView) findViewById(R.id.Jobs_student);
        jobs.setOnClickListener(CardJobsHandler);

    }

    View.OnClickListener CardEventsHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent events=new Intent(getBaseContext(),EventsForStudent.class).
                    putExtra(Intent.EXTRA_TEXT, "A message form MainActivity");
            startActivity(events);
            overridePendingTransition(R.anim.silde_in_left,R.anim.silde_in_right);
        }};

    View.OnClickListener CardRecommendationsHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent recommendations=new Intent(getBaseContext(),StudentRecommendationsForStudent.class).
                    putExtra(Intent.EXTRA_TEXT, "A message form MainActivity");
            startActivity(recommendations);
            overridePendingTransition(R.anim.silde_in_left,R.anim.silde_in_right);
        }};

    View.OnClickListener CardCampusInformationHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent campusInformation=new Intent(getBaseContext(),CampusInformationForStudent.class).
                    putExtra(Intent.EXTRA_TEXT, "A message form MainActivity");
            startActivity(campusInformation);
            overridePendingTransition(R.anim.silde_in_left,R.anim.silde_in_right);
        }};

    View.OnClickListener CardStudentVoiceHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent studentVoice=new Intent(getBaseContext(),StudentVoiceForStudent.class).
                    putExtra(Intent.EXTRA_TEXT, "A message form MainActivity");
            startActivity(studentVoice);
            overridePendingTransition(R.anim.silde_in_left,R.anim.silde_in_right);
        }};

    View.OnClickListener CardExternalHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent externalLinks=new Intent(getBaseContext(),ExternalLinks.class).
                    putExtra(Intent.EXTRA_TEXT, "A message form MainActivity");
            startActivity(externalLinks);
            overridePendingTransition(R.anim.silde_in_left,R.anim.silde_in_right);
        }};

    View.OnClickListener CardHelplineServicesHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent helplineServices=new Intent(getBaseContext(),HelplineServicesForStudent.class).
                    putExtra(Intent.EXTRA_TEXT, "A message form MainActivity");
            startActivity(helplineServices);
            overridePendingTransition(R.anim.silde_in_left,R.anim.silde_in_right);
        }};

    View.OnClickListener CardJobsHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent jobs=new Intent(getBaseContext(),JobsForStudent.class).
                    putExtra(Intent.EXTRA_TEXT, "A message form MainActivity");
            startActivity(jobs);
            overridePendingTransition(R.anim.silde_in_left,R.anim.silde_in_right);
        }};

}
