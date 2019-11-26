package com.example.storyteller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
 import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Book> lstBook ;

    int[] imgList = new int[]{R.drawable.bloodymimosa, R.drawable.dustycactus, R.drawable.quepal, R.drawable.aquaspray, R.drawable.lovelylilly};
    int imgListPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstBook = new ArrayList<>();

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstBook);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to next activity
                startActivityForResult(new Intent(getApplicationContext(), AddBookActivity.class), 0);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();

            String nameStr = extras.getString("Name");
            String displayNameStr = extras.getString("Display Name");
            String pronounStr = extras.getString("Pronouns");
            String birthdayStr = extras.getString("Birthday");
            String relationshipStr = extras.getString("Relationship");
            String hometownStr = extras.getString("Hometown");
            String currResidenceStr = extras.getString("Current Residence");
            lstBook.add(new Book(nameStr, displayNameStr, pronounStr, birthdayStr, relationshipStr, hometownStr, currResidenceStr, imgList[imgListPosition]));
            updateImgListPosition();
        }
    }

    private void updateImgListPosition() {
        if (imgListPosition == 4)  {
            imgListPosition = 0;
        } else {
            imgListPosition++;
        }
    }
}
