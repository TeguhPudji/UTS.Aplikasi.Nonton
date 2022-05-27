package com.example.aplikasinonton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listView = findViewById(R.id.listView);
        ListView list = (ListView) findViewById(R.id.listView);

        ArrayList<logo> arrayList = new ArrayList<>();
        arrayList.add(new logo(R.drawable.pilihan,"Pilihan Kami", "Film Terbaru dan Terpopuler"));
        arrayList.add(new logo(R.drawable.genre,"Genre", "Film Berdasarkan Genre"));
        arrayList.add(new logo(R.drawable.negara,"Negara", "Film Berdasarkan Negara"));
        arrayList.add(new logo(R.drawable.tahun,"Tahun", "Film Berdasarkan Tahun"));

        logoAdapter logoAdapter = new logoAdapter(this,R.layout.list_row,arrayList);
        listView.setAdapter(logoAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    startActivity(new Intent(MenuActivity.this,PilihanActivity.class));
                }else if(position==1){
                    //startActivity(new Intent(MenuActivity.this,GenreActivity.class));
                }else if(position==2){
                    //startActivity(new Intent(MenuActivity.this,NegaraActivity.class));
                }else{
                    //startActivity(new Intent(MenuActivity.this,TahunActivity.class));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.info){
            //startActivity(new Intent(this, InfoActivity.class));
        } else if (item.getItemId() == R.id.keluar) {
            startActivity(new Intent(this, KeluarActivity.class));
        }
        return true;
    }
}