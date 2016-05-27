package xyz.wit543.wit.tumboon.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import xyz.wit543.wit.tumboon.R;
import xyz.wit543.wit.tumboon.adapter.UpgradeAdapter;
import xyz.wit543.wit.tumboon.model.Upgrade;

/**
 * Created by Momo on 27/5/2559.
 */
public class UpgradeActivity extends AppCompatActivity {

    private List<Upgrade> upgradeList;

    private ListView upgradeRecyclerView;
    private UpgradeAdapter upgradeAdapter;

    protected  void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_upgrade);
        initComponents();
    }

    private void initComponents(){
        upgradeList = new ArrayList<Upgrade>();
        upgradeList.add(new Upgrade("food",10,false));
        upgradeList.add(new Upgrade("water",10,false));
        upgradeList.add(new Upgrade("house",10,false));

        upgradeAdapter = new UpgradeAdapter(this,R.layout.upgrade_cell,upgradeList);
        upgradeRecyclerView = (ListView)findViewById(R.id.upgrade_list);
        upgradeRecyclerView.setAdapter(upgradeAdapter);


    }

    protected void onStart(){
        super.onStart();
        upgradeAdapter.notifyDataSetChanged();

    }


}
