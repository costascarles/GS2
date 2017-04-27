package com.example.gs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Progres extends AppCompatActivity {
TextView mejornota,avgnota,peornota;
    String Userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progres);
        Userid= getIntent().getStringExtra("UserId");
        mejornota =(TextView) findViewById(R.id.BestNoteProgres);
        avgnota =(TextView) findViewById(R.id.AVGNoteProgres);
        peornota =(TextView) findViewById(R.id.LowNoteProgres);
        new ProgresGet(this,mejornota,avgnota,peornota).execute(Userid);

    }
}
