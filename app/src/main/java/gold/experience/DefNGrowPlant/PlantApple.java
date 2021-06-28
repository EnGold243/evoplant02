package gold.experience.DefNGrowPlant;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlantApple extends AppCompatActivity {

    private RelativeLayout back;
    private Button action;
    private int vip = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plant_apple);

        action = findViewById(R.id.action);
        back = findViewById(R.id.back);

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void Action(View view) {
        vip++;
        if (vip == 1) {
            back.setBackground(getDrawable(R.drawable.apple_seedling));
            action.setText("выровнить саженец");
        } else if (vip == 2) {
            back.setBackground(getDrawable(R.drawable.apple_seedling_2));
            action.setText("взять удобрение");
        } else if (vip == 3) {
            back.setBackground(getDrawable(R.drawable.apple_seedling_3));
            action.setText("использовать удобрение");
        } else if (vip == 4) {
            back.setBackground(getDrawable(R.drawable.apple_seedling_4));
            action.setText("ждать");
        } else if (vip == 5) {
            action.setEnabled(false);
            animation(back, back, back, R.drawable.apple_seedling_67, R.drawable.apple_seedling_67, R.drawable.apple_seedling_5);
            new CountDownTimer(1950, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {
                    action.setEnabled(true);
                    back.setBackground(getDrawable(R.drawable.apple_seedling_8));
                    action.setText("Хотите начать заново?");
                }
            }.start();
        } else {
            vip = 0;
            action.setText("посадить сажанец");
            back.setBackground(getDrawable(R.drawable.plain));
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public void animation(RelativeLayout first, RelativeLayout second, RelativeLayout thirsd, int res, int res2, int res3) {
        if (first != second && second != thirsd) {
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
                    first.setBackground(null);
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
                            second.setBackground(null);
                            thirsd.setBackground(getDrawable(res3));
                            new CountDownTimer(1000, 1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                }

                                @Override
                                public void onFinish() {
                                    thirsd.setBackground(null);
                                }
                            }.start();
                        }
                    }.start();
                }
            }.start();
        } else {
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
                            new CountDownTimer(1000, 1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                }

                                @Override
                                public void onFinish() {
                                    thirsd.setBackground(null);
                                }
                            }.start();
                        }
                    }.start();
                }
            }.start();
        }
    }
}
