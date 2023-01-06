package com.example.englishwordnote.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import com.example.englishwordnote.Models.EnglishWord;
import com.example.englishwordnote.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private Button btnSeeAll, btnSaved, btnAbout;
    private SearchView searchView;
    private FloatingActionButton btnAdd;
    private Intent intent;
//    public static ArrayList<EnglishWord> words;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();

//        words = new ArrayList<>();
        setOnNavigationToActivity(this, AllWordsActivity.class, btnSeeAll);
        setOnNavigationToActivity(this, SavedWordActivity.class, btnSaved);
        setOnNavigationToActivity(this, AboutActivity.class, btnAbout);
        setOnNavigationToActivity(this, AddWordActivity.class, btnAdd);

    }

    private void initViews(){
        btnSeeAll = findViewById(R.id.btnSeeAll);
        btnAdd = findViewById(R.id.btnAdd);
        btnSaved = findViewById(R.id.btnSaved);
        btnAbout = findViewById(R.id.btnAbout);

    }

    private Intent initIntentNavigationToActivity(Context context, Class<?> cls){
        Intent intent = new Intent(context, cls);
        return intent;
    }

    private void setOnNavigationToActivity(Context context, Class<?> cls, View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(initIntentNavigationToActivity(context, cls));
            }
        });
    }

}