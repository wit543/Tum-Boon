package xyz.wit543.wit.tumboon.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import xyz.wit543.wit.tumboon.R;
import xyz.wit543.wit.tumboon.model.Game;
import xyz.wit543.wit.tumboon.model.Upgrade;
import xyz.wit543.wit.tumboon.model.util.BoonUnitTranformer;

/**
 * Created by Momo on 27/5/2559.
 */
public class UpgradeAdapter extends RecyclerView.Adapter<UpgradeAdapter.UpgradeRecycleViewHolder> {
    private List<Upgrade> upgrades;

    public static class UpgradeRecycleViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView stat;
        Button upgradeButton;

        public UpgradeRecycleViewHolder(View itemView){
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.upgrade_name);
            stat = (TextView) itemView.findViewById(R.id.upgrade_stat);
            upgradeButton = (Button)itemView.findViewById(R.id.upgrade_bt);
        }
    }
    public UpgradeAdapter(List<Upgrade> upgrades){
        this.upgrades = upgrades;
    }
    @Override
    public UpgradeRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.upgrade_cell, parent, false);

        return new UpgradeRecycleViewHolder(v);
    }
    public void onBindViewHolder(UpgradeRecycleViewHolder holder,int position){
        final Upgrade upgrade = upgrades.get(position);
        final Game game = Game.getInstance();

        holder.name.setText(""+upgrade.getUpName());
        holder.stat.setText(""+upgrade.getMultiplier());
        holder.upgradeButton.setText(String.valueOf(upgrades.get(position).getprice()));
        holder.upgradeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(game.getMoney()>=upgrade.getprice()){
                    game.spend(upgrade.getprice());
                    upgrade.upPrice();
                    System.out.println("");
                    notifyDataSetChanged();
                }
            }
        });
        holder.stat.setText(""+upgrade.getMultiplier()+"%");
        holder.upgradeButton.setText(BoonUnitTranformer.getReadableValue(upgrade.getprice()));
    }

    public int getItemCount() {
        return upgrades.size();
    }

}