package com.example.essential;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

public class NewEstadistic extends AppCompatActivity {
    String archivo[][];
    TextReader textReader;
    String pathData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_estadistic);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        textReader = new TextReader();
        archivo= new String[10000][30];
        pathData = "/sdcard/DataEssential.csv";
        archivo= textReader.cargar(pathData);
    }



    public void estadistic()
    {
        int contador=0;
        String a = "";
        while (archivo[contador][0]!=null)
        {
            a= archivo[contador][8];
            switch (a)
            {
                case "1":
                {

                }
            }


        }
    }


    public void calcular()
    {
        int var1 = 0;



    }
}
