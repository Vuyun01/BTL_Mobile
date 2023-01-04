package com.example.calculationapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextInputEditText etxt1, etxt2, etxtResult;
    Button btnClear, btnPlus, btnMinus, btnDivide, btnTimes, btnPow, btnAbout, btnMod;
    String s1, s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        btnClear.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnTimes.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnPow.setOnClickListener(this);
        btnMod.setOnClickListener(this);
        btnAbout.setOnClickListener(this);

    }
    private void initViews(){
        etxt1 = findViewById(R.id.etxtNum1);
        etxt2 = findViewById(R.id.etxtNum2);
        etxtResult = findViewById(R.id.etxtResult);
        btnAbout = findViewById(R.id.btnAbout);
        btnClear = findViewById(R.id.btnClear);
        btnPow = findViewById(R.id.btnPow);
        btnPlus = findViewById(R.id.btnPlus);
        btnDivide = findViewById(R.id.btnDivide);
        btnMinus = findViewById(R.id.btnMinus);
        btnMod = findViewById(R.id.btnModule);
        btnTimes = findViewById(R.id.btnMul);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnModule:
                onMod();
                break;
            case R.id.btnPlus:
                onSum();
                break;
            case R.id.btnMinus:
                onMinus();
                break;
            case R.id.btnDivide:
                onDivide();
                break;
            case R.id.btnPow:
                onPow();
                break;
            case R.id.btnMul:
                onMultiply();
                break;
            case R.id.btnAbout:
                moreInfo();
                break;
            default:
                ClearAllFields();
                break;
        }
    }

    private void setValues(){
        s1 = etxt1.getText().toString();
        s2 = etxt2.getText().toString();
    }
    public void ClearAllFields(){
        etxt1.setText("");
        etxt2.setText("");
        etxtResult.setText("");
    }

    public void onSum(){
        setValues();
        etxtResult.setText("");
        if(s1.equals("") || s2.equals("")){
            Toast.makeText(this, "Please input all fields", Toast.LENGTH_SHORT).show();
        }else{
            int num1 = Integer.parseInt(s1);
            int num2 = Integer.parseInt(s2);
            int result = num1+num2;
            etxtResult.setText(Integer.toString(result));
        }
    }
    public void onMinus(){
        setValues();
        etxtResult.setText("");
        if(s1.equals("") || s2.equals("")){
            Toast.makeText(this, "Please input all fields", Toast.LENGTH_SHORT).show();
        }else{
            int num1 = Integer.parseInt(s1);
            int num2 = Integer.parseInt(s2);
            int result = num1-num2;
            etxtResult.setText(Integer.toString(result));
        }
    }
    public void onDivide(){
        setValues();
        etxtResult.setText("");
        if(s1.equals("") || s2.equals("")){
            Toast.makeText(this, "Please input all fields", Toast.LENGTH_SHORT).show();
        }else{
            double num1 = Double.parseDouble(s1);
            double num2 = Double.parseDouble(s2);
            double result = num1/num2;
            etxtResult.setText(Double.toString(result));
        }
    }

    public void onMultiply(){
        setValues();
        etxtResult.setText("");
        if(s1.equals("") || s2.equals("")){
            Toast.makeText(this, "Please input all fields", Toast.LENGTH_SHORT).show();
        }else{
            long num1 = Integer.parseInt(s1);
            long num2 = Integer.parseInt(s2);
            long result = num1*num2;
            etxtResult.setText(Long.toString(result));
        }
    }

    public void onMod(){
        setValues();
        etxtResult.setText("");
        if(s1.equals("") || s2.equals("")){
            Toast.makeText(this, "Please input all fields", Toast.LENGTH_SHORT).show();
        }else{
            int num1 = Integer.parseInt(s1);
            int num2 = Integer.parseInt(s2);
            int result = num1%num2;
            etxtResult.setText(Integer.toString(result));
        }
    }

    public void onPow(){
        setValues();
        etxtResult.setText("");
        if(s1.equals("") || s2.equals("")){
            Toast.makeText(this, "Please input all fields", Toast.LENGTH_SHORT).show();
        }else{
            int num1 = Integer.parseInt(s1);
            int num2 = Integer.parseInt(s2);
            int result = 1;
            for(int i = 0; i < num2; i++){
                result *= num1;
            }
            etxtResult.setText(Integer.toString(result));
        }
    }
    public void moreInfo(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(
                "Nhóm: 14 (Trần Bá Vũ - 1921050698 | Nguyễn Việt Phương - 1921050469)\n\n"+
                        "Giới thiệu: Đây là Calculator app, mặc dù còn sơ xài về mặt chức năng và giao diện,"+
                        "nhưng app vẫn có đủ các chức năng chính của mọt app tính toán.");
        dialog.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();


    }

}