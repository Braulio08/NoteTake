package com.brafa.notetake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText editTextTitle, editTextDescription;
    Button buttonCancel, buttonSave;
    int noteId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Update Note");
        setContentView(R.layout.activity_update);
        editTextTitle = findViewById(R.id.editTextTitleUpdate);
        editTextDescription = findViewById(R.id.editTextDescriptionUpdate);
        buttonCancel = findViewById(R.id.button3Update);
        buttonSave = findViewById(R.id.button2Update);
        getData();

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UpdateActivity.this, "Nothing Update", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNote();
            }
        });
    }
    public void updateNote()
    {

        String titleLast = editTextTitle.getText().toString();
        String descriptionLast = editTextDescription.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("titleLast", titleLast);
        intent.putExtra("descriptionLast", descriptionLast);
        if(noteId != 1)
        {

            intent.putExtra("noteId",noteId);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
    public void getData()
    {
        Intent intent = getIntent();
        noteId = intent.getIntExtra("id", -1);
        String noteTitle = intent.getStringExtra("title");
        String noteDescription = intent.getStringExtra("description");

        editTextTitle.setText(noteTitle);
        editTextDescription.setText(noteDescription);
    }
}