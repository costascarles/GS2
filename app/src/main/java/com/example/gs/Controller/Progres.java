package com.example.gs.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.gs.R;
import com.example.gs.Controller.Requests.ProgresGet;

public class Progres extends AppCompatActivity {
TextView mejornota,avgnota,peornota;
    String Userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progres);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        Userid= getIntent().getStringExtra("UserId");
        mejornota =(TextView) findViewById(R.id.BestNoteProgres);
        avgnota =(TextView) findViewById(R.id.AVGNoteProgres);
        peornota =(TextView) findViewById(R.id.LowNoteProgres);
        new ProgresGet(this,mejornota,avgnota,peornota).execute(Userid);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                //NavUtils.navigateUpFromSameTask(this);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
