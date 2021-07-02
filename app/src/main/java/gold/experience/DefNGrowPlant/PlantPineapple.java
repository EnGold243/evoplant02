package gold.experience.DefNGrowPlant;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class PlantPineapple extends AppCompatActivity {

    private RelativeLayout backPineapple;
    Button actionPineapple;
    private int countClickBtn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plant_pineapple);
        backPineapple = findViewById(R.id.backpineapple);
        actionPineapple = findViewById(R.id.actionPineapple);

    }

    public void pineappleAction(View view) {
        countClickBtn++;
        if(countClickBtn == 1){
            backPineapple.setBackground(getDrawable(R.drawable.pineapple_seed_2));
            actionPineapple.setEnabled(false);
            new CountDownTimer(500, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }
                @Override
                public void onFinish() {
                    backPineapple.setBackground(getDrawable(R.drawable.pineapple_seed_3));
                    actionPineapple.setText("дождаться корней и взять горшок");
                    actionPineapple.setEnabled(true);
                }
            }.start();
        }
        else if(countClickBtn == 2){
            backPineapple.setBackground(getDrawable(R.drawable.pineapple_seed_4));
            actionPineapple.setText("ждать");
        }
        else if(countClickBtn == 3){
            animation(backPineapple, backPineapple, backPineapple,R.drawable.pineapple_seed_56,R.drawable.pineapple_seed_56,R.drawable.pineapple_seed_7);
            new CountDownTimer(1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) { }

                @Override
                public void onFinish() {
                    animation(backPineapple, backPineapple, backPineapple,R.drawable.pineapple_seed_78,R.drawable.pineapple_seed_78,R.drawable.pineapple_seed_9);
                            actionPineapple.setText("Хотите начать заноно?");
                }
            }.start();
        }
        else{
            countClickBtn = 0;
            backPineapple.setBackground(getDrawable(R.drawable.pineapple_seed_1));
            actionPineapple.setText("посадить корень в воду");
        }
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    public void animation(RelativeLayout first, RelativeLayout second, RelativeLayout thirsd, int res, int res2, int res3) {
        first.setBackground(getDrawable(res));
        final AnimationDrawable[] animation = {(AnimationDrawable) first.getBackground()};
        animation[0].start();

        new CountDownTimer(450, 1000){
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
