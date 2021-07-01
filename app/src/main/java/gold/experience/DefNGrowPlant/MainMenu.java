package gold.experience.DefNGrowPlant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainMenu extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        MediaPlayer music = MediaPlayer.create(this, R.raw.main_ost);
        music.setLooping(true);
        music.start();

        FirebaseApp.initializeApp(this);
        firebaseAuth = firebaseAuth.getInstance();

        firebaseAuth.signInAnonymously().addOnCompleteListener(task -> {
           if (task.isSuccessful()){
               FirebaseUser user = firebaseAuth.getCurrentUser();
           }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
    }

    public void toChooseEnemy(View view) {
        Intent activity_transition1 = new Intent(MainMenu.this, ChooseEnemy.class);
        startActivity(activity_transition1);
    }

    public void toChoosePlant(View view) {
        Intent activity_transition2 = new Intent(MainMenu.this, ChoosePlant.class);
        startActivity(activity_transition2);
    }
}