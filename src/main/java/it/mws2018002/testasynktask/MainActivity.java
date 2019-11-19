package it.mws2018002.testasynktask;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private ImageView resutlIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resutlIV = findViewById(R.id.result);

       /*
        Button viewBTN = findViewById(R.id.a1_viewBtn);
        viewBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CLICK", "HO CLICCATO!!!!"+ v);
            }
        });
        */
    }


    public void scarica(View view) {
        EditText searchET = findViewById(R.id.searchUrl);
        String url = ""+searchET.getText();

        Intent i = new Intent(this, ResultActivity.class);
        i.putExtra(ResultActivity.PAR_URL, url);
        startActivity( i );
    }

}

