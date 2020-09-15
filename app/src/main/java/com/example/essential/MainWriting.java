package com.example.essential;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainWriting extends AppCompatActivity {


    EditText textoPrincipal;
    TextView correcto, main;
    TextView definition;
    Button enter,replay;
    CheckBox checkBox;
    int sR, orden;
    TextReader textReader;
    View v;
    int contadorGeneral;
    int contadorLocal;
    String pathData;
    String archivo[][] = new String [10000][30];
    String nA[][] = new String [10000][30];
    Fecha fecha;
    String hoy;
    Reproductor play;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_writing);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        textReader = new TextReader();
        pathData = "/sdcard/DataEssential.csv";
        textReader.checkPermission(this);
        textoPrincipal =(EditText) findViewById(R.id.l_txtprincipal);
        correcto =(TextView) findViewById(R.id.l_respuesta);
        definition =(TextView) findViewById(R.id.definition);
        checkBox =(CheckBox) findViewById(R.id.checkBox);
        //main =(TextView) findViewById(R.id.main);

        replay =(Button) findViewById(R.id.l_replay);
        enter =(Button) findViewById(R.id.lenter);
        cargarArchivo();
        fecha = new Fecha();
        play =new Reproductor();
        depurar();
        main(v);
        sR =0;
        myDefinition(v);





    }

    public  void main(View v)
    {
        //Toast.makeText(this,nuevoArchivo[secuenciaReproduccion][12],Toast.LENGTH_LONG).show();
        play.reproducir(nA[sR][12]);

        enter.setText("PT" +nA[sR][7]+"  U"
                +nA[sR][8]+"  "
                +"L"+nA[sR][9]);

        String word = (nA[sR][10]);
        String cadena = (nA[sR][6]);
        cadena = cadena.toLowerCase();
        cadena = cadena.replaceAll((word),"______");
        definition.setText(cadena);
    }

    public void cargarArchivo()
    {
        archivo = textReader.cargar(pathData);

    }
    public int depurar()
    {
        int dias;
        int puntage;
        String pased;
        while(archivo[contadorGeneral][0]!=null)
        {
            pased  = archivo[contadorGeneral][1];
            puntage = Integer.parseInt(archivo[contadorGeneral][2]);
            dias  = fecha.restarFecha(archivo[contadorGeneral][4]);

            if(pased.equals("null"))
            {
                switch (puntage)
                {
                    case 0:
                    {
                        if(dias>0)
                        {
                            nA[contadorLocal]=archivo[contadorGeneral];
                            contadorLocal++;
                        }
                        break;
                    }

                    case 1:
                    {
                        if(dias>3)
                        {
                            nA[contadorLocal]=archivo[contadorGeneral];
                            contadorLocal++;
                        }
                        break;
                    }

                    case 2:
                    {
                        if(dias>5)
                        {
                            nA[contadorLocal]=archivo[contadorGeneral];
                            contadorLocal++;
                        }
                        break;
                    }

                    case 3:
                    {
                        if(dias>7)
                        {
                            nA[contadorLocal]=archivo[contadorGeneral];
                            contadorLocal++;
                        }
                        break;
                    }

                    case 4:
                    {
                        if(dias>7)
                        {
                            nA[contadorLocal]=archivo[contadorGeneral];
                            contadorLocal++;
                        }
                        break;
                    }

                    case 5:
                    {
                        if(dias>7)
                        {
                            nA[contadorLocal]=archivo[contadorGeneral];
                            contadorLocal++;
                        }
                        break;
                    }

                    case 6:
                    {
                        if(dias>7)
                        {
                            nA[contadorLocal]=archivo[contadorGeneral];
                            contadorLocal++;
                        }
                        break;
                    }

                    case 7:
                    {
                        if(dias>7)
                        {
                            nA[contadorLocal]=archivo[contadorGeneral];
                            contadorLocal++;
                        }
                        break;
                    }

                    case 8:
                    {
                        if(dias>7)
                        {
                            nA[contadorLocal]=archivo[contadorGeneral];
                            contadorLocal++;
                        }
                        break;
                    }

                    case 9:
                    {
                        if(dias>7)
                        {
                            nA[contadorLocal]=archivo[contadorGeneral];
                            contadorLocal++;
                        }
                        break;
                    }
                    default:
                    {
                        break;
                    }

                }
            }


            contadorGeneral++;
        }
        return contadorLocal;
    }
    public void comprobar(View v)
    {
        if(textoPrincipal.getText().toString().equals(nA[sR][10]))
        {
            setLabel(true);
            setArchivo(true);
        }
        else
        {
            setLabel(false);
            setArchivo(false);
        }

        Safe safe = new Safe();
        safe.safe("/sdcard/DataEssential.csv",archivo);

        sR++;

        orden = Integer.parseInt(nA[sR][0]);

        textoPrincipal.setText("");
        play.reproducir(nA[sR][12]);
        String word = (nA[sR][10]);
        String cadena = (nA[sR][6]);
        cadena = cadena.toLowerCase();
        cadena = cadena.replaceAll(word,"______");

        definition.setText(cadena);
        enter.setText("PT"+nA[sR][7]+"  U" +nA[sR][8]+"  " +"L"+nA[sR][9]);
        //main.setText(nA[sR][6]);
        replay.setText(archivo[orden][0]);
    }

    public void setLabel(boolean b)
    {
        if(b==true)
        {
            correcto.setText(" R: ");

        }
        else
        {
            correcto.setText(" R: "+ nA[sR][10]);

        }


    }

    public void setArchivo(boolean b)
    {
        boolean pasar=false;
        orden = Integer.parseInt(nA[sR][0]);
        int puntajeActual =Integer.parseInt(archivo[orden][2]);
        int intentoActual =Integer.parseInt(archivo[orden][3]);
        intentoActual++;
        hoy=fecha.getDate();
        archivo[orden][3]=intentoActual+"";
        archivo[orden][4]=hoy;

        if(b==true)
        {
            puntajeActual++;
            archivo[orden][2]=puntajeActual+"";
        }
        else
        {
            puntajeActual=0;
            archivo[orden][2]=puntajeActual+"";
        }

        pasar= pasar();

        if(pasar==true)
        {
            archivo[orden][1]="pased";
            Toast.makeText(this,"1 had been pased",Toast.LENGTH_SHORT);
        }


    }

    public boolean pasar()
    {
        boolean pased= false;
        int puntaje =Integer.parseInt(archivo[orden][2]);
        int intento =Integer.parseInt(archivo[orden][3]);
        switch (puntaje)
        {
            case 5:
            {
                if(intento<6) pased= true;
                break;
            }
            case 6:
            {
                if(intento<8) pased= true;
                break;
            }
            case 7:
            {
                if(intento<10) pased= true;
                break;
            }
            case 8:
            {
                if(intento<12) pased= true;
                break;
            }
            case 9:
            {
                if(intento<14) pased= true;
                break;
            }
            case 10:
            {
                pased= true;
                break;
            }
            default:
            {
                pased=false;
                break;
            }

        }

        return pased;
    }

    public void replay(View v)
    {
        play.reproducir(nA[sR][12]);
    }

    public void myDefinition(View v)
    {
       if (checkBox.isChecked()== true)
       {
          definition.setVisibility(View.VISIBLE);
       }
       else
       {
           definition.setVisibility(View.INVISIBLE);
       }
    }

}
