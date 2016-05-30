package xyz.wit543.wit.tumboon.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import xyz.wit543.wit.tumboon.R;
import xyz.wit543.wit.tumboon.model.Game;
import xyz.wit543.wit.tumboon.model.Layer;

/**
 * Created by Momo on 26/5/2559.
 */
public class LayerAdapter extends RecyclerView.Adapter<LayerAdapter.LayerRecycleViewHolder> {
    private List<Layer> layers;
    public static class LayerRecycleViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView level;
        TextView rate;
        ProgressBar progressBar;
        Button buyButton;
        SurfaceView animationView;
        public LayerRecycleViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.layer_name);
            level=(TextView)itemView.findViewById(R.id.layer_lv);
            rate=(TextView)itemView.findViewById(R.id.layer_rate);
            progressBar=(ProgressBar)itemView.findViewById(R.id.production_progress_bar);
            buyButton=(Button)itemView.findViewById(R.id.upgrade_button);
            animationView=(SurfaceView)itemView.findViewById(R.id.layer_animation);

        }
    }

    public LayerAdapter(List<Layer> layers) {
        this.layers = layers;
    }

    @Override
    public LayerRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layer_cell, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new LayerRecycleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LayerRecycleViewHolder holder, int position) {
        final Layer layer = layers.get(position);
        holder.name.setText(""+layer.getName());
        holder.level.setText(""+layer.getLevel());
        holder.rate.setText(String.valueOf(layer.getOutcome()));
        holder.buyButton.setText(String.valueOf(layer.getPrice()));
        holder.buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Game game = Game.getInstance();
                double layerPrice = Math.floor(layer.getBasePrice()*Math.pow(1.15f,layer.getLevel()-1));
                if(game.getMoney()>=layerPrice){
                    game.spend(layerPrice);
                    layer.increaseLevel();
                    notifyDataSetChanged();
                }
            }
        });
        holder.buyButton.setText("UPGRADE: "+Math.floor(layer.getBasePrice()*Math.pow(1.15f,layer.getLevel()-1)));
        holder.progressBar.setMax((int)layer.getProductionTime());
        holder.progressBar.setProgress(1000);
    }

    @Override
    public int getItemCount() {
        return layers.size();
    }
}
