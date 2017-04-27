package com.example.gs;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import com.example.gs.Model.ItemModel;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.List;

/**
 * Created by Carles on 26/04/2017.
 */

public class ProgresGet extends AsyncTask<String,String,String> {
    private Context context;
    TextView mejornota,avgnota,peornota;


    public ProgresGet(Context context, TextView mejornota,TextView avgnota,TextView peornota) {
        this.context = context;
        this.mejornota = mejornota;
        this.avgnota = avgnota;
        this.peornota= peornota;



    }
    protected void onPreExecute(){
    }
    public String doInBackground(String... arg0) {
        try {
            String Userid = (String)arg0[0];

            String link = "http://goodstudent.es/goodStudentPHP/ProgresNotasGet.php?UserId=" + Userid;
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

       String[] notas = result.split(";");
        int[] notascast= new int[notas.length];
        int BestNota=0;
        int LowNota=10;
        float AVGNota=0;

        for(int i=0;i<notas.length;i++) {
            notascast[i]=Integer.parseInt(notas[i].substring(0,1));
            if(notascast[i]>=BestNota){
               BestNota=notascast[i];
            }
            if(notascast[i]<=LowNota){
                LowNota=notascast[i];
            }
            AVGNota=AVGNota+notascast[i];
        }
        AVGNota=AVGNota/notas.length;
        mejornota.setText((String.valueOf( BestNota)));
        avgnota.setText((String.valueOf( AVGNota)));
        peornota.setText((String.valueOf(LowNota)));


    }
}
