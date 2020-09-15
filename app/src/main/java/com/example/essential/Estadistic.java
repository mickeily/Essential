package com.example.essential;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Estadistic extends AppCompatActivity
{
    int one, two, three, four, five, six, seven, eight,nine, pased, hechoHoy;
    int uno,dos,tres,cuatro, cinco, seis, siete, ocho, nueve, diez, cbp;
    public  static int total;
    String archivo[][];
    TextReader textReader;
    String pathData;

    TextView Uno,Dos,Tres,Cuatro, Cinco, Seis, Siete, Ocho, Nueve, Diez,Total, txtcbp,totalCero;
    TextView One, Two,Three,Four,Five,Six,Seven,Eight,Nine,Pased,HechoHoy;
    TextView Buno, Bdos,Btres,Bcuatro,Bcinco;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistic);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Buno = (TextView) findViewById(R.id.bone);
        Bdos = (TextView) findViewById(R.id.btwo);
        Btres = (TextView) findViewById(R.id.bthree);
        Bcuatro = (TextView) findViewById(R.id.bfour);
        Bcinco = (TextView) findViewById(R.id.bfive);

        Uno = (TextView) findViewById(R.id.Tuno);
        Dos = (TextView) findViewById(R.id.Tdos);
        Tres = (TextView) findViewById(R.id.Ttres);
        Cuatro = (TextView) findViewById(R.id.Tcuatro);
        Cinco = (TextView) findViewById(R.id.Tcinco);
        Seis = (TextView) findViewById(R.id.Tseis);
        Siete = (TextView) findViewById(R.id.Tsiete);
        Ocho = (TextView) findViewById(R.id.Tocho);
        Nueve = (TextView) findViewById(R.id.Tnueve);
        Diez = (TextView) findViewById(R.id.Tdiez);
        Total = (TextView) findViewById(R.id.Ttotal);
        txtcbp= (TextView) findViewById(R.id.cbp);

        One = (TextView) findViewById(R.id.Tone);
        Two = (TextView) findViewById(R.id.Ttwo);
        Three = (TextView) findViewById(R.id.Tthree);
        Four = (TextView) findViewById(R.id.Tfour);
        Five = (TextView) findViewById(R.id.Tfive);
        Six = (TextView) findViewById(R.id.Tsix);
        Seven = (TextView) findViewById(R.id.Tseven);
        Eight = (TextView) findViewById(R.id.Teight);
        Nine = (TextView) findViewById(R.id.Tnine);
        Pased = (TextView) findViewById(R.id.pased);
        HechoHoy = (TextView) findViewById(R.id.today);
        totalCero = (TextView) findViewById(R.id.totalCero);



        textReader = new TextReader();
        archivo= new String[10000][30];
        pathData = "/sdcard/DataEssential.csv";
        archivo= textReader.cargar(pathData);
        menu();
        estadistic();
        buscarCero();
        madeToday();
    }


    public int menu()
    {
        Fecha fecha;
        fecha= new Fecha();
        int intentos;
        int contador =0;
        String iterador="";
        int resta = 0;

        try
        {
            while (archivo[contador][0]!=null)
            {
                iterador=archivo[contador][2];
                intentos= Integer.parseInt(archivo[contador][3]);
                resta = fecha.restarFecha(archivo[contador][4]);

                switch (iterador)
                {
                    case "0":
                    {
                        if((resta>0))// && (intentos>0))
                        {
                            uno++;
                        }
                        break;
                    }
                    case "1":
                        if(resta>3)
                        {
                            dos++;
                        }

                        break;
                    case "2":
                        if(resta>5)
                        {
                            tres++;
                        }
                        break;
                    case "3":
                        if(resta>7)
                        {
                            cuatro++;
                        }
                        break;
                    case "4":
                        if(resta>7)
                        {
                            cinco++;
                            if(intentos<5)cbp++;
                        }
                        break;
                    case "5":
                        if((resta > 7)&& intentos>5)
                        {
                            seis++;
                            if(intentos<7)cbp++;
                        }

                        break;
                    case "6":
                        if((resta>7)&& intentos>7)
                        {
                            siete++;
                            if(intentos<9)cbp++;
                        }

                        break;
                    case "7":
                        if((resta>7)&& intentos>9)
                        {
                            ocho++;
                            if(intentos<11)cbp++;
                        }
                        break;
                    case "8":
                        if((resta>7)&&intentos>11)
                        {
                            nueve++;
                            if(intentos<13)cbp++;
                        }

                        break;
                    case "9":
                        if((resta>7)&&intentos>13)
                        {
                            diez++;
                            cbp++;
                        }

                        break;
                    default:
                }
                contador++;
            }
            total=uno+dos+tres+cuatro+cinco+seis+siete+ocho+nueve+diez;
            Uno.setText((Uno.getText().toString()+"\t"+ "\t"+ "\t"+uno));
            Dos.setText((Dos.getText().toString()+"\t"+ "\t"+ "\t"+dos));
            Tres.setText((Tres.getText().toString()+"\t"+ "\t"+ "\t"+tres));
            Cuatro.setText((Cuatro.getText().toString()+"\t"+ "\t"+ "\t"+cuatro));
            Cinco.setText((Cinco.getText().toString()+"\t"+ "\t"+ "\t"+cinco));
            Seis.setText((Seis.getText().toString()+"\t"+ "\t"+ "\t"+seis));
            Siete.setText((Siete.getText().toString()+"\t"+ "\t"+ "\t"+siete));
            Ocho.setText((Ocho.getText().toString()+"\t"+ "\t"+ "\t"+ocho));
            Nueve.setText((Nueve.getText().toString()+"\t"+ "\t"+ "\t"+nueve));
            Diez.setText((Diez.getText().toString()+"\t"+ "\t"+ "\t"+diez));
            Total.setText((Total.getText().toString()+"\t"+"\t"+total));
            txtcbp.setText((txtcbp.getText().toString()+"\t"+"\t"+cbp));


        } catch (Exception e)
        {
            e.getStackTrace();
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG);
        }

        return total;
    }

    public void estadistic()
    {
        int contador =0;
        String iterador,pasado="";

        while (archivo[contador][0]!=null)
        {
            iterador=archivo[contador][2];
            pasado = archivo[contador][1];

            if(pasado.equals("null"))
            {
                switch (iterador)
                {
                    case "1":
                    {
                        one++;
                        break;
                    }


                    case "2":
                    {
                        two++;
                        break;
                    }


                    case "3":
                    {
                        three++;
                        break;
                    }

                    case "4":
                    {
                        four++;
                        break;
                    }
                    case "5":
                    {
                        five++;
                        break;
                    }
                    case "6":

                    {
                        six++;
                        break;
                    }

                    case "7":
                    {
                        seven++;
                        break;
                    }

                    case "8":
                    {
                        eight++;
                        break;
                    }
                    case "9":
                    {
                        nine++;
                        break;
                    }
                }
            }
            else
            {
                pased ++;
            }

            contador++;


        }

        One.setText((One.getText().toString()+"\t"+ "\t"+ "\t"+one));
        Two.setText((Two.getText().toString()+"\t"+ "\t"+ "\t"+two));
        Three.setText((Three.getText().toString()+"\t"+ "\t"+ "\t"+three));
        Four.setText((Four.getText().toString()+"\t"+ "\t"+ "\t"+four));
        Five.setText((Five.getText().toString()+"\t"+ "\t"+ "\t"+five));
        Six.setText((Six.getText().toString()+"\t"+ "\t"+ "\t"+six));
        Seven.setText((Seven.getText().toString()+"\t"+ "\t"+ "\t"+seven));
        Eight.setText((Eight.getText().toString()+"\t"+ "\t"+ "\t"+eight));
        Nine.setText((Nine.getText().toString()+"\t"+ "\t"+ "\t"+nine));
        Pased.setText((Pased.getText().toString()+"\t"+pased));


    }

    public void buscarCero()
    {
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        int e=0;

        int contador =0;
        String variable="";
        while (archivo[contador][0]!=null)
        {
            variable=archivo[contador][7];
            switch (variable)
            {
                case "1":
                {
                    if(archivo[contador][2].equals("0"))
                    {
                        a++;
                        break;
                    }

                }

                case "2":
                {
                    if(archivo[contador][2].equals("0"))
                    {
                        b++;
                        break;
                    }

                }
                case "3":
                {
                    if(archivo[contador][2].equals("0"))
                    {
                        c++;
                        break;
                    }

                }
                case "4":
                {
                    if(archivo[contador][2].equals("0"))
                    {
                        d++;
                        break;
                    }

                }
                case "5":
                {
                    if(archivo[contador][2].equals("0"))
                    {
                        e++;
                        break;
                    }

                }


            }
            contador++;


        }
        int f = a+b+c+d+e;
        Buno.setText((Buno.getText().toString()+"\t"+ "\t"+ "\t"+a));
        Bdos.setText((Bdos.getText().toString()+"\t"+ "\t"+ "\t"+b));
        Btres.setText((Btres.getText().toString()+"\t"+ "\t"+ "\t"+c));
        Bcuatro.setText((Bcuatro.getText().toString()+"\t"+ "\t"+ "\t"+d));
        Bcinco.setText((Bcinco.getText().toString()+"\t"+ "\t"+ "\t"+e));
        totalCero.setText((totalCero.getText().toString()+"\t"+ "\t"+ "\t"+f));


    }

    public void madeToday()
    {
        int contador=0;
        int acomulador =0;
        Fecha fecha =new Fecha();
        String a = "";

        try
        {
            while (archivo[contador][0]!=null)
            {
                a=fecha.getDate();

                if(archivo[contador][4].equals(a))
                {
                    acomulador++;

                }

                contador++;
            }

            HechoHoy.setText((HechoHoy.getText().toString()+"\t"+ "\t"+ "\t"+acomulador));

        } catch (Exception e)
        {
            e.getStackTrace();
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}