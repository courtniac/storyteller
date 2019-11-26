package com.example.storyteller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
    }

    public void onQuestionClick(View view) {
        view.getId();
        Intent intent = new Intent(getBaseContext(), AddQuestionActivity.class);
        intent.putExtra("Question", "Who was your favorite musician growing up?");
        startActivity(intent);
    }
}
