package com.example.lenovo.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewPresidentAdapetr extends RecyclerView.Adapter<CardViewPresidentAdapetr.CategoryViewHolder> {

    private Context context;

    public CardViewPresidentAdapetr(Context context) {
        this.context = context;
    }

    public ArrayList<President> getListPresident() {
        return listPresident;
    }

    public void setListPresident(ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }

    private ArrayList<President>listPresident;
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_president,viewGroup,false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        President p = getListPresident().get(position);
        Glide.with(context)
                .load(getListPresident().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 350))
                .into(categoryViewHolder.imgPhoto);
        categoryViewHolder.tvName.setText(p.getNama());
        categoryViewHolder.tvRemarks.setText(p.getRemaks());
        categoryViewHolder.btnFaporit.setOnClickListener(new CustomOnclickClickListener(position, new CustomOnclickClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context,"Favorit "+getListPresident().get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        }));
        categoryViewHolder.btnShare.setOnClickListener(new CustomOnclickClickListener(position, new CustomOnclickClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share "+getListPresident().get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListPresident().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFaporit, btnShare;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto=itemView.findViewById(R.id.img_item_photo);
            tvName=itemView.findViewById(R.id.tv_item_remarks);
            tvRemarks=itemView.findViewById(R.id.tv_item_remarks);
            btnFaporit=itemView.findViewById(R.id.btn_set_favorite);
            btnShare=itemView.findViewById(R.id.btn_set_share);
        }
    }
}
