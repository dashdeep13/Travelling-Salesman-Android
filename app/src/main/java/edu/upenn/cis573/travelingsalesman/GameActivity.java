package edu.upenn.cis573.travelingsalesman;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class GameActivity extends android.support.v7.app.ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.play_game);
        // Sending the value of numLocations to GameView
        GameView gv = (GameView)findViewById(R.id.gameView);
        Intent currentIntent = getIntent();
        int numLocations = currentIntent.getIntExtra("numLocations",0);
        gv.setNumLocations(numLocations);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.game_menu, menu);
        return true;
    }

    /*
    This method is called when the user chooses something in the menu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_clear) {
            GameView gv = (GameView)findViewById(R.id.gameView);
            gv.segments.clear();
            gv.invalidate();
            return true;
        }
        else if (id == R.id.menu_quit) {
            finish();
            return true;
        } else if (id == R.id.menu_undo) {
            GameView gv = (GameView)findViewById(R.id.gameView);
            if (gv.segments.size() > 0) {
                gv.segments.remove(gv.segments.get(gv.segments.size() - 1));
            } else {
                Toast.makeText(gv.getContext(), "There's nothing to undo.", Toast.LENGTH_LONG).show();
            }
            gv.invalidate();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
