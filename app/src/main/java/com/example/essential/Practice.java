package com.example.essential;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Practice extends AppCompatActivity {
    Spinner libroInicio,libroFinal,unidadInicio,unidadFinal, lessionInicio, lessionFinal;
    TextReader textReader;
    public static   String[][] archivo = new String[10000][30];
    public static   String[][] datos = new String[10000][30];
    public static int inicioFin[];
    String pathData;

    Button sbl, lbl;


    String[] libros;
    String[] unidades;
    String[] lessiones;
    ArrayList arrayList;
    Set<Integer> miSet;
    Set<String> miSet2;
    TreeSet myTreeSet;

    private int inicio, fin;
    ArrayAdapter<String> comboAdapter;
    View view;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        textReader= new TextReader();
        pathData = "/sdcard/DataEssential.csv";
        archivo = textReader.cargar(pathData);

        libroInicio = (Spinner) findViewById(R.id.sBook);
        libroFinal = (Spinner) findViewById(R.id.eBook);
        unidadInicio= (Spinner) findViewById(R.id.sUnit);
        unidadFinal = (Spinner) findViewById(R.id.eUnit);
        lessionInicio= (Spinner) findViewById(R.id.sLesson);
        lessionFinal = (Spinner) findViewById(R.id.eLesson);
        inicioFin= new int[2];

        sbl = (Button) findViewById(R.id.sByLesson);
        lbl = (Button) findViewById(R.id.lByLesson);

        buscadorLibros();
        llenarLibro1();


        libroInicio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                buscarUnidad();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        unidadInicio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                buscarLessonInicio();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        lessionInicio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                llenarLibro2();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        libroFinal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                buscarUnidad2();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        unidadFinal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                buscarLessonFinal();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        lessionFinal.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                buscarInicio();
                buscarFinal();
                setInicioFin();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }
    public void buscadorLibros()
    {
        Integer b=0;
        int contador=0;
        miSet = new HashSet<>();

        try {
            while (archivo[contador][0] != null) {
                miSet.add(Integer.parseInt(archivo[contador][7]));
                contador++;

            }
            myTreeSet = new TreeSet();
            myTreeSet.addAll(miSet);
            String a = myTreeSet.toString();
            a = a.replace("[","");
            a = a.replace("]","");
            a = a.replace(" ","");

            libros=a.split(",");
        }catch (Exception e) {
            Toast.makeText(this, e + "", Toast.LENGTH_LONG).show();
        }


    }

    public void llenarLibro1()
    {
        comboAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, libros);
        libroInicio.setAdapter(comboAdapter);

    }

    public void buscarUnidad()
    {

        int contador =0;
        miSet=new HashSet<>();
        String a =libroInicio.getSelectedItem().toString();
        while ((archivo[contador][0]!=null))
        {

            if(archivo[contador][7].equals(a))
            {
                miSet.add(Integer.parseInt(archivo[contador][8]));

            }
            contador++;
        }

        myTreeSet = new TreeSet();
        myTreeSet.addAll(miSet);
        String b = myTreeSet.toString();
        b = b.replace("[","");
        b = b.replace("]","");
        b = b.replace(" ","");
        unidades=b.split(",");



        llenarUnidad1();


    }

    public void llenarUnidad1()
    {
        comboAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, unidades);
        unidadInicio.setAdapter(comboAdapter);

    }

    public void buscarInicio()
    {

        int contador = 0;
        String a = libroInicio.getSelectedItem().toString();
        String b = unidadInicio.getSelectedItem().toString();
        String c = lessionInicio.getSelectedItem().toString();

        while ((archivo[contador][0] != null)) {

            if (archivo[contador][7].equals(a)&&archivo[contador][8].equals(b) &&archivo[contador][9].equals(c)) {
                inicio=contador;
                break;
            }
            contador++;
        }

    }

    public void llenarLibro2()
    {
        comboAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, libros);
        libroFinal.setAdapter(comboAdapter);

    }

    public void buscarUnidad2()
    {
        int contador =0;
        miSet=new HashSet<>();
        String a =libroFinal.getSelectedItem().toString();
        while ((archivo[contador][0]!=null))
        {

            if(archivo[contador][7].equals(a))
            {
                miSet.add(Integer.parseInt(archivo[contador][8]));

            }
            contador++;
        }

        myTreeSet = new TreeSet();
        myTreeSet.addAll(miSet);
        String b = myTreeSet.toString();
        b = b.replace("[","");
        b = b.replace("]","");
        b = b.replace(" ","");
        unidades=b.split(",");

        llenarLeccion2();


    }

    public void llenarLeccion2()
    {
        comboAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, unidades);
        unidadFinal.setAdapter(comboAdapter);

    }

    public void buscarFinal()
    {

        int contador = 0;

        String a = libroFinal.getSelectedItem().toString();
        String b = unidadFinal.getSelectedItem().toString();
        String c = lessionFinal.getSelectedItem().toString();

        while ((archivo[contador][0] != null))
        {

            if (archivo[contador][7].equals(a)&&archivo[contador][8].equals(b)&&archivo[contador][9].equals(c)) {
                fin=contador;
            }
            contador++;
        }
        organizar();


    }

    public void organizar()
    {
        int ini=0;
        int end=0;

        if(inicio>=fin)
        {
            ini=fin;
            end = inicio;
            inicio=ini;
            fin=end;
        }




    }

    public void setDatos()
    {
        int contador =0;
        int cont=0;
        while (archivo[contador][0]!= null)
        {
            if(contador>= inicio && contador<= fin)
            {
                datos[cont]=archivo[contador];
                cont++;
            }
            contador++;

        }


        Toast.makeText(this, "Se an cargado : " + cont + " datos: ", Toast.LENGTH_SHORT).show();


    }

    public void StudyingByLesson(View view)
    {
        Intent sbl = new Intent(Practice.this, SBL.class);
        startActivity(sbl);
    }

    public void ListeningByLesson(View view)
    {
        Intent lbl = new Intent(Practice.this, LBL.class);
        startActivity(lbl);
    }

    public void practicingByLesson(View view)
    {
        Intent pbl = new Intent(Practice.this, PBL.class);
        startActivity(pbl);
    }


    public  void buscarLessonInicio()
    {
        int contador =0;
        miSet2=new HashSet<>();
        String a =libroInicio.getSelectedItem().toString();
        String b =unidadInicio.getSelectedItem().toString();

        while ((archivo[contador][0]!=null))
        {

            if(archivo[contador][7].equals(a) && archivo[contador][8].equals(b))
            {
                miSet2.add(archivo[contador][9]);

            }
            contador++;
        }

        myTreeSet = new TreeSet();
        myTreeSet.addAll(miSet2);
        String c = myTreeSet.toString();
        c = c.replace("[","");
        c = c.replace("]","");
        c = c.replace(" ","");
        lessiones=c.split(",");

        llenarLesson1();


    }

    public void llenarLesson1()
    {
        comboAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, lessiones);
        lessionInicio.setAdapter(comboAdapter);

    }

    public  void buscarLessonFinal()
    {
        int contador =0;
        miSet2=new HashSet<>();
        String a =libroFinal.getSelectedItem().toString();
        String b =unidadFinal.getSelectedItem().toString();

        while ((archivo[contador][0]!=null))
        {

            if(archivo[contador][7].equals(a) && archivo[contador][8].equals(b))
            {
                miSet2.add(archivo[contador][9]);

            }
            contador++;
        }

        myTreeSet = new TreeSet();
        myTreeSet.addAll(miSet2);
        String c = myTreeSet.toString();
        c = c.replace("[","");
        c = c.replace("]","");
        c = c.replace(" ","");
        lessiones=c.split(",");

        llenarLesson2();


    }

    public void llenarLesson2()
    {
        comboAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, lessiones);
        lessionFinal.setAdapter(comboAdapter);

    }

    public void setInicioFin()
    {
        inicioFin[0]=inicio;
        inicioFin[1]=fin;
    }













}
