package xyz.wit543.wit.tumboon.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import xyz.wit543.wit.tumboon.R;
import xyz.wit543.wit.tumboon.model.Layer;

/**
 * Created by Momo on 26/5/2559.
 */
public class LayerAdapter extends RecyclerView.Adapter<LayerAdapter.LayerRecycleViewHolder> {
    private List<Layer> layers;
    public static class LayerRecycleViewHolder extends RecyclerView.ViewHolder{

        public LayerRecycleViewHolder(View itemView) {
            super(itemView);

        }
    }

    public LayerAdapter(List<Layer> layers) {
        this.layers = layers;
    }

    @Override
    public LayerRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layer_cell, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new LayerRecycleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LayerRecycleViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
