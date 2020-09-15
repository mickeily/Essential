package com.example.essential;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Listening extends AppCompatActivity {


    TextReader textReader;
    String archivo[][],nA[][];
    String pathData;
    Reproductor mp;
    Button select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening);
        select=(Button)findViewById(R.id.select);
        archivo= new String[10000][30];
        nA= new String[10000][30];
        textReader =new TextReader();
        mp = new Reproductor();

        pathData = "/sdcard/DataEssential.csv";
        cargar();
        select();
    }

    public void cargar()
    {
        archivo=textReader.cargar(pathData);
    }

    public void select()
    {
        int cont=0;
        int contador=0;
        while (archivo[contador][0]!=null)
        {
           if(archivo[contador][11].equals("select"))
           {
               nA[cont]=archivo[contador];
               cont++;

           }
           contador++;
        }
        int a = 0;
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
