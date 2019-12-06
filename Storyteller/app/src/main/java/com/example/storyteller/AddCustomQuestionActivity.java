package com.example.storyteller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddCustomQuestionActivity extends AppCompatActivity {
    String categoryStr;
    EditText question;
    EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_custom_question);

        Intent intent = getIntent();

        //get category from previous page
        TextView title = findViewById(R.id.question_category);
        categoryStr = intent.getStringExtra("category");
        title.setText(categoryStr);
        question = findViewById(R.id.enter_custom_question);
        answer = findViewById(R.id.answer_question);

    }

    public void onAddClicked(View view) {
        String questionStr = question.getText().toString();
        String answerStr = answer.getText().toString();
        if (questionStr.trim().length() <= 0) {
            Toast toast= Toast.makeText(this, "Question cannot be empty", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        } else if (answerStr.trim().length() <= 0) {
            Toast toast= Toast.makeText(this, "Answer cannot be empty", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
            toast.show();
        } else {
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
    }

    public void onBackClick(View view) {
        onBackPressed();
    }
}
