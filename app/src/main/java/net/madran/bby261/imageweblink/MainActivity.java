package net.madran.bby261.imageweblink;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    private ListView anaListeObje;

    private String[] listeElemanlari;

    private String pozisyonAnahtari = "pozisyonAnahtari";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anaListeObje = (ListView) findViewById(R.id.anaListe);


        listeElemanlari = new String[] { "Kitap 1", "Kitap 2", "Kitap 3", "Kitap 4", "Kitap 5"};


        ArrayAdapter<String> basitAdaptor = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id
                .text1, listeElemanlari);


        anaListeObje.setAdapter(basitAdaptor);


        anaListeObje.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(pozisyonAnahtari, position);
                startActivity(intent);

            }

        });

    }

}
