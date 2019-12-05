package com.example.storyteller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category);
    }

    public void goToPreferences(View view) {
        Intent intent = new Intent(this, PreferencesActivity.class);
        startActivity(intent);
    }

    public void goToExperiences(View view) {
        Intent intent = new Intent(this, ExperiencesActivity.class);
        startActivity(intent);
    }

    public void goToEvents(View view) {
        Intent intent = new Intent(this, EventsActivity.class);
        startActivity(intent);
    }

    public void goToRelationships(View view) {
        Intent intent = new Intent(this, RelationshipsActivity.class);
        startActivity(intent);
    }

    public void goToValues(View view) {
        Intent intent = new Intent(this, ValuesActivity.class);
        startActivity(intent);
    }

    public void onBackClick(View view) {
        onBackPressed();
    }
}
