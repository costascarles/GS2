package com.example.gs.Controller.Requests;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

/**
 * Created by carles on 13/02/2017.
 */

public class CorreosGet extends AsyncTask<String,String,String> {
    private Context context;
    Spinner correo;


    public CorreosGet(Context context, Spinner listanotas) {
        this.context = context;

        this.correo=listanotas;
    }
    protected void onPreExecute(){
    }
    public String doInBackground(String... arg0) {
        try {

            String link = "http://goodstudent.es/goodStudentPHP/CorreosGet.php";
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
        String[] correos= result.split(";");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, correos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        correo.setAdapter(adapter);


    }
}
