package gold.experience.DefNGrowPlant;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class PlantWatermelon extends AppCompatActivity {

    RelativeLayout backWatermelon;
    Button actionWatermelon;
    private int countClickBtn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plant_watermelon);

        backWatermelon = findViewById(R.id.backWatermelon);
        actionWatermelon =  findViewById(R.id.watermelonAction);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void watermelonAction(View view) {
        countClickBtn++;
        if(countClickBtn == 1){
            actionWatermelon.setEnabled(false);
            backWatermelon.setBackground(getDrawable(R.drawable.watermelon_seed_1));
            new CountDownTimer(500,1000){
                @Override
                public void onTick(long millisUntilFinished) { }

                @Override
                public void onFinish() {
                    actionWatermelon.setEnabled(true);
                    backWatermelon.setBackground(getDrawable(R.drawable.watermelon_seed_2));
                    actionWatermelon.setText("поливать арбуз");
                }
            }.start();
        }
        else if(countClickBtn == 2){

            animation(backWatermelon, backWatermelon, backWatermelon, R.drawable.watermelon_seed_34, R.drawable.watermelon_seed_34, R.drawable.watermelon_seed_5);
            new CountDownTimer(1000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }
                @Override
                public void onFinish() {
                    actionWatermelon.setEnabled(true);
                    actionWatermelon.setText("дождаться созревания");
                }
            }.start();

        }
        else if ( countClickBtn == 3){
            actionWatermelon.setEnabled(false);
            animation(backWatermelon, backWatermelon, backWatermelon, R.drawable.watermelon_seed_67, R.drawable.watermelon_seed_67, R.drawable.watermelon_seed_8);

            new CountDownTimer(1000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }
                @Override
                public void onFinish() {
                    actionWatermelon.setEnabled(true);
                    actionWatermelon.setText("Хотите начать заново?");
                }
            }.start();
        }
        else{
            countClickBtn = 0;
            actionWatermelon.setText("посадить арбуз");
            backWatermelon.setBackground(getDrawable(R.drawable.plain));
        }
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    public void animation(RelativeLayout first, RelativeLayout second, RelativeLayout thirsd, int res, int res2, int res3) {
            first.setBackground(getDrawable(res));
            final AnimationDrawable[] animation = {(AnimationDrawable) first.getBackground()};
            animation[0].start();

            new CountDownTimer(450, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }
                @Override
                public void onFinish() {
                    animation[0].stop();
                    second.setBackground(getDrawable(res2));
                    animation[0] = (AnimationDrawable) second.getBackground();
                    animation[0].start();
                    new CountDownTimer(450, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                        }

                        @Override
                        public void onFinish() {
                            animation[0].stop();
                            thirsd.setBackground(getDrawable(res3));
                        }
                    }.start();
                }
            }.start();
        }
}
