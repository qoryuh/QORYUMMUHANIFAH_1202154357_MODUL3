package com.example.hnf.qoryummuhanifah_1202154357_modul3;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class menuListActivity extends AppCompatActivity {

        private final LinkedList<String> menuTitle = new LinkedList<>();
        private final LinkedList<String> menuSub = new LinkedList<>();
        private final LinkedList<Integer> menuImage = new LinkedList<>();

        private RecyclerView mRecyclerView;
        private Adapter mAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu_list);

            // memasukan menu list nya
            menuTitle.addLast("Ades");
            menuTitle.addLast("Amidis");
            menuTitle.addLast("Aqua");
            menuTitle.addLast("Cleo");
            menuTitle.addLast("Club");
            menuTitle.addLast("Equil");
            menuTitle.addLast("Evian");
            menuTitle.addLast("Leminerale");
            menuTitle.addLast("Nestle");
            menuTitle.addLast("Pristine");
            menuTitle.addLast("Vit");

            // masukkan teks nya
            menuSub.addLast("Ini air minum bermerek Ades");
            menuSub.addLast("Ini air minum bermerek Amidis");
            menuSub.addLast("Ini air minum bermerek Aqua");
            menuSub.addLast("Ini air minum bermerek Cleo");
            menuSub.addLast("Ini air minum bermerek Club");
            menuSub.addLast("Ini air minum bermerek Equil");
            menuSub.addLast("Ini air minum bermerek Evian");
            menuSub.addLast("Ini air minum bermerek Leminerale");
            menuSub.addLast("Ini air minum bermerek Nestle");
            menuSub.addLast("Ini air minum bermerek Pristine");
            menuSub.addLast("Ini air minum bermerek Vit");

            // memasukkan gambar
            menuImage.addLast(R.drawable.ades);
            menuImage.addLast(R.drawable.amidis);
            menuImage.addLast(R.drawable.aqua);
            menuImage.addLast(R.drawable.cleo);
            menuImage.addLast(R.drawable.club);
            menuImage.addLast(R.drawable.equil);
            menuImage.addLast(R.drawable.evian);
            menuImage.addLast(R.drawable.leminerale);
            menuImage.addLast(R.drawable.nestle);
            menuImage.addLast(R.drawable.pristine);
            menuImage.addLast(R.drawable.vit);

            // terhubung ke recycler di layout
            mRecyclerView = findViewById(R.id.recyclerView);

            // masukan data ke adapter
            mAdapter = new Adapter(this, menuTitle, menuSub, menuImage);

            // set adapter ke recyclerview
            mRecyclerView.setAdapter(mAdapter);

            // setlayoutmanager untuk recyclerview
            if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                // kalau landscape jadi grid 2 kolom
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            }
            else{
                // kalau portrait jadi linear
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            }
        }
    }

