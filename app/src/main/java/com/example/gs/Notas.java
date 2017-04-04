package com.example.gs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static android.R.attr.category;
import static android.R.attr.data;

public class Notas extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String Userid;
    ListView listanotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        Userid= getIntent().getStringExtra("UserId");
        listanotas=(ListView)findViewById(R.id.listNotas);
        listanotas.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        new Notasget(this,listanotas).execute(Userid);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    Intent intent=new Intent(this,NotasDetails.class);
        intent.putExtra("UserId",Userid);
        intent.putExtra("asignatura", Notasget.data.get(position).getId() );
        startActivity(intent);


    }


}
