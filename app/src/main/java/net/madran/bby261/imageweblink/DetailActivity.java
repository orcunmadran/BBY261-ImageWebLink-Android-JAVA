package net.madran.bby261.imageweblink;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    private TextView detayText;
    private ImageView detayImage;

    //private String[] detayListe;
    private int[] detayListe;
    private int[] detayImageListe;
    private String[] detayUrlListe;

    private String pozisyonAnahtari = "pozisyonAnahtari";

    private int detayPozisyon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detayText = (TextView) findViewById(R.id.detayTextView);
        detayImage = (ImageView) findViewById(R.id.detayImageView);



        //detayListe = new String[] { "Detay 1", "Detay 2", "Detay 3", "Detay 4", "Detay 5"};
        detayListe = new int[] {R.string.detail_1, R.string.detail_2,R.string.detail_3, R.string.detail_4, R.string.detail_5};
        detayImageListe = new int[] {R.drawable.book_a, R.drawable.book_b, R.drawable.book_c, R.drawable.book_d, R.drawable.book_e};
        detayUrlListe = new String[] {"http://www.idefix.com", "http://www.dr.com.tr", "http://www.ykykultur.com.tr/", "https://www.iskultur.com.tr/", "https://www.amazon.com/"};

        detayPozisyon = getIntent().getIntExtra(pozisyonAnahtari, -1);


        if (detayPozisyon == -1) {
            Toast.makeText(DetailActivity.this, "Hata Var!", Toast.LENGTH_LONG).show();
        } else {
            //detayText.setText(detayListe[detayPozisyon]);
            detayText.setText(detayListe[detayPozisyon]);
            detayImage.setImageResource(detayImageListe[detayPozisyon]);
        }


        detayImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (detayPozisyon == -1) {
                    Toast.makeText(DetailActivity.this, "Hata Var!", Toast.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(detayUrlListe[detayPozisyon]));
                    startActivity(i);
                }

            }
        });

    }
}
