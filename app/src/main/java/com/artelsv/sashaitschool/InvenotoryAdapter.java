package com.artelsv.sashaitschool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class InvenotoryAdapter extends RecyclerView.Adapter<InvenotoryAdapter.InventoryViewHolder> {

    private int numberItems;

    public InvenotoryAdapter(int numberItems) {
        this.numberItems = numberItems;
    }

    @NonNull
    @Override
    public InventoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.inventory_store_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutId, parent,false);

        InventoryViewHolder viewHolder = new InventoryViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InventoryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return numberItems;
    }

    class InventoryViewHolder extends RecyclerView.ViewHolder {
        //item vars
        ImageView itemImage;
        //

        public InventoryViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.info_text);
        }


    }
}
