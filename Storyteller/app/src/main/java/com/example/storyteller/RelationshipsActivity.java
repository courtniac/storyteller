package com.example.storyteller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RelationshipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relationships);
    }

    public void onQuestionClick(View view) {

        String question = "No question selected, please try again";
        int id = view.getId();
        switch (id) {
            case R.id.pref_box_1:
                question = getString(R.string.relate_meet);
                break;
            case R.id.pref_box_2:
                question = getString(R.string.relate_evolve);
                break;
            case R.id.pref_box_3:
                question = getString(R.string.relate_kiss);
                break;
            case R.id.pref_box_4:
                question = getString(R.string.relate_change);
                break;
            case R.id.pref_box_5:
                question = getString(R.string.relate_lessons);
                break;
            case R.id.pref_box_6:
                question = "Insert your custom question here";

        }

        if (id == R.id.pref_box_6) {
            Intent intent = new Intent(getBaseContext(), AddCustomQuestionActivity.class);
            intent.putExtra("category", getString(R.string.relationships));
            startActivity(intent);
        } else {
            Intent intent = new Intent(getBaseContext(), AddQuestionActivity.class);
            intent.putExtra("category", getString(R.string.relationships));
            intent.putExtra("question", question);
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
