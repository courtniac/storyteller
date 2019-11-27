package com.example.storyteller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class BookActivity extends AppCompatActivity {

    private TextView tvtitle,tvdescription,tvcategory;
    private ImageView img;
    private ActionBar actionBar;
    private View wholeView;

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

        // Set action bar
        actionBar =  getSupportActionBar();
        configureActionBar();

        // Show or hide action bar on click
        wholeView = findViewById(R.id.wholescreen_id);
        wholeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (actionBar.isShowing()) {
                    actionBar.hide();
                } else {
                    actionBar.show();
                }
            }
        });
    }

    private void configureActionBar() {
        actionBar.setDisplayShowCustomEnabled(true);
        View customActionView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.my_action_bar, null);
        TextView actionBack = (TextView) customActionView.findViewById(R.id.action_back_button);
        actionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TextView actionAdd = (TextView) customActionView.findViewById(R.id.action_add_button);
        actionAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ChooseCategoryActivity.class));
            }
        });

        actionBar.setCustomView(customActionView, new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
        actionBar.hide();
    }
}