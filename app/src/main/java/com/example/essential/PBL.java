package com.example.essential;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class PBL extends AppCompatActivity {

    String archivo[][];
    String nA[][] = new String [10000][30];
    String temporal[][] = new String [500][30];
    String pathData="";
    TextReader textReader;
    Fecha fecha;
    String hoy;
    Reproductor play;
    int ondenReproduccion, tope;

    float buena,total;
    Button enter,replay;
    EditText textoPrincipal,txtTope;
    TextView repuesta;
    TextView definicion;
    int sumatoria;
    int  orden, inicio,fin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pbl);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        archivo= new String[10000][30];
        pathData = "/sdcard/DataEssential.csv";
        textReader=new TextReader();
        play= new Reproductor();
        fecha = new Fecha();
        archivo= textReader.cargar(pathData);
        hoy=fecha.getDate();

        ondenReproduccion=0;
        tope =0;

        enter = (Button) findViewById(R.id.lenter);
        replay= (Button) findViewById(R.id.l_replay);
        repuesta=(TextView) findViewById(R.id.l_respuesta);
        definicion=(TextView) findViewById(R.id.definition);
        textoPrincipal=(EditText) findViewById(R.id.l_txtprincipal);
        txtTope=(EditText) findViewById(R.id.limite);


        buena=0;
        total=0;
        sumatoria=0;


        cargar();
        depurar();
        modificar();
        abilitar();

    }

    public void cargar()// este metodo carga el archivo general
    {
        archivo=textReader.cargar(pathData);
    }

    public void depurar()// este metodo depura el archivo para solo cargar lo seleccionado para practicar
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
            tope = cont;
        }



    }

    public void abilitar()
    {

        if(tope>0 )
        {
            play.reproducir(nA[ondenReproduccion][12]);
            String word = (nA[ondenReproduccion][10]);

            String cadena = (nA[ondenReproduccion][6]);
            cadena = cadena.toLowerCase();
            cadena = cadena.replaceAll(word,"______");
            definicion.setText(cadena);

            makeText(this,"Have been charged " +tope+ " files", Toast.LENGTH_LONG).show();

        }
        else
        {
            makeText(this,"No se an cargado archivos", Toast.LENGTH_LONG).show();
            enter.setEnabled(false);
            replay.setEnabled(false);
            textoPrincipal.setEnabled(false);


        }

    }

    public void comprobar(View view)
    {


        if(textoPrincipal.getText().toString().equals(nA[ondenReproduccion][10]))
        {
            repuesta.setText("");
            set();
            buena++;
        }
        else
        {
            repuesta.setText(nA[ondenReproduccion][10]);
        }
        total++;

        textoPrincipal.setText("");

        int re= reorganizar();

        if (re> 0)
        {
            String a;
            porcentaje();
            ondenReproduccion  = octenerRandon(0,re-1);
            play.reproducir(nA[ondenReproduccion][12]);
            String word = (nA[ondenReproduccion][10]);
            String cadena = (nA[ondenReproduccion][6]);

            cadena = cadena.toLowerCase();
            cadena = cadena.replaceAll(word,"______");
            definicion.setText(cadena);
            a=replay.getText().toString();
            replay.setText(nA[ondenReproduccion][0]+ "--"+a);
        }


    }

    public void replay(View view)

    {
        play.reproducir(nA[ondenReproduccion][12]);
    }

    public int restante()
    {
        int contador=0;
        int var=0;
        int acomulador=0;

        while (nA[contador][0]!=null)
        {
            var=Integer.parseInt(nA[contador][0]);
            acomulador+=var;
            contador++;
        }

        return acomulador;
    }

    public void modificar()// Este metodo modifica el arreglo para asignar cinco puntos a  todas los items
    {


        int contador =0;
        int limite=tope-1;
        while (limite>=0)
        {
            nA[contador][0]="5";
            temporal[contador]=nA[contador];
            contador++;

            limite--;

        }

        nA=temporal;

    }

    public void set()
    {
        int a = Integer.parseInt(nA[ondenReproduccion][0]);
        a--;
        nA[ondenReproduccion][0]=a+"";

    }



    public int reorganizar()
    {
        boolean flag=false;
        String temporal [][]=new String [500][30];
        int contador =0;
        int cont=0;
        while (nA[contador][0]!=null)
        {
            int a = Integer.parseInt(nA[contador][0]);
            if(a>0)
            {
                temporal[cont]=nA[contador];
                flag=true;
                cont++;
            }
            contador++;

        }
        if(flag==true)
        {
            nA=temporal;
            return contador;
        }
        else
        {
            Toast.makeText(this,"You had finished",Toast.LENGTH_SHORT).show();
            enter.setEnabled(false);
            replay.setEnabled(false);
            textoPrincipal.setEnabled(false);
            return 0;
        }

    }


    public int octenerRandon(int min, int max)
    {
        int numero;
        numero=(int)(Math.random()*(max-min))+min;
        return numero;

    }


    public void porcentaje()
    {
        double porciento = (buena/total)*100;
        int por= (int) Math.round(porciento);
        replay.setText(por+"%");
    }
}
