package xyz.wit543.wit.tumboon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import xyz.wit543.wit.tumboon.R;
import xyz.wit543.wit.tumboon.model.Upgrade;

/**
 * Created by Momo on 27/5/2559.
 */
public class UpgradeAdapter extends ArrayAdapter<Upgrade>{
    private List<Upgrade> objects;

    public UpgradeAdapter(Context context, int resource, List<Upgrade> objects){
        super(context,resource,objects);
        this.objects = objects;
    }

    public View getView(final int position,View convertView,ViewGroup parent){
        View v = convertView;
        if(v== null){
            LayoutInflater vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.upgrade_cell,null);
        }
        TextView nameView = (TextView) v.findViewById(R.id.upgrade_name);
        TextView statView = (TextView) v.findViewById(R.id.upgrade_stat);
        Button upgradeBt = (Button) v.findViewById(R.id.upgrade_bt);
        upgradeBt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        Upgrade upList = getItem(position);
        nameView.setText(upList.getName());
        statView.setText(""+upList.getMultiplier());
        //upgradeBt.setText();
        return null;
    }

}
