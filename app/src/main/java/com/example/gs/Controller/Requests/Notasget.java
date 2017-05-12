package com.example.gs.Controller.Requests;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import com.example.gs.Controller.Adapter.MyListadapter;
import com.example.gs.Model.ItemModel;
import com.example.gs.R;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by carles on 11/02/2017.
 */

public class Notasget extends AsyncTask<String,String,String> {
    private Context context;
    ListView listanotas;
    static public List<ItemModel> data;

    public Notasget(Context context, ListView listanotas) {
        this.context = context;

         this.listanotas=listanotas;
    }
    protected void onPreExecute(){
    }
    public String doInBackground(String... arg0) {
        try {
            String Userid = (String)arg0[0];
            String link = "http://goodstudent.es/goodStudentPHP/GetNotas.php?UserId=" + Userid;
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
       data=new ArrayList<ItemModel>();

        String[] todas= result.split(";");

        for(int i=0;i<todas.length;i++){
            String[] notas=todas[i].split(":");
           ItemModel model= new ItemModel(notas[0],notas[1].substring(0,1),notas[2]);
            data.add(model);
        }
        MyListadapter adapter = new MyListadapter((Activity) context,data, R.layout.list_item);
        listanotas.setAdapter(adapter);


    }

}
