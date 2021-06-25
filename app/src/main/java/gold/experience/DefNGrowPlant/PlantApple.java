package gold.experience.DefNGrowPlant;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlantApple extends AppCompatActivity {

    private Dialog manual;
    private RelativeLayout back;
    private Button hint, action;
    private int vip = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plant_apple);

        manual = new Dialog(PlantApple.this);
        manual.setContentView(R.layout.manual);

        TextView title = manual.findViewById(R.id.title);
        TextView text = (TextView) manual.findViewById(R.id.text);

        title.setText("ВЫРАЩИВВАНИЕ ЯБЛОНИ");
        text.setText(R.string.manual_apple);

        hint = findViewById(R.id.hint);
        action = findViewById(R.id.action);
        back = findViewById(R.id.back);

        hint.setOnClickListener(OnClick);
    }

    View.OnClickListener OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.hint:
                    manual.show();
                    break;
            }
        }
    };

    public void Action(View view) {
        vip++;
        if(vip == 1){
            back.setBackground(getDrawable(R.drawable.apple_seedling));
            action.setText("выровнить сажениц");
        }
        else if(vip == 2){
            back.setBackground(getDrawable(R.drawable.apple_seedling_2));
            action.setText("lol");
        }
        else {
            vip = 0;
        }
    }

    public void bb(View view) {
        manual.show();
    }
}
