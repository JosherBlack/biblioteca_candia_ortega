package com.example.biblioteca_candia_ortega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb1;
    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = (ProgressBar) findViewById(R.id.pb1);
        pb1.setVisibility(View.INVISIBLE);
        btn1 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        new Task().execute();
                                    }
                                }
        );

    }

    class Task extends AsyncTask<String, Void, String>
    {

        @Override
        protected void onPreExecute() {
            pb1.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings)
        {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        public void onPostExecute(String s)
        {
            pb1.setVisibility(View.INVISIBLE);
            Intent i = new Intent(getBaseContext(), home_act.class);
            startActivity(i);
        }
    }

    public void gith(View v)
    {
        ArrayList<String> libros = new ArrayList<String>();

        libros.add("Farenheith");
        libros.add("Revival");
        libros.add("El Alquimista");

        Intent i = new Intent(this, github_act.class);

        i.putExtra("listalibros", libros);

        startActivity(i);
    }
}