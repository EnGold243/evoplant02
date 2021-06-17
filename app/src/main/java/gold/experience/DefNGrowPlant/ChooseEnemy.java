package gold.experience.DefNGrowPlant;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseEnemy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_enemy);

        Button btnToEnemyMedvedka = findViewById(R.id.btnMedvedka);
        Button btnToEnemyTlya = findViewById(R.id.btnTlya);
        Button btnStartVideoMedvedka = findViewById(R.id.btnStartMedvedka);
        Button btnStartVideoTlya = findViewById(R.id.btnStartTlya);

        btnToEnemyMedvedka.setOnClickListener(OnClick);
        btnToEnemyTlya.setOnClickListener(OnClick);
        btnStartVideoMedvedka.setOnClickListener(OnClick);
        btnStartVideoTlya.setOnClickListener(OnClick);

    }

    View.OnClickListener OnClick = new View.OnClickListener() {
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnMedvedka:
                    Intent enemy = new Intent(ChooseEnemy.this, EnemyMedvedka.class);
                    startActivity(enemy);
                    break;
                case R.id.btnTlya:
                    Intent enemy2 = new Intent(ChooseEnemy.this, EnemyTlya.class);
                    startActivity(enemy2);
                case R.id.btnStartMedvedka:
                    videoPlayer(R.raw.medvedka);
                    break;
                case R.id.btnStartTlya:
                    videoPlayer(R.raw.tlya);
                    break;
            }
        }
    };

    private void videoPlayer(int content) {
        RelativeLayout dialogLayout = (RelativeLayout) RelativeLayout.inflate(this, R.layout.video, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        AlertDialog dialog = builder.create();
        dialog.setView(dialogLayout);
        dialog.show();
        final VideoView video = (VideoView) dialog.findViewById(R.id.videoView);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + content);
        video.setVideoURI(uri);
        video.start();
    }
}
