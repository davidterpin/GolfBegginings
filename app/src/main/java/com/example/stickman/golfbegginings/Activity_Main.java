package com.example.stickman.golfbegginings;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.stickman.golfbegginings.db.CoursesDataSource;
import com.example.stickman.golfbegginings.db.DBOpenHelper;
import com.example.stickman.golfbegginings.db.HolesDataSource;
import com.example.stickman.golfbegginings.db.StrokesDataSource;
import com.example.stickman.golfbegginings.utilities.Message;

public class Activity_Main extends AppCompatActivity {

    private static final String LOGTAG = "LOGCAT MAIN ACTIVITY : ";
  // SQLiteOpenHelper dbhelper;
  //  SQLiteDatabase database;
        CoursesDataSource coursedata;
        HolesDataSource holesdata;
        StrokesDataSource stokedata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Message.message(this, " MainActivity test");

     //   dbhelper =new DBOpenHelper(this);
     //   database =dbhelper.getWritableDatabase();
        // instantiate data sources
        coursedata = new CoursesDataSource(this);
        holesdata = new HolesDataSource(this);
        stokedata = new StrokesDataSource(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity__main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();
        coursedata.open();
        holesdata.open();
        stokedata.open();
    }

    @Override
    protected void onPause() {
        super.onPause();
        coursedata.close();
        holesdata.close();
        stokedata.close();
    }
}
