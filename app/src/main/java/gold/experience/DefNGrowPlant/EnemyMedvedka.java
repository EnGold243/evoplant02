package gold.experience.DefNGrowPlant;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EnemyMedvedka extends AppCompatActivity {

    private Dialog manual;
    Button hint, btnAnimation, btnAnimation2;
    ImageView frame1, frame2, frame3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enemy_medvedka);

        manual = new Dialog(EnemyMedvedka.this);
        manual.setContentView(R.layout.manual);

        TextView title = manual.findViewById(R.id.title);
        TextView text = (TextView) manual.findViewById(R.id.text);

        title.setText("КАК УБРАТЬ МЕДВЕДКУ");
        text.setText(R.string.manual_medvedka);

        hint = findViewById(R.id.hint);
        btnAnimation = findViewById(R.id.Animation);

        frame1 = findViewById(R.id.imageView);
        frame2 = findViewById(R.id.imageView2);
        frame3 = findViewById(R.id.imageView3);

        hint.setOnClickListener(OnClick);
        btnAnimation.setOnClickListener(OnClick);
    }

    View.OnClickListener OnClick = new View.OnClickListener() {
        @SuppressLint("UseCompatLoadingForDrawables")
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.hint:
                    manual.show();
                    break;
                case R.id.Animation:
                    btnAnimation.setEnabled(false);
                    frame3.setBackground(getResources().getDrawable(R.drawable.bait_frame_0));
                    animation(frame1, frame2, frame3, R.drawable.madvedka_walk, R.drawable.madvedka_walk, R.drawable.bait_frame_1);
                    new CountDownTimer(1000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) { }
                        @Override
                        public void onFinish() {
                            animation(frame3, frame3, frame3, R.drawable.bait_medvedka, R.drawable.bait_fire, R.drawable.bait_end);
                            btnAnimation.setEnabled(true);
                        }
                    }.start();
                    break;
            }
        }
    };

    @SuppressLint("UseCompatLoadingForDrawables")
    public void animation(ImageView first, ImageView second, ImageView thirsd, int res, int res2, int res3) {
        if(first != second && second != thirsd){
        first.setBackground(getDrawable(res));
        final AnimationDrawable[] animation = {(AnimationDrawable) first.getBackground()};
        animation[0].start();

        new CountDownTimer(450, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {}

            @Override
            public void onFinish() {
                animation[0].stop();
                first.setBackground(null);
                second.setBackground(getDrawable(res2));
                animation[0] = (AnimationDrawable) second.getBackground();
                animation[0].start();
                new CountDownTimer(450, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {}

                    @Override
                    public void onFinish() {
                        animation[0].stop();
                        second.setBackground(null);
                        thirsd.setBackground(getDrawable(res3));
                        new CountDownTimer(1000, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {}
                            @Override
                            public void onFinish() {
                                thirsd.setBackground(null);
                            }
                        }.start();
                    }
                }.start();
            }
        }.start(); }
        else {
            first.setBackground(getDrawable(res));
            final AnimationDrawable[] animation = {(AnimationDrawable) first.getBackground()};
            animation[0].start();

            new CountDownTimer(450, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {}

                @Override
                public void onFinish() {
                    animation[0].stop();
                    second.setBackground(getDrawable(res2));
                    animation[0] = (AnimationDrawable) second.getBackground();
                    animation[0].start();
                    new CountDownTimer(450, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {}

                        @Override
                        public void onFinish() {
                            animation[0].stop();
                            thirsd.setBackground(getDrawable(res3));
                            new CountDownTimer(1000, 1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {}
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
