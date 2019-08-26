package com.example.lenovo.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailCard extends AppCompatActivity {

    TextView nama;
    TextView deskripsi;
    ImageView gambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_card);
        Bundle bundle= getIntent().getExtras();
        nama=findViewById(R.id.tv_nama);
        deskripsi=findViewById(R.id.tv_deskripsi);
        gambar=findViewById(R.id.img_item_photo);
        nama.setText(bundle.getString("nama").toString());
        deskripsi.setText(bundle.getString("deskripsi").toString());
        Glide.with(this)
                .load(bundle.getString("gambar"))
                .apply(new RequestOptions().override(55, 55))
                .into(gambar);
    }
}
