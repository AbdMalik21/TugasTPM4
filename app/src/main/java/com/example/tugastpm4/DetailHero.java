package com.example.tugastpm4;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailHero extends AppCompatActivity {
    public static String DATA = "data";
    private TextView detHero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hero);

        detHero = findViewById(R.id.tvdethero);

        modelHero mP = getIntent().getParcelableExtra(DATA);

        if (mP!=null){
            detHero.setText(mP.getHeroDetail());
        }
    }

}
