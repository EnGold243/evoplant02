package gold.experience.DefNGrowPlant;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EnemyTlya extends AppCompatActivity {

    private Dialog manual;
    private Button hint, tlyaAction;
    private RelativeLayout backTlya;
    private int countClickBtn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enemy_tlya);

        manual = new Dialog(EnemyTlya.this);
        manual.setContentView(R.layout.manual);

        TextView title = manual.findViewById(R.id.title);
        TextView text = (TextView) manual.findViewById(R.id.text);

        title.setText("ВЫРАЩИВВАНИЕ ЯБЛОНИ");
        text.setText(R.string.manual_tlya);

        hint = findViewById(R.id.hintTlya);
        tlyaAction = findViewById(R.id.actionTlya);
        backTlya = findViewById(R.id.backTlya);

        hint.setOnClickListener(OnClick);
        tlyaAction.setOnClickListener(OnClick);
        backTlya.setOnClickListener(OnClick);

    }

    View.OnClickListener OnClick =  new View.OnClickListener() {
        @SuppressLint("UseCompatLoadingForDrawables")
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.hintTlya:
                    manual.show();
                    break;
                case R.id.actionTlya:
                    countClickBtn++;
                    if(countClickBtn == 1){
                        backTlya.setBackground(getDrawable(R.drawable.tlya_defens_2));
                        tlyaAction.setText("залить его в опрыскиватель");
                    }
                    else if (countClickBtn == 2){
                        backTlya.setBackground(getDrawable(R.drawable.tlya_defens_3));
                                tlyaAction.setText("использовать");
                    }
                    else if (countClickBtn == 3){
                        tlyaAction.setEnabled(false);
                        animation(backTlya, backTlya, backTlya, R.drawable.tlya_defens_45, R.drawable.tlya_defens_45, R.drawable.tlya_defens_3);
                        new CountDownTimer(500,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) { }
                            @Override
                            public void onFinish() {
                                tlyaAction.setText("другая сторона");
                                tlyaAction.setEnabled(false);
                            }
                        }.start();
                    }
                    else if (countClickBtn == 4){
                        tlyaAction.setEnabled(false);
                        animation(backTlya, backTlya, backTlya, R.drawable.tlya_defens_67, R.drawable.tlya_defens_67, R.drawable.background3);
                        new CountDownTimer(500,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) { }
                            @Override
                            public void onFinish() {
                                tlyaAction.setText("Хотите начать заново?");
                                tlyaAction.setEnabled(false);
                            }
                        }.start();
                    }
                    else{
                        countClickBtn = 0;
                        backTlya.setBackground(getDrawable(R.drawable.tlya_defens_1));
                        tlyaAction.setText("взять мыло и растворить его");
                    }
                    break;
            }
        }
    };
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
