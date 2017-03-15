package com.example.gs.Model;

/**
 * Created by Alumne on 06/03/2017.
 */

public class ItemModel {
    private String title,nota;
    private int image;
  public ItemModel(String title, String nota)  {
      this.title=title;
      this.nota=nota;

  }

    public String getTitle(){return title;}

    public String getNota() {
        return nota;
    }

    public void setNota(String dificultad) {
        this.nota = dificultad;
    }







}

