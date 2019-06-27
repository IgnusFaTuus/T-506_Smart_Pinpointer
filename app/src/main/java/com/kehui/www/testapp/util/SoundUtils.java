package com.kehui.www.testapp.util;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import com.kehui.www.testapp.R;

/**
 * @version 2.0
 * @fileName SoundUtils.java
 */
public class SoundUtils {

    private SoundPool pool;
    public int THUNDER;
    public int HORN;
    public int SONAR;
    public int SCREAM;

    public SoundUtils(Context context) {
        pool = new SoundPool(10, AudioManager.STREAM_MUSIC, 1);

        pool.setOnLoadCompleteListener(
                new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleID, int status) {
                if (status != 0) {
                    Log.e("SoundSystem", "error loading samples");
                    return;
                }
            }
        });

        THUNDER = pool.load(context, R.raw.countdown23, 1);
        SCREAM = pool.load(context, R.raw.countdown22, 1);
        HORN = pool.load(context, R.raw.countdown21, 1);
        SONAR = pool.load(context, R.raw.countdown, 1);
    }


    public void play(final int sampleID) {
        pool.play(sampleID, 1, 1, 1, 0, 1);

    }

}
