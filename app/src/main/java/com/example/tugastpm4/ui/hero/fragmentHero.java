package com.example.tugastpm4.ui.hero;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugastpm4.DetailHero;
import com.example.tugastpm4.R;
import com.example.tugastpm4.adapterHero;
import com.example.tugastpm4.dataHero;
import com.example.tugastpm4.modelHero;

import java.util.ArrayList;

public class fragmentHero extends Fragment {

    private RecyclerView rvTeam;
    private ArrayList<modelHero> listHero = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_hero, container, false);
        rvTeam = root.findViewById(R.id.rv_hero);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTeam.setHasFixedSize(true);
        listHero.addAll(dataHero.getListData());
        rvTeam.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterHero aP = new adapterHero(getContext());
        aP.setmP(listHero);
        rvTeam.setAdapter(aP);
        aP.setDetail1(new adapterHero.Detail() {
            @Override
            public void detail(modelHero mP) {
                Toast.makeText(getContext(), "Memilih "+mP.getHeroName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), DetailHero.class);
                intent.putExtra(DetailHero.DATA,mP);
                startActivity(intent);
            }
        });
    }
}
