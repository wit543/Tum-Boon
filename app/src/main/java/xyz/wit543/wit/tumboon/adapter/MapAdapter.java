package xyz.wit543.wit.tumboon.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import xyz.wit543.wit.tumboon.R;
import xyz.wit543.wit.tumboon.model.Game;
import xyz.wit543.wit.tumboon.model.Map;

/**
 * Created by WIT on 27-May-16.
 */
public class MapAdapter extends RecyclerView.Adapter<MapAdapter.MapViewHolder> {
    private List<Map> maps;

    public MapAdapter(List<Map> maps) {
        this.maps = maps;
    }


    @Override
    public MapViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.map_cell, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new MapViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MapViewHolder holder, int position) {
        holder.layerRecyclerView.setAdapter(new LayerAdapter(Game.getInstance().getMaps().get(position).getLayers()));
    }



    @Override
    public int getItemCount() {
        return maps.size();
    }

    public static class MapViewHolder extends RecyclerView.ViewHolder{
        RecyclerView layerRecyclerView;
        public MapViewHolder(View itemView) {
            super(itemView);
            layerRecyclerView=(RecyclerView) itemView.findViewById(R.id.layer_recycle_view);

    }
    }
}
