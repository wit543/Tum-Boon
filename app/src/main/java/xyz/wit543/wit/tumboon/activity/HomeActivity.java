package xyz.wit543.wit.tumboon.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import xyz.wit543.wit.tumboon.R;
import xyz.wit543.wit.tumboon.model.Game;

public class HomeActivity extends AppCompatActivity {

    TextView boonLabel;
    Game game;

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
                                boonLabel.setText(""+game.getMoney());
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();

    }

    private void initialize(){
        boonLabel = (TextView)findViewById(R.id.boon);
        game = new Game();
        game.startGame();
    }

}
