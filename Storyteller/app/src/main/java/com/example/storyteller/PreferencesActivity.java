package com.example.storyteller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
    }

    public void onQuestionClick(View view) {

        String question = "No question selected, please try again";
        int id = view.getId();
        switch (id) {
            case R.id.pref_box_1:
                question = getString(R.string.fav_musician);
                break;
            case R.id.pref_box_2:
                question = getString(R.string.fav_actor);
                break;
            case R.id.pref_box_3:
                question = getString(R.string.fav_celebrity);
                break;
            case R.id.pref_box_4:
                question = getString(R.string.fav_food);
                break;
            case R.id.pref_box_5:
                question = getString(R.string.fav_hobby);
                break;
            case R.id.pref_box_6:
                question = "Insert your custom question here";

        }

        if (id == R.id.pref_box_6) {
            Intent intent = new Intent(getBaseContext(), AddCustomQuestionActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(getBaseContext(), AddQuestionActivity.class);
            intent.putExtra("Title", getString(R.string.relationships));
            intent.putExtra("Question", question);
            startActivity(intent);
        }
    }

    public void onBackClick(View view) {
        onBackPressed();
    }

    public void onReturnToHomeClick(View view) {
        Intent intent = new Intent(this, BookActivity.class);
        intent.putExtra("empty", true);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }
}
