package com.example.oneweek.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class MyDao {

    private final MySqliteHepler hepler;
    private final SQLiteDatabase database;

    public MyDao(Context context) {
        hepler = new MySqliteHepler(context);
        database = hepler.getWritableDatabase();
    }



    public void selectData(){
        
    }




    public void addData(){

    }

}
