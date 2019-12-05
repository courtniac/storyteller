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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity {

    private TextView tvtitle;
    private ImageView img;
    private ActionBar actionBar;
    private View wholeView;

    List<BookCard> lstBookCard ;
    CardRecyclerAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        tvtitle = findViewById(R.id.txttitle);
        img = findViewById(R.id.bookthumbnail);

        // Recieve data
        Intent intent = getIntent();
        Book book = intent.getExtras().getParcelable("book");
        String DisplayName = book.getDisplayName();
        String Description = book.getDescription();
        int image = book.getThumbnail();

        // Set values
        StringBuilder str = new StringBuilder(DisplayName);
        str.append("'s Book");

        tvtitle.setText(str.toString());
        img.setImageResource(image);

        // Set card recylcer (displays question/answer)
        lstBookCard = new ArrayList<>();
        lstBookCard.add(new BookCard("", Description));
        lstBookCard.add(new BookCard("question 1", "ANSWER"));
        lstBookCard.add(new BookCard("question 2", "this is our answer\nsecond line : )"));
        lstBookCard.add(new BookCard("question 2", "this is our answer\nsecond line : )"));
        lstBookCard.add(new BookCard("question 2", "this is our answer\nsecond line : )"));
        lstBookCard.add(new BookCard("question 2", "this is our answer\nsecond line : )"));

        RecyclerView cardrv = findViewById(R.id.cardrecycler_id);
        cardAdapter = new CardRecyclerAdapter(this, lstBookCard);
        cardrv.setLayoutManager(new LinearLayoutManager(this));
        cardrv.setAdapter(cardAdapter);
        cardrv.setNestedScrollingEnabled(false);

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