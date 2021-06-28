package gold.experience.DefNGrowPlant;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChoosePlant extends AppCompatActivity {

    private Dialog manual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_plant);

        Button AppleScreen = findViewById(R.id.btnApple);
        Button PineappleScreen = findViewById(R.id.btnPineapple);
        Button Watermelon = findViewById(R.id.btnWatermelon);
        Button hintApple = findViewById(R.id.hintApple);
        Button hintPineapple = findViewById(R.id.hintPineapple);
        Button hintWatermelon = findViewById(R.id.hintWatermelon);

        AppleScreen.setOnClickListener(OnClick);
        PineappleScreen.setOnClickListener(OnClick);
        Watermelon.setOnClickListener(OnClick);
        hintApple.setOnClickListener(OnClick);
        hintPineapple.setOnClickListener(OnClick);
        hintWatermelon.setOnClickListener(OnClick);
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
                case R.id.hintApple:
                    manual = new Dialog(ChoosePlant.this);
                    manual.setContentView(R.layout.manual);

                    TextView title = manual.findViewById(R.id.title);
                    TextView text = (TextView) manual.findViewById(R.id.text);

                    title.setText("ВЫРАЩИВВАНИЕ ЯБЛОНИ");
                    text.setText(R.string.manual_apple);
                    manual.show();
                    break;
                case R.id.hintPineapple:

                    manual = new Dialog(ChoosePlant.this);
                    manual.setContentView(R.layout.manual);

                    TextView title2 = manual.findViewById(R.id.title);
                    TextView text2 = (TextView) manual.findViewById(R.id.text);

                    title2.setText("ВЫРАЩИВВАНИЕ АНАНАСА");
                    text2.setText("l2asdfghj");
                    manual.show();
                    break;
                case R.id.hintWatermelon:

                    manual = new Dialog(ChoosePlant.this);
                    manual.setContentView(R.layout.manual);

                    TextView title3 = manual.findViewById(R.id.title);
                    TextView text3 = (TextView) manual.findViewById(R.id.text);

                    title3.setText("ВЫРАЩИВВАНИЕ АРБУЗА");
                    text3.setText("lasdfghjk");
                    manual.show();
                    break;
            }
        }
    };
}
