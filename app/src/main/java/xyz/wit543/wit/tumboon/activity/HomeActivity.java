package xyz.wit543.wit.tumboon.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Observer;

import xyz.wit543.wit.tumboon.R;
import xyz.wit543.wit.tumboon.adapter.ViewPagerAdapter;
import xyz.wit543.wit.tumboon.fragment.LayerFragment;
import xyz.wit543.wit.tumboon.fragment.TopUpFragment;
import xyz.wit543.wit.tumboon.fragment.UpgradeFragment;
import xyz.wit543.wit.tumboon.model.Game;
import xyz.wit543.wit.tumboon.view.LayerAdapter;

public class HomeActivity extends AppCompatActivity implements  LayerFragment.OnFragmentInteractionListener
,TopUpFragment.OnFragmentInteractionListener , UpgradeFragment.OnFragmentInteractionListener {

    private TextView boonLabel;
    private ListView layerList;
    private Game game;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private LayerFragment layerFragment;
    private UpgradeFragment upgradeFragment;
    private TopUpFragment topUpFragment;

    private GoogleApiClient client;
    private ImageButton layerFragmentButton;
    private ImageButton topUpFragmentButton;
    private ImageButton upgradeFragmentButton;
    private ImageButton mutiplierFragmentButton;
    private ImageButton convertFragmentButton;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.initialize();
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(20);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                boonLabel.setText("" + game.getMoney());
                                topUpFragment.update();
                                game.update();
                            }
                        });
                    }

                } catch (InterruptedException e) {
                }
            }
        };

        t.start();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void initialize() {
        boonLabel = (TextView) findViewById(R.id.boon);
        //layerList = (ListView) findViewById(R.id.layerLists);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        game = Game.getInstance();
        //layerList.setAdapter(new LayerAdapter(this, R.layout.layer_cell, game.getLayers()));
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        layerFragment = new LayerFragment();
        upgradeFragment = new UpgradeFragment();
        topUpFragment = new TopUpFragment();

        viewPagerAdapter.addFragment(layerFragment);
        viewPagerAdapter.addFragment(upgradeFragment);
        viewPagerAdapter.addFragment(topUpFragment);
        //TODO add all fragment
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        layerFragmentButton = (ImageButton)findViewById(R.id.layer_menu_button);
        layerFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });

        upgradeFragmentButton = (ImageButton) findViewById(R.id.upgrade_menu_button);
        upgradeFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        convertFragmentButton = (ImageButton) findViewById(R.id.convert_menu_button);
        convertFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(2);
            }
        });
        //TODO set all button
        game.startGame();

    }

    @Override
    public void onStart() {
        super.onStart();

//        client.connect();
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "Home Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app URL is correct.
//                Uri.parse("android-app://xyz.wit543.wit.tumboon.activity/http/host/path")
//        );
////        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Home Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://xyz.wit543.wit.tumboon.activity/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
