package com.example.englishwordnote.Activities;


import static com.example.englishwordnote.MainActivity.db;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.englishwordnote.Models.EnglishWord;
import com.example.englishwordnote.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

public class AddWordActivity extends AppCompatActivity {
    public static final String ADD_WORD = "addword";
    private Button btnAddWord;
    private TextInputEditText etxtWord, etxtMeaning, etxtDefinition, etxtExample;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        initViews();
        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etxtWord.getText().toString();
                String meaning = etxtMeaning.getText().toString();
                String definition = etxtDefinition.getText().toString() != "" ? etxtDefinition.getText().toString() : "N/A";
                String example = etxtExample.getText().toString() != "" ? etxtDefinition.getText().toString() : "N/A";;
                if(name.equals("") || meaning.equals("")){
//                    Toast.makeText(
//                            AddWordActivity.this,
//                            "[" + name + ","+meaning+"," + definition + "," + example+"]",
//                            Toast.LENGTH_SHORT).show();
                    Toast.makeText(
                            AddWordActivity.this,
                            "Please input all fields",
                            Toast.LENGTH_SHORT).show();
                }else{
                    EnglishWord word = new EnglishWord(1, name, meaning, definition, example, false);
//                    words.add(word);
                    if(db.addItem(word)){
                        Toast.makeText(
                            AddWordActivity.this,
                            "Add successfully",
                            Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(
                                AddWordActivity.this,
                                "Something went wrong!",
                                Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });

    }
    private void initViews(){
        btnAddWord = findViewById(R.id.btnCreateWord);
        etxtWord = findViewById(R.id.etxtWord);
        etxtMeaning = findViewById(R.id.etxtMeaning);
        etxtDefinition = findViewById(R.id.etxtDefinition);
        etxtExample = findViewById(R.id.etxtExample);

    }
}