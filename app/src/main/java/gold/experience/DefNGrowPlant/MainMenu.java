package gold.experience.DefNGrowPlant;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        MediaPlayer music = MediaPlayer.create(this, R.raw.main_ost);
        music.setLooping(true);
        music.start();


    }

    public void toChooseEnemy(View view) {
        Intent activity_transition1 = new Intent(MainMenu.this, ChooseEnemy.class);
        startActivity(activity_transition1);
    }

    public void toChoosePlant(View view) {
        Intent activity_transition2 = new Intent(MainMenu.this, ChoosePlant.class);
        startActivity(activity_transition2);
    }
}