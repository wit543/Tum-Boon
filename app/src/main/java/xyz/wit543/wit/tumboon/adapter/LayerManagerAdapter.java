package xyz.wit543.wit.tumboon.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import xyz.wit543.wit.tumboon.R;
import xyz.wit543.wit.tumboon.model.Game;
import xyz.wit543.wit.tumboon.model.LayerManager;
import xyz.wit543.wit.tumboon.model.util.BoonUnitTranformer;

/**
 * Created by Asus on 5/28/2016.
 */
public class LayerManagerAdapter extends RecyclerView.Adapter<LayerManagerAdapter.LayerManagerRecycleViewHolder> {
    private List<LayerManager> layers;
    public static class LayerManagerRecycleViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView level;
        TextView rate;
        ProgressBar progressBar;
        Button buyButton;
//        SurfaceView animationView;
        ImageView animationView;
        public LayerManagerRecycleViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.layer_name);
            level=(TextView)itemView.findViewById(R.id.layer_lv);
            rate=(TextView)itemView.findViewById(R.id.layer_rate);
            progressBar=(ProgressBar)itemView.findViewById(R.id.production_progress_bar);
            buyButton=(Button)itemView.findViewById(R.id.upgrade_button);
            //animationView=(SurfaceView)itemView.findViewById(R.id.layer_animation);
            animationView=(ImageView)itemView.findViewById(R.id.layer_animation);

        }
    }

    public LayerManagerAdapter(List<LayerManager> layers) {
        this.layers = layers;
    }

    @Override
    public LayerManagerRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layer_cell, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new LayerManagerRecycleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LayerManagerRecycleViewHolder holder, int position) {
        final LayerManager layer = layers.get(position);
        final Game game = Game.getInstance();

        holder.name.setText(""+layer.getLayer().getName());
        holder.level.setText(""+layer.getLevel());
        holder.rate.setText(String.valueOf(layer.getProductOutcome()));
        holder.buyButton.setText(BoonUnitTranformer.getReadableValue(layer.getPrice()));
        holder.buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(game.getMoney()>=layer.getPrice()){
                    game.spend(layer.getPrice());
                    layer.increaseLevel();
                    notifyDataSetChanged();
                }
            }
        });

        Integer image = layer.getLayer().getLayerPic();
        if(image!=0)
            holder.animationView.setImageResource(layer.getLayer().getLayerPic());
        else
            holder.animationView.setImageResource(R.drawable.car_layer);

        if(layer.getLevel()>0) {
            final ProgressBar progressBar = holder.progressBar;
            final Button buyButton = holder.buyButton;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (layer.getProductionTime() > 100) {
                        try {
                            Thread.sleep(10);



                            progressBar.setProgress(calculateProcess(layer));

//                            if(!(game.getMoney()>=layer.getPrice())){
//                                buyButton.setText("CAN'T BUY");
//                            }else{
//                                buyButton.setText("UPGRADE: "+layer.getPrice());
//                            }

                        } catch (Exception e) {

                        }
                    }
                    progressBar.setProgress(100);
                }
            });
            t.start();
        }
    }

    @Override
    public int getItemCount() {
        return layers.size();
    }

    public synchronized int calculateProcess(LayerManager layer){
        int remaining = (int)(layer.getNextProduceTime() - System.currentTimeMillis());
        double duration = layer.getProductionTime().intValue();
        return (int)((duration-remaining)/duration * 100);
    }


}
