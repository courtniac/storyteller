package com.example.storyteller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddQuestionActivity extends AppCompatActivity {
    String questionStr;
    String categoryStr;
    EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        Intent intent = getIntent();
        //get question from previous page
        questionStr = intent.getStringExtra("question");

        //get category from previous page
        TextView title = findViewById(R.id.question_category);
        categoryStr = intent.getStringExtra("category");
        title.setText(categoryStr);
        answer = findViewById(R.id.answer_question);


        // fill in question
        TextView questionTextView = (TextView) findViewById(R.id.question);
        questionTextView.setText(questionStr);
    }

    public void onAddClicked(View view) {
        String answerStr = answer.getText().toString();
        Intent intent = new Intent(this, BookActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("empty", false);
        intent.putExtra("question", questionStr);
        intent.putExtra("answer", answerStr);
        intent.putExtra("category", categoryStr);
        startActivity(intent);
        finish();
    }

    public void onBackClick(View view) {
        onBackPressed();
    }
}
