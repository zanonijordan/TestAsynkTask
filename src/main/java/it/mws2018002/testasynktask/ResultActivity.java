package it.mws2018002.testasynktask;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ResultActivity extends AppCompatActivity {
    public static final String PAR_URL = "URL";
    private ImageView resultIV = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultIV = findViewById( R.id.a2_result );
        String url = getIntent().getStringExtra( ResultActivity.PAR_URL );
        //new DowvloadTask().execute( url );
        Picasso.with(this).load(url).into(resultIV);
    }

    private class DowvloadTask extends AsyncTask<String, Void, Bitmap> {
        private Bitmap downloadImage(String url) {
            //---------------------------------------------------
            Bitmap bm = null;
            try {
                URL aURL = new URL(url);
                URLConnection conn = aURL.openConnection();
                conn.connect();
                InputStream is = conn.getInputStream();
                BufferedInputStream bis = new BufferedInputStream(is);
                bm = BitmapFactory.decodeStream(bis);
                bis.close();
                is.close();
            } catch (IOException e) {
                Log.e("Hub","Error getting the image from server : " + e.getMessage().toString());
            }
            return bm;
            //---------------------------------------------------
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String url = urls[0];
            return downloadImage( url );
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            resultIV.setImageBitmap( bitmap );
        }
    }
}
