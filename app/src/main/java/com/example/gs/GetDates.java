package com.example.gs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.widget.ListView;

import com.example.gs.Adapter.MyListadapter;
import com.example.gs.Model.ItemModel;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Carles on 03/05/2017.
 */

public class GetDates extends AsyncTask<String,String,String> {
    private Context context;

    static public List<Date> data;

    public GetDates(Context context) {
        this.context = context;


    }
    protected void onPreExecute(){
    }
    public String doInBackground(String... arg0) {
        try {
            String Userid = (String)arg0[0];
            String link = "http://goodstudent.es/goodStudentPHP/getDates.php?UserId=" + Userid;
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

String bigInteger[] = result.split(";");
        /**
        for(int i=0;i<bigInteger.length;i++){
            long date = Long.parseLong(bigInteger[i]);
            Date d= new Date(date);
            data.add(i,d);
        }**/
        Intent intent=new Intent(context,Calendario.class);
        intent.putExtra("dates",result);
        context.startActivity(intent);

    }
}
