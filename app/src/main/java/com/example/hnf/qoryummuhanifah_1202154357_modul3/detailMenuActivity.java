package com.example.hnf.qoryummuhanifah_1202154357_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class detailMenuActivity extends AppCompatActivity {

        ImageView imgLogo, imgBattery;
        TextView textTitle, textLiter;
        ImageButton btnMinus, btnPlus;

        // ada empat level liter 0 - 3 (full)
        int liter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detail_menu);

            Intent intent = getIntent();

            imgLogo = findViewById(R.id.imageView);
            imgBattery = findViewById(R.id.imageBottle);
            textTitle = findViewById(R.id.textTitle);
            textLiter = findViewById(R.id.textLiter);
            btnMinus = findViewById(R.id.btnMinus);
            btnPlus = findViewById(R.id.btnPlus);

            int image = intent.getIntExtra("image", 0);
            imgLogo.setImageResource(image);
            textTitle.setText(intent.getStringExtra("title"));

            btnMinus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    liter--;
                    update_gambar(liter);
                }
            });

            btnPlus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    liter++;
                    update_gambar(liter);
                }
            });
        }

    private void update_gambar(int liter) {
        switch (liter) {
            case 0:
                btnMinus.setEnabled(false);
                btnPlus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_20);
                textLiter.setText(String.valueOf(liter) + "L");

                Toast.makeText(getApplicationContext(),
                        "Air di botol sudah kosong!",
                        Toast.LENGTH_SHORT)
                        .show();
                break;
            case 1:
                btnMinus.setEnabled(true);
                btnPlus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_50);
                textLiter.setText(String.valueOf(liter) + "L");
                break;
            case 2:
                btnMinus.setEnabled(true);
                btnPlus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_80);
                textLiter.setText(String.valueOf(liter) + "L");
                break;
            case 3:
                btnPlus.setEnabled(false);
                btnMinus.setEnabled(true);

                imgBattery.setImageResource(R.drawable.ic_battery_full);
                textLiter.setText(String.valueOf(liter) + "L");

                Toast.makeText(getApplicationContext(),
                        "Air di botol sudah full!",
                        Toast.LENGTH_SHORT)
                        .show();
                break;
        }
    }
}
