package com.example.gs;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.CalendarContract;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Spinner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;

/**
 * Created by carles on 13/02/2017.
 */

public class EventsGet extends AsyncTask<String,String,String> {
    private Context context;
    CalendarView calendar;


    public EventsGet(Context context,CalendarView cal) {
        this.context = context;
        this.calendar=cal;

    }
    protected void onPreExecute(){
    }
    public String doInBackground(String... arg0) {
        try {

            String link = "http://goodstudent.es/goodStudentPHP/EventsGet.php";
            URL url = new URL(link);
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(link));
            HttpResponse response = client.execute(request);
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(response.getEntity().getContent()));

            StringBuffer sb = new StringBuffer("");
            String line = "";

            while ((line = in.readLine()) != null) {
                sb.append(line);

                break;
            }

            in.close();
            return sb.toString();
        } catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }
    public void onPostExecute(String result){
        String[] events= result.split(";");
        for(int i=0;i<events.length;i++) {
            String[] event=events[i].split(":");





        }

    }
}
