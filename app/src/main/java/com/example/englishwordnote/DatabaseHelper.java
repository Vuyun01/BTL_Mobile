package com.example.englishwordnote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.englishwordnote.Models.EnglishWord;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "EnglishWord.db";
    private static final int VERSION = 1;

    public static final String TABLE_NAME = "english_word_table";
    public static final String WORD_ID = "id";
    public static final String WORD = "word";
    public static final String MEANINGS = "meanings";
    public static final String DEFINITION = "definition";
    public static final String EXAMPLE = "example";
    public static final String IS_SAVED = "issaved";

    //create database
    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    //create tables
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableString = "CREATE TABLE " + TABLE_NAME + " (" +
                WORD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                WORD + " TEXT," +
                MEANINGS + " TEXT,"+
                DEFINITION + " TEXT," +
                EXAMPLE + " TEXT,"+
                IS_SAVED + " BOOL)";
        sqLiteDatabase.execSQL(createTableString);
    }

    //update database
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addItem(EnglishWord word){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(WORD,word.getWord());
        cv.put(DEFINITION,word.getDefinition());
        cv.put(MEANINGS,word.getMeanings());
        cv.put(EXAMPLE,word.getExample());

        long check = db.insert(TABLE_NAME, null, cv);
        if(check == -1){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<EnglishWord> getAllEnglishWord(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sqlCommand = "SELECT * FROM " +TABLE_NAME;
        ArrayList<EnglishWord> result = new ArrayList<>();
        //get result from a query
        Cursor cursor = db.rawQuery(sqlCommand, null);

        if(cursor.moveToFirst()){ //if table has values
            do{
                int id = cursor.getInt(0); //get position of column in table
                String word = cursor.getString(1);
                String meaning = cursor.getString(2);
                String definition = cursor.getString(3);
                String example = cursor.getString(4);
                boolean issaved = cursor.getInt(5) == 1 ? true : false;
                EnglishWord new_word = new EnglishWord(id, word, meaning, definition,example,issaved);
                result.add(new_word);
            }while(cursor.moveToNext()); //if table still has values
        }
        cursor.close();
        db.close();
        return result;
    }
//
    public void deleteItem(EnglishWord word){
        SQLiteDatabase db = this.getReadableDatabase();
        String sqlCommand = "DELETE FROM " + TABLE_NAME +" WHERE " + WORD_ID + " = "+word.getId();
        db.execSQL(sqlCommand);
    }
}
