package com.example.essential;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Safe
{
    public void safe(String path, String arr[][])
    {
        int contador=0;
        String cadena;
        String arreglo[]=new String[30];
        File datos = new File(path);
        try {
            datos.createNewFile();
            FileOutputStream fout = new FileOutputStream(datos);
            OutputStreamWriter mow = new OutputStreamWriter(fout);

            while (arr[contador][0]!=null)
            {
                cadena="";
                arreglo=arr[contador];
                int cont=0;

                for(int i =0; i< arreglo.length;i++)
                {
                    if (i == 0)
                    {
                        cadena = cadena + arr[contador][i];
                    } else {
                        cadena = cadena + "," + arr[contador][i];
                    }
                }

                mow.append(cadena+"\n");
                contador++;
            }
            mow.close();
            fout.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
