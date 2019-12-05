package com.example.storyteller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddCustomQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_custom_question);
    }

    public void onAddClicked(View view) {
        finish();
    }

    public void onBackClick(View view) {
        onBackPressed();
    }
}
