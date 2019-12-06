package com.example.storyteller;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookActivity extends AppCompatActivity {

    private TextView tvtitle;
    private ImageView img;
    private ActionBar actionBar;
    private View wholeView;

    private String bookIdentifier;
    private boolean emptyContent;

    private List<BookCard> lstBookCard ;
    private CardRecyclerAdapter cardAdapter;

    private Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        // get views
        tvtitle = findViewById(R.id.txttitle);
        img = findViewById(R.id.bookthumbnail);

        // Receive data
        Intent intent = getIntent();
        Book book = intent.getExtras().getParcelable("book");
        String displayName = book.getDisplayName();
        String description = book.getDescription();
        int image = book.getThumbnail();

        // Set values
        tvtitle.setText(displayName + "'s Book");
        img.setImageResource(image);
        // Use Name+DisplayName as the book identifier
        bookIdentifier = book.getName() + displayName;
        bookIdentifier = bookIdentifier.replaceAll("\\s+","");

        // Set db
        database = new Database(getApplicationContext());

        // Set card recycler
        lstBookCard = new ArrayList<>();
        lstBookCard.add(new BookCard("", "", description, ""));
        // Set sample card
        if (database.getCount(bookIdentifier) == 0) {
            lstBookCard.add(new BookCard(bookIdentifier,
                    "What should I ask "+displayName+"?",
                    "Find some sample questions by clicking on the upper right of the screen!",
                    ""));
            emptyContent = true;
        } else {
            lstBookCard.addAll(database.getAll(bookIdentifier));
            Collections.sort(lstBookCard);
            emptyContent = false;
        }

        RecyclerView cardRV = findViewById(R.id.cardrecycler_id);
        cardAdapter = new CardRecyclerAdapter(this, lstBookCard);
        cardRV.setLayoutManager(new LinearLayoutManager(this));
        cardRV.setAdapter(cardAdapter);
        cardRV.setNestedScrollingEnabled(false);

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

    @Override
    protected void onNewIntent(Intent intent) {
        // if there's no content passed in, do nothing
        if (!intent.getExtras().getBoolean("empty")) {
            String questionStr = intent.getStringExtra("question");
            String answerStr = intent.getStringExtra("answer");
            String categoryStr = intent.getStringExtra("category");
            if (emptyContent) {
                lstBookCard.remove(1);
                emptyContent = false;
            }
            BookCard item = database.insert(new BookCard(bookIdentifier, questionStr, answerStr, categoryStr));
            lstBookCard.add(item);
            Collections.sort(lstBookCard);
            cardAdapter.notifyDataSetChanged();
        }
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
    public void onItemClick(View view) {
        if (actionBar.isShowing()) {
            actionBar.hide();
        } else {
            actionBar.show();
        }
    }
}

