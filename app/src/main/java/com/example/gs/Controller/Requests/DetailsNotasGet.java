package com.example.gs.Controller.Requests;

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
 * Created by Carles on 04/04/2017.
 */

public class DetailsNotasGet extends AsyncTask<String,String,String> {
    private Context context;
    TextView curso,profesor,actividad,nota,comentario;
    private List<ItemModel> data;

    public DetailsNotasGet(Context context, TextView Curso,TextView Profesor,TextView Nota,TextView Comentario,TextView Actividad ) {
        this.context = context;
        this.curso = Curso;
        this.actividad = Actividad;
        this.profesor= Profesor;
        this.nota= Nota;
        this.comentario= Comentario;


    }
    protected void onPreExecute(){
    }
    public String doInBackground(String... arg0) {
        try {
            String Userid = (String)arg0[0];
            String activitat = (String)arg0[1];
            String link = "http://goodstudent.es/goodStudentPHP/NotasDetailGet.php?UserId=" + Userid+"&&AsignId="+activitat;
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

    String[] notaDetail=result.split(";");
        curso.setText(notaDetail[0]);
        actividad.setText(notaDetail[1]);
        nota.setText(notaDetail[2].substring(0,1));
        comentario.setText(notaDetail[3]);
        profesor.setText(notaDetail[4]);

    }

}


