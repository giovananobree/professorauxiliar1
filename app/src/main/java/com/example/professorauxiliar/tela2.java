package com.example.professorauxiliar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class tela2 extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        ed1 = findViewById(R.id.Nome);
        ed2 = findViewById(R.id.Disciplina);
        ed3 = findViewById(R.id.Contato);
        b1 = findViewById(R.id.btenviar);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();

            }
        });
    }
    public void insert() {
        try {
            String Nome = ed1.getText().toString();
            String Disciplina = ed2.getText().toString();
            String Contato = ed3.getText().toString();
            SQLiteDatabase db = openOrCreateDatabase("superaula", Context.MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS aula(id INTEGER PRIMARY KEY AUTOINCREMENT,Nome VARCHAR,Disciplina VARCHAR,Contato VARCHAR)");

            String sql = "insert into aula(Nome,Disciplina,Contato)values(?,?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1, Nome);
            statement.bindString(1, Disciplina);
            statement.bindString(1, Contato);
            statement.execute();
            Toast.makeText(this, "Aula cadastrada com sucesso", Toast.LENGTH_SHORT).show();
            ed1.setText("");
            ed2.setText("");
            ed3.setText("");
            ed1.requestFocus();

        } catch (Exception ex) {

            Toast.makeText(this, "Não foi possivel cadastrar a aula", Toast.LENGTH_SHORT).show();

        }
    }

}