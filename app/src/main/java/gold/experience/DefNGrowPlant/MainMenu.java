package gold.experience.DefNGrowPlant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainMenu extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        MediaPlayer music = MediaPlayer.create(this, R.raw.main_ost);
        music.setLooping(true);
        music.start();

        sharedPreferences = getSharedPreferences("LOGIN", MODE_PRIVATE);
        String checkLogin = sharedPreferences.getString("LOGIN", "");

        if(!checkLogin.equals("isLogined")){

        FirebaseApp.initializeApp(this);
        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signInAnonymously()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        FirebaseUser user = firebaseAuth.getCurrentUser();

                        sharedPreferences = getSharedPreferences("LOGIN", MODE_PRIVATE);
                        SharedPreferences.Editor ed = sharedPreferences.edit();
                        ed.putString("LOGIN", "isLogined");
                        ed.apply();
                    }
                });
    }}

    public void toChooseEnemy(View view) {
        Intent activity_transition1 = new Intent(MainMenu.this, ChooseEnemy.class);
        startActivity(activity_transition1);
    }

    public void toChoosePlant(View view) {
        Intent activity_transition2 = new Intent(MainMenu.this, ChoosePlant.class);
        startActivity(activity_transition2);
    }
}