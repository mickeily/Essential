package com.example.essential;
import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TextReader
{
    public static final int MY_PERMISSIONG = 1;


    public String[][] cargar(String path)

    {

        String archivo[][] = new String[10000][30];
        String arregloSecundario[] =new String[30];


        File myFile = new File(path);
        try
        {
            FileInputStream fileInputStream = new FileInputStream(myFile);
            BufferedReader myReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String linea="";
            int contador = 0;

            while ((linea= myReader.readLine())!=null)
            {
                arregloSecundario=linea.split(",");
                archivo[contador]=arregloSecundario;
                contador++;

            }
            myReader.close();



        }catch (Exception e)
        {
            e.getMessage();
        }
        return archivo;


    }

    public void checkPermission(Activity activity)
    {
        if(ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(activity,Manifest.permission.READ_EXTERNAL_STORAGE))
            {

            }
            else
            {
                ActivityCompat.requestPermissions(activity, new String[] { Manifest.permission.READ_EXTERNAL_STORAGE} ,MY_PERMISSIONG);
            }
        }
    }

}
