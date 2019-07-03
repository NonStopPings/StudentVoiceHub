package com.demin.studentvoicehub05;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class StudentRecommendationsForStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_recommendations_for_student);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Tips n Ideas");

        CardView buyAndSell = (CardView) findViewById(R.id.buyAndSell_student);
        buyAndSell.setOnClickListener(CardbuyAndSellHandler);

        CardView recommendations = (CardView) findViewById(R.id.recommendations_student);
        recommendations.setOnClickListener(CardrecommendationsHandler);

    }

    View.OnClickListener CardbuyAndSellHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent buyAndSell=new Intent(getBaseContext(),BuyAndSellForStudent.class).
                    putExtra(Intent.EXTRA_TEXT, "A message form MainActivity");
            startActivity(buyAndSell);
            overridePendingTransition(R.anim.silde_in_left,R.anim.silde_in_right);
        }};
    View.OnClickListener CardrecommendationsHandler = new View.OnClickListener() {
        public void onClick(View view) {
            Intent recommendations=new Intent(getBaseContext(),RecommendationsForStudent.class).
                    putExtra(Intent.EXTRA_TEXT, "A message form MainActivity");
            startActivity(recommendations);
            overridePendingTransition(R.anim.silde_in_left,R.anim.silde_in_right);
        }};
}
