package com.unir.bibliotecaunir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Atualizar extends AppCompatActivity {

    private Button btnSalvar_atualizar, btnVoltar_atualizar;
    private EditText edtTitulo_atualizar, edtAutor_atualizar, edtAno_atualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar);

        btnSalvar_atualizar = findViewById(R.id.btn_salvar_atualizar);
        btnVoltar_atualizar = findViewById(R.id.btn_voltar_atualizar);
        edtTitulo_atualizar = findViewById(R.id.edt_titulo_atualizar);
        edtAno_atualizar = findViewById(R.id.edt_ano_atualizar);
        edtAutor_atualizar = findViewById(R.id.edt_autor_atualizar);

        Intent intent = getIntent();
        String ids = intent.getStringExtra("id");

        btnSalvar_atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String titulo = edtTitulo_atualizar.getText().toString();
                String autor = edtAutor_atualizar.getText().toString();
                String ano = edtAno_atualizar.getText().toString();

                BancoControlador bd = new BancoControlador(getApplicationContext());
                int aux=Integer.parseInt(ano);
                int id=Integer.parseInt(ids);
                bd.alterarRegistro(id,titulo,autor,aux);

                Toast.makeText(Atualizar.this, "Atualizado com sucesso!", Toast.LENGTH_SHORT).show();

            }
        });

        btnVoltar_atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //onBackPressed();
                Intent intent1=new Intent(Atualizar.this,MainActivity.class);
                startActivity(intent1);

            }
        });
    }
}