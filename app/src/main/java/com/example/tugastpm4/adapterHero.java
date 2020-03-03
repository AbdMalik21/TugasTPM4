package com.example.tugastpm4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapterHero extends RecyclerView.Adapter<adapterHero.ViewHolder> {
    private Context context;
    private ArrayList<modelHero> mP;
    private Detail detail1;

    public void setDetail1(Detail detail1) {
        this.detail1 = detail1;
    }

    public adapterHero(Context context) {
        this.context = context;
    }

    public ArrayList<modelHero> getmP() {
        return mP;
    }

    public void setmP(ArrayList<modelHero> mP) {
        this.mP = mP;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemhero,parent,false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Glide.with(context).load(getmP().get(position).getHeroImages()).into(holder.ivheroImages);
        holder.tvheroNames.setText(getmP().get(position).getHeroName());
        holder.tvheroDetails.setText(getmP().get(position).getHeroDetail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detail1.detail(mP.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return getmP().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivheroImages;
        private TextView tvheroNames, tvheroDetails;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivheroImages = itemView.findViewById(R.id.imgad);
            tvheroNames = itemView.findViewById(R.id.tvad);
            tvheroDetails = itemView.findViewById(R.id.tvketad);
        }
    }

    public interface Detail{
        void detail(modelHero mP);
    }
}

