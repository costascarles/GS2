package com.example.gs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class EventosDetails extends AppCompatActivity {
    String Userid;
    String date;
    ListView listaevetns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_details);

        Userid= getIntent().getStringExtra("Userid");
        date = getIntent().getStringExtra("date");
        listaevetns=(ListView)findViewById(R.id.listEvents);

        new GetEventosDetails(this,listaevetns).execute(Userid,date);
    }


}
