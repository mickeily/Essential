package com.example.essential;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Write extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    public void Escribir(View view)
    {
        try {
            Intent escribir = new Intent(Write.this, MainWriting.class);
            startActivity(escribir);
        } catch (Exception e)
        {
            Toast.makeText(this,""+e,Toast.LENGTH_SHORT).show();
        }

    }

    public void Lose(View view)
    {
        Intent lose = new Intent(Write.this, Lose.class);
        startActivity(lose);
    }

    public void practice(View view)
    {
        try
        {
            Intent practicing = new Intent(Write.this, Practice.class);
            startActivity(practicing);
        }catch (Exception e)
        {
            Toast.makeText(this,e+"",Toast.LENGTH_LONG).show();
        }

    }

    public void Select(View view)
    {
        Intent select = new Intent(this, Select.class);
        startActivity(select);
    }
}
