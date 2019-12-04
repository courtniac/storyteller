package com.example.storyteller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
    }

    public void onQuestionClick(View view) {

        String question = "No question selected, please try again";
        int id = view.getId();
        switch (id) {
            case R.id.pref_box_1:
                question = getString(R.string.events_met_me);
                break;
            case R.id.pref_box_2:
                question = getString(R.string.events_pivotal);
                break;
            case R.id.pref_box_3:
                question = getString(R.string.events_memory);
                break;
            case R.id.pref_box_4:
                question = getString(R.string.event_first_job);
                break;
            case R.id.pref_box_5:
                question = getString(R.string.event_immigrant);
                break;
            case R.id.pref_box_6:
                question = "Insert your custom question here";

        }

        if (id == R.id.pref_box_6) {
            Intent intent = new Intent(getBaseContext(), AddCustomQuestionActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(getBaseContext(), AddQuestionActivity.class);
            intent.putExtra("Question", question);
            startActivity(intent);
        }
    }

    public void onBackClick(View view) {
        onBackPressed();
    }

    public void onReturnToHomeClick(View view) {
        onBackClick(view);
    }

}
