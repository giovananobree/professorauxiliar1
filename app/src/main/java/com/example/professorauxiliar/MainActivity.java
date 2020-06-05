package com.example.professorauxiliar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btaluno,btprofessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btprofessor =findViewById(R.id.btprofessor);
        btprofessor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this,tela2.class);
                startActivity(it);
            }
        });

       btaluno = findViewById(R.id.btaluno);
       btaluno.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent aluno = new Intent(MainActivity.this,tela3.class);
               startActivity(aluno);

           }
       });


    }
}
