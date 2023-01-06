package com.example.englishwordnote.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.englishwordnote.Models.EnglishWord;
import com.example.englishwordnote.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class WordDetailActivity extends AppCompatActivity {
    private TextView txtWord, txtMeaning, txtDefinition, txtExample;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_detail);

        initViews();
        Gson gson = new Gson();
        Type type = new TypeToken<EnglishWord>(){}.getType();
        Intent intent = getIntent();
        String data = intent.getExtras().getString("detail","");
        EnglishWord word = gson.fromJson(data,type);
        if(data.equals("")){
            Toast.makeText(this, "Unable to get data", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Get data successfully", Toast.LENGTH_SHORT).show();
            setDataForViews(word);
        }
    }
    private void initViews(){
        txtWord = findViewById(R.id.txtDWord);
        txtMeaning = findViewById(R.id.txtDMeaning);
        txtDefinition = findViewById(R.id.txtDDefinition);
        txtExample = findViewById(R.id.txtDExample);
    }
    private void setDataForViews(EnglishWord word){
        txtWord.setText(word.getWord());
        txtMeaning.setText(word.getMeanings());
        txtDefinition.setText(word.getDefinition());
        txtExample.setText(word.getExample());
    }
}