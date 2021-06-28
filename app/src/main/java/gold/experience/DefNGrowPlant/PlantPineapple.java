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

    private RelativeLayout back;
    Button action;
    private int vip = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plant_pineapple);
        back = findViewById(R.id.back_pineapple);
        action = findViewById(R.id.action_pineapple);

    }

    public void pineappleAction(View view) {
        vip++;
        if(vip == 1){
            back.setBackground(getDrawable(R.drawable.pineapple_seed_2));
            action.setEnabled(false);
            new CountDownTimer(500, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                }
                @Override
                public void onFinish() {
                    back.setBackground(getDrawable(R.drawable.pineapple_seed_3));
                    action.setText("дождаться корней и взять горшок");
                    action.setEnabled(true);
                }
            }.start();
        }
        else if(vip == 2){
            back.setBackground(getDrawable(R.drawable.pineapple_seed_4));
            action.setText("ждать");
        }
        else if(vip == 3){
            animation(back,back,back,R.drawable.pineapple_seed_56,R.drawable.pineapple_seed_56,R.drawable.pineapple_seed_7);
            new CountDownTimer(1950, 1000) {
                @Override
                public void onTick(long millisUntilFinished) { }

                @Override
                public void onFinish() {
                    animation(back,back,back,R.drawable.pineapple_seed_78,R.drawable.pineapple_seed_78,R.drawable.pineapple_seed_8);
                    new CountDownTimer(1950, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) { }

                        @Override
                        public void onFinish() {
                            back.setBackground(getDrawable(R.drawable.pineapple_seed_9));
                            action.setText("Хотите начать заноно?");
                        }
                    }.start();
                }
            }.start();
        }
        else{
            vip = 0;
            back.setBackground(getDrawable(R.drawable.pineapple_seed_1));
            action.setText("посадить корень в воду");
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
