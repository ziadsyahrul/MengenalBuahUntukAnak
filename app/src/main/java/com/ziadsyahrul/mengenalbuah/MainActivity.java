package com.ziadsyahrul.mengenalbuah;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //TODO 2 Menginisiasikan widget recycleview
    @BindView(R.id.myRecycle)
    RecyclerView myRecycle;

    //TODO 3 Membuat variable array untuk menampung data
    String namaBuah[] = {"alpukat", "apel", "ceri", "durian", "jambu air", "manggis", "stroberry"};

    int gambar_buah[] = {R.drawable.alpukat, R.drawable.apel, R.drawable.ceri, R.drawable.durian, R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry};

    int suara_buah[]= {R.raw.alpukat, R.raw.apel, R.raw.ceri, R.raw.durian, R.raw.jambuair, R.raw.manggis, R.raw.strawberry};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //TODO 4 Membuat object untuk adapter agar bisa dapat digunakan dan mengisi parameter yang dibutuhkan
        com.ziadsyahrul.mengenalbuah.Adapter adapter = new com.ziadsyahrul.mengenalbuah.Adapter(MainActivity.this,gambar_buah, suara_buah, namaBuah);


        //TODO 5 Mensetting recycleview dan memasukkan Adapter ke recycleview
        myRecycle.setHasFixedSize(true);
        myRecycle.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        myRecycle.setAdapter(adapter);

    }
}
