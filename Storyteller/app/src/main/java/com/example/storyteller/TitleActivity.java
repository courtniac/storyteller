package com.example.storyteller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        Database db = new Database(getApplicationContext());
        db.clearDatabase();
    }

    public void goToLibrary(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToChooseCategory(View view) {
        Intent intent = new Intent(this, ChooseCategoryActivity.class);
        startActivity(intent);
    }
}
