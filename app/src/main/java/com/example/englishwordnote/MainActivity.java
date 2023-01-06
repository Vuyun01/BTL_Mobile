package com.example.englishwordnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.englishwordnote.Activities.HomeActivity;

public class MainActivity extends AppCompatActivity {
    public static DatabaseHelper db;
    private Button btnWelcome;
    private TextView txtWelcome, txtSubWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        //init database
        db = new DatabaseHelper(this);
        btnWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
    private void initViews(){
        btnWelcome = findViewById(R.id.btnWelcome);
        txtWelcome = findViewById(R.id.txtWelcome);
        txtSubWelcome = findViewById(R.id.txtsubWelcome);

    }
}