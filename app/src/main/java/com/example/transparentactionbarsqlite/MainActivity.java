package com.example.transparentactionbarsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    dbHelper dbh;
    TextView tName,tCol;
    ContentValues cv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tName=(TextView)findViewById(R.id.name);
        tCol=(TextView)findViewById(R.id.college);
        dbh= new dbHelper(this);

        ContentValues cv = new ContentValues();


    }

    public void submit(View view) {

    SQLiteDatabase sql=dbh.getWritableDatabase();
    cv = new ContentValues();
    cv.put("sname",tName.getText().toString());
    cv.put("scollege", tCol.getText().toString());
    sql.insert("stud",null,cv);
    Toast.makeText(this,"Data Submitted",Toast.LENGTH_LONG).show();
    }

    public void next(View view) {
        Intent i1= new Intent(this,Results.class);
        startActivity(i1);
    }
}