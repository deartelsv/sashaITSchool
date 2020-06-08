package com.artelsv.Gat.items;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.artelsv.Gat.R;

import java.util.ArrayList;

public class InvenotoryAdapter extends RecyclerView.Adapter<InvenotoryAdapter.InventoryViewHolder> {

    private ArrayList<Item> items;
    public int selected_item = -1;
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

    public void removeAt(int position) {
//     items.remove(position);
//        notifyItemRemoved(position);
//        notifyItemRangeChanged(position, items.size());
        items.remove(position);
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
    public void onBindViewHolder(@NonNull InventoryViewHolder holder, final int position) {
        holder.itemImage.setImageDrawable(items.get(position).getIcon());

    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    class InventoryViewHolder extends RecyclerView.ViewHolder {
        //item vars
        ImageView itemImage;
        ImageView itemMask;
        //

        public InventoryViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.info_text);
            itemMask = itemView.findViewById(R.id.item_mask);
            //itemImage.setImageDrawable(items.get());
        }



    }

}
