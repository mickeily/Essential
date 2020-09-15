package com.example.essential;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Select extends AppCompatActivity {

    String archivo[][];
    String pathData="";
    TextReader textReader;
    EditText texto;
    Button bt,select;
    CheckBox check;
    String indice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        texto = (EditText)findViewById(R.id.l_txtprincipal);
        bt = (Button) findViewById(R.id.lenter);
        select = (Button) findViewById(R.id.select);
        check = (CheckBox) findViewById(R.id.check);
        archivo= new String[10000][30];
        pathData = "/sdcard/DataEssential.csv";
        textReader = new TextReader();
        cargar();
    }

    public void cargar()
    {
        archivo=textReader.cargar(pathData);
        int a =0;
    }

    public void buscar(View v)
    {
        int contador =0;
        String text = texto.getText().toString();
        while (archivo[contador][0]!=null)
        {
            if(text.equalsIgnoreCase(archivo[contador][10]))
            {
                indice = archivo[contador][0];
                bt.setText(archivo[contador][10]+ "  " +archivo[contador][7]+ "."+ archivo[contador][8]);
                break;
            }

            contador++;
        }
    }

    public void modificar(View v)
    {
        int index = Integer.parseInt(indice);
        if(check.isChecked())
        {
            archivo[index][11]="select";
        }
        else
        {
            archivo[index][11]="null";
        }

        Safe safe = new Safe();
        safe.safe("/sdcard/DataEssential.csv",archivo);

    }

}
