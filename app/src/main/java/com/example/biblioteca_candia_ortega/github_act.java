package com.example.biblioteca_candia_ortega;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Precio;

public class github_act extends AppCompatActivity
{
    private Spinner sp1;
    private TextView et1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);

        sp1 = (Spinner)findViewById(R.id.sp1);
        et1 = (TextView)findViewById(R.id.et1);

        ArrayList<String> listalibros = (ArrayList<String>) getIntent().getSerializableExtra("listalibros");

        ArrayAdapter<String> lib = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listalibros);

        sp1.setAdapter(lib);


    }

    public void mostrar(View v)
    {
        Precio precios = new Precio();

        String libro = sp1.getSelectedItem().toString();

        if(libro.equals("Farenheith"))
        {
            et1.setText("El valor es : " + precios.getFarenheith() );
        }

        if(libro.equals("Revival"))
        {
            et1.setText("El valor es : " + precios.getRevival() );
        }
        if(libro.equals("El Alquimista"))
        {
            et1.setText("El valor es : " + precios.getAlquimista());
        }


    }
}