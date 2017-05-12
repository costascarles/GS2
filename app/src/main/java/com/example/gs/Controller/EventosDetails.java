package com.example.gs.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.gs.R;
import com.example.gs.Controller.Requests.GetEventosDetails;

public class EventosDetails extends AppCompatActivity {
    String Userid;
    String date;
    ListView listaevetns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_details);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Userid= getIntent().getStringExtra("Userid");
        date = getIntent().getStringExtra("date");
        listaevetns=(ListView)findViewById(R.id.listEvents);

        new GetEventosDetails(this,listaevetns).execute(Userid,date);
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
