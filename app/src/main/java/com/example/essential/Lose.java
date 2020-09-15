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

public class Lose extends AppCompatActivity {

    String archivo[][];
    String nA[][] = new String [10000][30];
    String temporal[][] = new String [500][30];
    String pathData="";
    TextReader textReader;
    Fecha fecha;
    String hoy;
    Reproductor play;
    int ondenReproduccion;
    int limite;
    float buena,total;
    Button enter,replay;
    EditText textoPrincipal,txtTope;
    TextView repuesta;
    int sumatoria, tope;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        archivo= new String[10000][30];
        pathData = "/sdcard/DataEssential.csv";
        textReader=new TextReader();
        play= new Reproductor();
        fecha = new Fecha();
        archivo= textReader.cargar(pathData);
        hoy=fecha.getDate();

        ondenReproduccion=0;

        enter = (Button) findViewById(R.id.lenter);
        replay= (Button) findViewById(R.id.l_replay);
        repuesta=(TextView) findViewById(R.id.l_respuesta);
        textoPrincipal=(EditText) findViewById(R.id.l_txtprincipal);
        txtTope=(EditText) findViewById(R.id.limite);

        buena=0;
        total=0;
        sumatoria=0;
        tope =0;
        cargar();

    }

    public void cargar()
    {


        int contador =0;
        limite=0;

        while (archivo[contador][0]!=null)
        {
            if(archivo[contador][4].equals(hoy) && (archivo[contador][2].equals("0")))
            {
                nA[limite]=archivo[contador];
                limite++;
            }
            contador++;

        }
    }

    public void abilitar(View view)
    {
        modificar();


        if(limite>0 )
        {
            play.reproducir(nA[ondenReproduccion][12]);
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
            enter.setText("Enter");
        }
        else
        {
            repuesta.setText(nA[ondenReproduccion][10] + ": " + nA[ondenReproduccion][6]);
            enter.setText(nA[ondenReproduccion][7] + "." + nA[ondenReproduccion][8]);

        }

        textoPrincipal.setText("");

        int re= reorganizar();

        if (re> 0)
        {
            ondenReproduccion  = octenerRandon(0,re-1);
            play.reproducir(nA[ondenReproduccion][12]);
            replay.setText(nA[ondenReproduccion][0]);
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

    public void modificar()
    {
        setTope();

        int contador =0;
        while (contador<tope)
        {
            nA[contador][0]="5";
            temporal[contador]=nA[contador];

            contador++;

        }
        nA=temporal;

    }

    public void set()
    {
        int a = Integer.parseInt(nA[ondenReproduccion][0]);
        a--;
        nA[ondenReproduccion][0]=a+"";

    }

    public void setTope()
    {
        tope= Integer.parseInt(txtTope.getText().toString());
        if(tope>limite)
        {
            tope=limite;
        }

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



}