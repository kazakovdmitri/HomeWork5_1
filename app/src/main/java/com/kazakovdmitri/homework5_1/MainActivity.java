package com.kazakovdmitri.homework5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final String PREFERENCES_NAME = "my_pref";
    private EditText mInputNote;
    private Button mBtnSaveNote;
    private static String NOTE_TEXT = "note_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        getDateFromSharedPref();
    }

    private void initViews() {
        mInputNote = findViewById(R.id.inputNote);
        mBtnSaveNote = findViewById(R.id.btnSaveNote);
        mBtnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noteTxt = mInputNote.getText().toString();
                saveText(noteTxt);
                Toast.makeText(MainActivity.this, R.string.Msg_save, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void saveText (String text) {
        SharedPreferences myNoteSharedPref = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        myNoteSharedPref.edit().putString(NOTE_TEXT, text).apply();
    }

    private String getText () {
        SharedPreferences myNoteSharedPref = getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE);
        return myNoteSharedPref.getString(NOTE_TEXT, null);
    }

    private void getDateFromSharedPref(){
        String noteTxt = getText();
        mInputNote.setText(noteTxt);
    }
}