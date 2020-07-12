package com.example.transparentactionbarsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Results extends AppCompatActivity {


    dbHelper dbh;
    TextView rNames,rCols;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        rNames=(TextView)findViewById(R.id.rName);
        rCols=(TextView)findViewById(R.id.rCol);
    }

    public void showData(View view) {
        dbh=new dbHelper(this);
        SQLiteDatabase showData= dbh.getReadableDatabase();
        String projection[]={"sname","scollege"};


        Cursor c= showData.query("stud", projection,null,null,null,null,null);
        c.moveToLast();

        String projection2[]={"scollege"};
        c.moveToLast();
        rNames.setText(c.getString(0));
        rCols.setText(c.getString(1));
        //Log.i(" College Name:-",c1.getString(1));

    }

    public void goBack(View view) {

            Intent i1= new Intent(this,MainActivity.class);
            startActivity(i1);
            kill_activity();
        }
    void kill_activity()
    {
        finish();
    }


}
