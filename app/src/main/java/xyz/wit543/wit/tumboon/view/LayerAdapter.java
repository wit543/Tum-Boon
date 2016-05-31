package xyz.wit543.wit.tumboon.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import xyz.wit543.wit.tumboon.R;
import xyz.wit543.wit.tumboon.model.Game;
import xyz.wit543.wit.tumboon.model.Layer;

/**
 * Created by Asus on 5/26/2016.
 */
public class LayerAdapter extends ArrayAdapter<Layer> {
    public LayerAdapter(Context context, int resource, List<Layer> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v==null) {
            LayoutInflater vl = LayoutInflater.from(getContext());
            v = vl.inflate(R.layout.layer_cell, null);
        }
//        TextView layerName = (TextView) v.findViewById(R.id.layer_name);
//        TextView layerLv = (TextView) v.findViewById(R.id.layer_lv);
//        Button button = (Button) v.findViewById(R.id.upgrade_button);
//
//        final Layer layer = getItem(position);
//        layerName.setText(layer.getName());
//        layerLv.setText("LV: "+layer.getLevel());
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Game game = Game.getInstance();
//                double layerPrice = Math.floor(layer.getBasePrice()*Math.pow(1.15f,layer.getLevel()-1));
//                if(game.getMoney()>=layerPrice){
//                    game.spend(layerPrice);
//                    layer.increaseLevel();
//                    notifyDataSetChanged();
//                }
//            }
//        });
//        button.setText("UPGRADE: "+Math.floor(layer.getBasePrice()*Math.pow(1.15f,layer.getLevel()-1)));
        return v;
    }
}
