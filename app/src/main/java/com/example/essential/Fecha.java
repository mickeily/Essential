package com.example.essential;


import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Fecha
{
    private String date;
    private Calendar calendar;
    private SimpleDateFormat simpleDateFormat;

    public String getDate()
    {
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        date = simpleDateFormat.format(calendar.getTime());
        return  date;

    }

    public int restarFecha( String fechaTupla)
    {
        String[] fechaD = new String[3];
        String[] fechaT = new String[3];
        fechaD = getDate().split("-");
        fechaT = fechaTupla.split("-");
        int diaD, mesD, agnoD;
        int diaT, mesT, agnoT;
        int totalDiasD, totalDiasT;
        int total = 0;



        diaD = Integer.parseInt(fechaD[0]);
        mesD = Integer.parseInt(fechaD[1]);
        mesD = calcularMes(mesD);
        agnoD = Integer.parseInt(fechaD[2]);
        agnoD = agnoD * 365;
        totalDiasD = diaD + mesD + agnoD;

        diaT = Integer.parseInt(fechaT[0]);
        mesT = Integer.parseInt(fechaT[1]);
        mesT = calcularMes(mesT);
        agnoT = Integer.parseInt(fechaT[2]);
        agnoT = agnoT * 365;
        totalDiasT = diaT + mesT + agnoT;
        total=totalDiasD - totalDiasT;

        return total;

    }
    public int calcularMes(int mes)
    {

        int acomulador = 0;
        int[] fecha = new int[12];
        fecha[0]= 31;
        fecha[1]= 28;
        fecha[2]= 31;
        fecha[3]= 30;
        fecha[4]= 31;
        fecha[5]= 30;
        fecha[6]= 31;
        fecha[7]= 31;
        fecha[8]= 30;
        fecha[9]= 31;
        fecha[10]= 30;
        fecha[11]= 31;

        for(int i=0; i< mes-1; i++)
        {
            acomulador= acomulador+fecha[i];
        }

        return  acomulador;
    }



}


