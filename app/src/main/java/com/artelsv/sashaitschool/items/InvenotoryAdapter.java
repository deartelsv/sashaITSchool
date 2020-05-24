package com.artelsv.sashaitschool.items;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.artelsv.sashaitschool.R;

import java.util.ArrayList;
import android.content.res.Resources;

public class InvenotoryAdapter extends RecyclerView.Adapter<InvenotoryAdapter.InventoryViewHolder> {

    private int numberItems;
    private ArrayList<Item> items;

    public InvenotoryAdapter(ArrayList<Item> items) {
        //this.numberItems = numberItems;
        this.items = items;
    }

    public void removeAt(int position, Drawable emptyDrawable) {
//     items.remove(position);
//        notifyItemRemoved(position);
//        notifyItemRangeChanged(position, items.size());
        Item emptyItem = new Item("empty", "nothing", 0, 0, emptyDrawable, false);
        items.set(position, emptyItem);
        notifyDataSetChanged();
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
        holder.itemImage.setImageDrawable(items.get(position).getIcon());
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    class InventoryViewHolder extends RecyclerView.ViewHolder {
        //item vars
        ImageView itemImage;
        //

        public InventoryViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.info_text);
            //itemImage.setImageDrawable(items.get());
        }

    }

}
