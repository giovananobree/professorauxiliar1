package com.example.professorauxiliar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class tela3 extends AppCompatActivity {

    ListView lst1;
    ArrayList<String> titles = new ArrayList<String>();
    ArrayAdapter arrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        lst1  = findViewById(R.id.lst1);
        SQLiteDatabase db = openOrCreateDatabase("superaula", Context.MODE_PRIVATE, null);
        final Cursor c = db.rawQuery("select * from aula",null);
        int id = c.getColumnIndex("id");
        int Nome = c.getColumnIndex("Nome");
        int Disciplina = c.getColumnIndex("Disciplina");
        int Contato = c.getColumnIndex("Contato");

        titles.clear();

        arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,titles);

        lst1.setAdapter(arrayAdapter);
        final ArrayList<aula> aulaa = new ArrayList<aula>();

        if(c.moveToNext()){
            do{
                aula au = new aula();
                au.id = c.getString(id);
                au.Nome = c.getString(Nome);
                au.Disciplina = c.getString(Disciplina);
                au.Contato = c.getString(Contato);
                aulaa.add(au);

                titles.add(c.getString(id)+"\t" +c.getString(Nome)+"\t" +c.getString(Disciplina)+"\t" +c.getString(Contato));


            }while (c.moveToNext());
            arrayAdapter.notifyDataSetChanged();
            lst1.invalidateViews();


        }





    }
}