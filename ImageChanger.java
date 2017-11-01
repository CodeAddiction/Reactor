package uk.co.reddiapps.reactor;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import java.util.Random;

/**
 * Created by stuaw on 01/11/2017.
 */

public class ImageChanger extends AsyncTask {

    level1 L1 = new level1();
    Handler handler = new Handler();
    Random rnd = new Random();


    @Override
    protected Object doInBackground(Object[] objects) {
        while (L1.level1Points != 50) {
            int colour = rnd.nextInt(2) + 1;
            Log.v("Number random:", "" + colour);
            Log.v("Number points:", "" + L1.level1Points);

            if (colour == 1) {
                L1.bgColor = 1;
                L1.image.setBackgroundColor(Color.parseColor("#FF1744"));
                L1.level1Points++;

            } else if (colour == 2) {
                L1.bgColor = 2;
                L1.image.setBackgroundColor(Color.parseColor("#00E676"));
                L1.level1Points--;

            }


        }
        return null;

    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}
