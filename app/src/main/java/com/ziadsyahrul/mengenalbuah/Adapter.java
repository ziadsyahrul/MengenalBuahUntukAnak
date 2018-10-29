package com.ziadsyahrul.mengenalbuah;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    //TODO 1 membuat variable untuk menampung data pada saat objek dibuat dan membawa data menggunakan parameter
    Context context;
    int[] gambarBuah,suaraBuah;
    String[] namaBuah;


    //TODO 2 membuat constructor untuk variable yang sudah kita buat agar dapat menampung parameter
    public Adapter(Context context, int[] gambarBuah, int[] suaraBuah, String[] namaBuah) {
        this.context = context;
        this.gambarBuah = gambarBuah;
        this.suaraBuah = suaraBuah;
        this.namaBuah = namaBuah;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //untuk menentukan tampilan dari Adapter
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_buah, viewGroup, false);
        //mengembalikan nilai untuk memberi tahu recycle view bahwa kita menggunakan view yang sudah kita buat
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        // Mengubah nama buah dengan data buah yang kita miliki
        viewHolder.txtNamaBuah.setText(namaBuah[i]);
        // Menampilkan gambar dengan data gambar yang kita milii menggunakan library glide
        Glide.with(context).load(gambarBuah[i]).into(viewHolder.imgNamaBuah);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailBuahActivity.class);
                pindah.putExtra("nb", namaBuah[i]);
                pindah.putExtra("gb", gambarBuah[i]);
                pindah.putExtra("ab", suaraBuah[i]);
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gambarBuah.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //membuat variable tipe data widget untuk di isi dengan widget yang ada pada layout
        TextView txtNamaBuah;
        ImageView imgNamaBuah;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Menginisiasi/menghubungkan widget ke dalam variable yang sudah dibuat di di atas
            txtNamaBuah = itemView.findViewById(R.id.txtNamaBuah);
            imgNamaBuah = itemView.findViewById(R.id.imgBuah);
        }
    }
}
