package com.example.storyteller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AddBookActivity extends AppCompatActivity {

    EditText name;
    EditText displayName;
    Spinner spinner;
    EditText birthday;
    EditText relationship;
    EditText hometown;
    EditText currResidence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        // Populate dropdown
        spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pronouns, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        name = findViewById(R.id.editTextName);
        displayName = findViewById(R.id.editTextDisplayName);
        birthday = findViewById(R.id.editTextBirthday);
        relationship = findViewById(R.id.editTextRelationship);
        hometown = findViewById(R.id.editTextHometown);
        currResidence = findViewById(R.id.editTextCurrentResidence);

        Button createBtn = findViewById(R.id.createBtn);
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr = name.getText().toString();
                String displayNameStr = displayName.getText().toString();
                String pronounStr = spinner.getSelectedItem().toString();
                String birthdayStr = birthday.getText().toString();
                String relationshipStr = relationship.getText().toString();
                String hometownStr = hometown.getText().toString();
                String currResidenceStr = currResidence.getText().toString();
                if (nameStr.trim().length() > 0 && displayNameStr.trim().length() > 0) {
                    Intent returnIntent = new Intent();
                    Bundle extras = new Bundle();
                    extras.putString("Name", nameStr);
                    extras.putString("Display Name", displayNameStr);
                    extras.putString("Pronouns", pronounStr);
                    extras.putString("Birthday", birthdayStr);
                    extras.putString("Relationship", relationshipStr);
                    extras.putString("Hometown", hometownStr);
                    extras.putString("Current Residence", currResidenceStr);
                    returnIntent.putExtras(extras);
                    setResult(RESULT_OK, returnIntent); //By not passing the intent in the result, the calling activity will get null data.
                    finish();
                } else {
                    Toast toast= Toast.makeText(getApplicationContext(), "Name and Display Name cannot be empty", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
            }
        });
    }

    public void onBackClick(View view) {
        onBackPressed();
    }
}
