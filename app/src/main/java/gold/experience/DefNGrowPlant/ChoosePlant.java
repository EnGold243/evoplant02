package gold.experience.DefNGrowPlant;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChoosePlant extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_plant);

        Button AppleScreen = findViewById(R.id.btnApple);
        Button PineappleScreen = findViewById(R.id.btnPineapple);
        Button Watermelon = findViewById(R.id.btnWatermelon);

        AppleScreen.setOnClickListener(OnClick);
        PineappleScreen.setOnClickListener(OnClick);
        Watermelon.setOnClickListener(OnClick);
    }

    View.OnClickListener OnClick = new View.OnClickListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnApple:
                    Intent apple = new Intent(ChoosePlant.this, PlantApple.class);
                    startActivity(apple);
                    break;
                case R.id.btnPineapple:
                    Intent pineapple = new Intent(ChoosePlant.this, PlantPineapple.class);
                    startActivity(pineapple);
                    break;
                case R.id.btnWatermelon:
                    Intent watermelon = new Intent(ChoosePlant.this, PlantWatermelon.class);
                    startActivity(watermelon);
                    break;
            }
        }
    };
}
