package com.example.essential;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SBL extends AppCompatActivity {
    EditText textoPrincipal;
    TextView repuesta, definicion;
    CheckBox checkBox;
    Button enter,replay;
    int  orden, inicio,fin;
    int sR;
    double total, buenas;
    TextReader textReader;

    View v;
    int contadorGeneral;
    int contadorLocal;
    String pathData,wordD;
    String archivo[][] = new String [10000][30];
    String nA[][] = new String [10000][30];
    String arrRespuestaOriginal[];
    String arrRespuestaconseguida[];

    Fecha fecha;
    String hoy;
    Reproductor play;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sbl);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        textReader = new TextReader();
        pathData = "/sdcard/DataEssential.csv";
        textReader.checkPermission(this);
        textoPrincipal =(EditText) findViewById(R.id.l_txtprincipal);
        repuesta =(TextView) findViewById(R.id.l_respuesta);
        definicion =(TextView) findViewById(R.id.definition);
        checkBox =(CheckBox) findViewById(R.id.checkBox);
        replay =(Button) findViewById(R.id.l_replay);
        enter =(Button) findViewById(R.id.lenter);



        fecha = new Fecha();
        play =new Reproductor();
        cargar();
        depurar();
        sR =0;
        main(v);
        total =0;
        buenas=0;



    }

    public  void main(View v)
    {


        wordD= "/sdcard/Music/"+nA[sR][10]+"_D.mp3";
        play.reproducir(wordD);
        //definicion.setText(nA[sR][6]);
        enter.setText("PT" +nA[sR][7]+"  U"
                +nA[sR][8]+"  "
                +"L"+nA[sR][9]);
    }

    public void depurar()
    {
        inicio = Practice.inicioFin[0];
        fin = Practice.inicioFin[1];


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

    public void comprobar(View v)
    {
        String s=nA[sR][6];
        String m= textoPrincipal.getText().toString();
        arrRespuestaOriginal = new String[200];
        arrRespuestaconseguida=new String[200];
        arrRespuestaOriginal= s.split(" ");
        arrRespuestaconseguida=m.split(" ");


        try {
            if(s.equalsIgnoreCase(m))
            {
                setLabel(true);
                setArchivo(true);
                buenas++;
                sR++;
            }
            else
            {
                setLabel(false);
                setArchivo(false);
            }
            total++;
            porcentaje();
            Safe safe = new Safe();
            //safe.safe("/sdcard/data.csv",archivo);



            if(nA[sR][0]==null)
            {
                sR=0;
            }

            orden = Integer.parseInt(nA[sR][0]);
            wordD= "/sdcard/Music/"+nA[sR][10]+"_D.mp3";

            textoPrincipal.setText("");
            play.reproducir(wordD);
            //definicion.setText(nA[sR][6]);

            // ter.setText("PT"+nA[sR][7]+"  U" +nA[sR][8]+"  " +"L"+nA[sR][9]);

        } catch (Exception e)
        {
            Toast.makeText(this,e+"",Toast.LENGTH_LONG).show();
        }

    }

    public void setLabel(boolean b)
    {
        if(b==true)
        {
            repuesta.setText(" R: ");
            definicion.setText(" R: ");
        }
        else
        {
            String palabra="";
            int contador =0;
            int longitud = arrRespuestaOriginal.length;
            while(contador <= longitud-1)
            {
                palabra =  palabra + (arrRespuestaOriginal[contador]+" ");

                contador++;
            }
            palabra=palabra.trim();

            definicion.setText(palabra);

            contador =0;
            longitud = arrRespuestaconseguida.length;
            palabra="";
            String u = "";


            while(contador <= longitud-1)
            {
                boolean f = false;

                palabra =  palabra + (arrRespuestaconseguida[contador]+" ");
                contador++;

            }
            palabra=palabra.trim();

            repuesta.setText(palabra);

        }


    }

    public void setArchivo(boolean b)
    {

        orden = Integer.parseInt(nA[sR][0]);


        hoy=fecha.getDate();

        archivo[orden][4]=hoy;
    }


    public void replay(View v)
    {
        play.reproducir(wordD);
    }

    public void cargar()
    {
        archivo=textReader.cargar(pathData);
    }

    public void porcentaje()
    {
        double porciento = (buenas/total)*100;
        int por= (int) Math.round(porciento);
        replay.setText(por+"%");



    }


    public boolean buscarSimilitud(String s)
    {
        boolean flag = false;
        int cont=0;
        while (cont <=arrRespuestaOriginal.length)
        {
           if(arrRespuestaOriginal[cont].equalsIgnoreCase(s))
           {
               flag=true;
           }
           cont++;
        }
        return flag;
    }



}

