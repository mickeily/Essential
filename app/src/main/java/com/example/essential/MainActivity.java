package com.example.essential;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextReader textReader;
    Button miboton;
    String pathData;

    String arregloSecundario[] =new String[30];
    String archivo[][] = new String [10000][30];
    String nuevoArchivo[][] = new String [10000][30];
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    public String date;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        textReader = new TextReader();
        textReader.checkPermission(this);
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        date = simpleDateFormat.format(calendar.getTime());

    }

    public void Write(View view)
    {
        Intent writing = new Intent(MainActivity.this, Write.class);
        startActivity(writing);
    }

    public void Estadistic(View view)
    {
        Intent estadistic = new Intent(MainActivity.this, Estadistic.class);
        startActivity(estadistic);
    }

    public void Listening(View view)
    {
        Intent listening = new Intent(MainActivity.this, Listening.class);
        startActivity(listening);
    }
}
