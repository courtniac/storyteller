package com.example.storyteller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        //get question from previous page
        String question = getIntent().getStringExtra("Question");

        // fill in question textview
        TextView questionTextView = (TextView) findViewById(R.id.question);
        questionTextView.setText(question);
    }

    public void onAddClicked(View view) {
        finish();
    }
}
