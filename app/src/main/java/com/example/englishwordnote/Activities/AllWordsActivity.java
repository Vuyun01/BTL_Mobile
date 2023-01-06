package com.example.englishwordnote.Activities;

//import static com.example.englishwordnote.Activities.AddWordActivity.ADD_WORD;
//import static com.example.englishwordnote.Activities.HomeActivity.words;

import static com.example.englishwordnote.MainActivity.db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;

import com.example.englishwordnote.Adapter.EnglishWordRecycleViewAdapter;
import com.example.englishwordnote.Models.EnglishWord;
import com.example.englishwordnote.R;
import com.example.englishwordnote.RecyclerViewInterface;
import com.google.gson.Gson;

import java.util.ArrayList;

public class AllWordsActivity extends AppCompatActivity{
    private RecyclerView allWordRecView;
    private SearchView searchView;
    private ArrayList<EnglishWord> words;
    private EnglishWordRecycleViewAdapter englishWordRecViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_words);

        initViews();
        //init asset
        words = db.getAllEnglishWord();
        englishWordRecViewAdapter = new EnglishWordRecycleViewAdapter(this, words);
//        Gson gson = new Gson();
//        Type type = new TypeToken<EnglishWord>(){}.getType();
//        EnglishWord word = gson.fromJson(ADD_WORD,type);
//        words = new ArrayList<>();
//        if(word == null){
//            Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
//        }else{
//            words.add(word);
//        }
//        words.add(new EnglishWord(1,"Important", "Quan trong", "N/A", "N/A", true));
        allWordRecView.setAdapter(englishWordRecViewAdapter);
        allWordRecView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private void initViews(){
        allWordRecView = findViewById(R.id.allWordsRecView);
        searchView = findViewById(R.id.searchView_All);
    }

}