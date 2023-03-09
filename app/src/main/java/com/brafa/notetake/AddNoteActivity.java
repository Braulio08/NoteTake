package com.brafa.notetake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    EditText editTextTitle, editTextDescription;
    Button buttonCancel, buttonSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Note");
        setContentView(R.layout.activity_add_note);
        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        buttonCancel = findViewById(R.id.button3);
        buttonSave = findViewById(R.id.button2);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddNoteActivity.this, "Nothing Saved", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                saveNote();
            }
        });
    }
    public void saveNote()
    {

        String noteTitle = editTextTitle.getText().toString();
        String noteDescription = editTextDescription.getText().toString();
        Intent i = new Intent();
        i.putExtra("noteTitle", noteTitle);
        i.putExtra("noteDescription", noteDescription);
        setResult(RESULT_OK, i);
        finish();

    }
}