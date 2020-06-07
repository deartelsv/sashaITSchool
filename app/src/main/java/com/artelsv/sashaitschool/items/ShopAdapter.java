package com.artelsv.sashaitschool.items;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.artelsv.sashaitschool.R;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {

    private ArrayList<Item> items;

    public ShopAdapter(ArrayList<Item> items) {
        //this.numberItems = numberItems;
        this.items = items;
    }

    public void removeAt(int position, Drawable emptyDrawable) {
//        items.remove(position);
//        notifyItemRemoved(position);
//        notifyItemRangeChanged(position, items.size());
        Item emptyItem = new Item("empty", "nothing", 0, 0, emptyDrawable, false);
        items.set(position, emptyItem);
        notifyDataSetChanged();
    }

    public void removeAt(int position) {
//        items.remove(position);
//        notifyItemRemoved(position);
//        notifyItemRangeChanged(position, items.size());
        items.remove(position);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ShopAdapter.ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.inventory_store_item;

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutId, parent,false);

        ShopViewHolder viewHolder = new ShopViewHolder(view);

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
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

    class ShopViewHolder extends RecyclerView.ViewHolder {
        //item vars
        ImageView itemImage;
        //

        public ShopViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.info_text);
        }
    }
}
