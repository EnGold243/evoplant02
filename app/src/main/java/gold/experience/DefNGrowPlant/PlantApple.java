package gold.experience.DefNGrowPlant;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class PlantApple extends AppCompatActivity {

    private RelativeLayout back;
    private Button action;
    private int countClickBtn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plant_apple);

        action = findViewById(R.id.actionApple);
        back = findViewById(R.id.backApple);

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void Action(View view) {
        countClickBtn++;
        if (countClickBtn == 1) {
            back.setBackground(getDrawable(R.drawable.apple_seedling));
            action.setText("выровнить саженец");
        } else if (countClickBtn == 2) {
            back.setBackground(getDrawable(R.drawable.apple_seedling_2));
            action.setText("взять удобрение");
        } else if (countClickBtn == 3) {
            back.setBackground(getDrawable(R.drawable.apple_seedling_3));
            action.setText("использовать удобрение");
        } else if (countClickBtn == 4) {
            back.setBackground(getDrawable(R.drawable.apple_seedling_4));
            action.setText("ждать");
        } else if (countClickBtn == 5) {
            action.setEnabled(false);
            animation(back, back, back, R.drawable.apple_seedling_67, R.drawable.apple_seedling_67, R.drawable.apple_seedling_8);
                    action.setEnabled(true);
                    action.setText("Хотите начать заново?");

        } else {
            countClickBtn = 0;
            action.setText("посадить сажанец");
            back.setBackground(getDrawable(R.drawable.plain));
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
