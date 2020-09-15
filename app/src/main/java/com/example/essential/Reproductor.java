package com.example.essential;

import android.media.MediaPlayer;

public class Reproductor
{
    MediaPlayer mp;

    public void reproducir(String path) {
        try
        {
            if(mp == null)
            {
                playAudio(path);
            }
            else
            {
                destruir();
                playAudio(path);

            }
        }catch (Exception e)
        {
            e.getMessage();
        }


    }

    public void destruir() {
        if (mp != null) {
            mp.release();
            mp = null;
        }
    }

    public void playAudio(String path) {
        try {

            mp = new MediaPlayer();
            mp.setDataSource(path);
            mp.prepare();
            mp.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}



