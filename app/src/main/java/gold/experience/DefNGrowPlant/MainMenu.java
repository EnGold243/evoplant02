package gold.experience.DefNGrowPlant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
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