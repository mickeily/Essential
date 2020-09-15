package com.example.essential;


import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LBL extends AppCompatActivity {
    String archivo[][],nA[][],archivoAudio[][];
    Practice practice;
    Reproductor mp;
    String pathData="";
    String pathDataAudio="";
    TextReader textReader;

    int inicio,fin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lbl);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        archivo= new String[10000][30];
        nA= new String[10000][30];
        //archivoAudio= new String[10000][30];
        practice= new Practice();
        mp = new Reproductor();
        pathData = "/sdcard/DataEssential.csv";
        //pathDataAudio = "/sdcard/DataEssentialAudio.csv";
        textReader = new TextReader();
        cargar();
        depurar();
    }


    public void cargar()
    {
        archivo=textReader.cargar(pathData);
        //archivoAudio=textReader.cargar(pathDataAudio);
    }

    public void depurar()
    {
        inicio = Practice.inicioFin[0];
        fin = Practice.inicioFin[1];

        //Toast.makeText(this, "El inicio es "+ inicio , Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "El el fin es "+ fin , Toast.LENGTH_SHORT).show();
        int contador=0;
        int cont =0;

        while (archivo[contador][0]!=null)
        {
            if(contador>=inicio && contador <= fin)
            {
                nA[cont]=archivo[contador];
                cont++;
            }
            contador++;
        }



    }

    public void listeningPlay(View v)
    {

        int contador=0;
        while (nA[contador][0]!=null)
        {
            String word= "/sdcard/Music/"+nA[contador][10]+".mp3";
            String wordD= "/sdcard/Music/"+nA[contador][10]+"_D.mp3";
            String wordE= "/sdcard/Music/"+nA[contador][10]+"_E.mp3";
            mp.reproducir(word);



            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mp.reproducir(wordD);
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mp.reproducir(wordE);

            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            contador++;
            if(nA[contador][0]==null)
            {
                contador=0;
            }

        }




    }





}

