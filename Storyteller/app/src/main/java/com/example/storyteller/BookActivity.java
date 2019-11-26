package com.example.storyteller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BookActivity extends AppCompatActivity {

    private TextView tvtitle,tvdescription,tvcategory;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        tvtitle = findViewById(R.id.txttitle);
        tvdescription = findViewById(R.id.txtDesc);
//        tvcategory = findViewById(R.id.txtCat);
        img = findViewById(R.id.bookthumbnail);

        // Recieve data
        Intent intent = getIntent();
        String Name = intent.getExtras().getString("Name");
        String DisplayName = intent.getExtras().getString("Display Name");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail") ;

        // Setting values
        StringBuilder str = new StringBuilder(DisplayName);
        str.append("'s Book");

        tvtitle.setText(str.toString());
        tvdescription.setText(Description);
        img.setImageResource(image);


    }
}