package xyz.wit543.wit.tumboon.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Momo on 26/5/2559.
 */
public class LayerAdapter extends RecyclerView.Adapter<LayerAdapter.LayerRecycleViewHolder> {
    public static class LayerRecycleViewHolder extends RecyclerView.ViewHolder{

        public LayerRecycleViewHolder(View itemView) {
            super(itemView);
        }
    }


    @Override
    public LayerRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(LayerRecycleViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
