package com.example.hnf.qoryummuhanifah_1202154357_modul3;

/**
 * Created by HNF on 2/25/2018.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class Adapter extends RecyclerView.Adapter<Adapter.MenuViewHolder>  {

        private final LinkedList<String> title;
        private final LinkedList<String> subtitle;
        private final LinkedList<Integer> image;
        private LayoutInflater mInflater;
        private Context context;

        // constructor
        public Adapter(Context context, LinkedList<String> title,
                                  LinkedList<String> subtitle, LinkedList<Integer> image) {
            mInflater = LayoutInflater.from(context);
            this.title = title;
            this.subtitle = subtitle;
            this.image = image;
        }

        // inflate layout untuk item
        @Override
        public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View mItemView = mInflater.inflate(R.layout.list_item, parent, false);
            return new MenuViewHolder(mItemView, this);
        }

        // bind data ke tiap komponen item
        @Override
        public void onBindViewHolder(MenuViewHolder holder, int position) {
            String itemTitle = title.get(position);
            String itemSub = subtitle.get(position);
            int itemImage = image.get(position);

            holder.menuTitle.setText(itemTitle);
            holder.menuSub.setText(itemSub);
            holder.menuImage.setImageResource(itemImage);
        }

        @Override
        public int getItemCount() {
            return title.size();
        }

        class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            public final TextView menuTitle;
            public final TextView menuSub;
            public final ImageView menuImage;
            final Adapter mAdapter;

            // constructor
            public MenuViewHolder(View itemView,Adapter adapter) {
                super(itemView);

                menuTitle = itemView.findViewById(R.id.textTitle);
                menuSub = itemView.findViewById(R.id.textSub);
                menuImage = itemView.findViewById(R.id.imageLogo);

                this.mAdapter = adapter;
                context = itemView.getContext();
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                // ngambil posisi item yang di click
                int mPosition = getLayoutPosition();

                // ngambil datanya
                String itemTitle = title.get(mPosition);
                String itemSub = subtitle.get(mPosition);
                int itemImage = image.get(mPosition);

                // intent ke detail pake extra data
                Intent intent = new Intent(context, detailMenuActivity.class);
                intent.putExtra("title", itemTitle);
                intent.putExtra("subtitle", itemSub);
                intent.putExtra("image", itemImage);
                context.startActivity(intent);

                mAdapter.notifyDataSetChanged();
            }
        }
    }
