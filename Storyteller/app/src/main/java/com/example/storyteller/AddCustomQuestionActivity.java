package com.example.storyteller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddCustomQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_custom_question);

        Intent intent = getIntent();

        //get category from previous page
        TextView title = findViewById(R.id.question_category);
        title.setText(intent.getStringExtra("category"));
    }

    public void onAddClicked(View view) {
        finish();
    }

    public void onBackClick(View view) {
        onBackPressed();
    }
}
