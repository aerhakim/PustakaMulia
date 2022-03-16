package id.co.pustakamulia.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.pustakamulia.R;

public class SplashScreenActivity extends AppCompatActivity {

    private static int SPLASH_TIMER = 2000; //2000 sama dengan 2 detik
    ImageView icon;
    TextView nama;
    Animation sideAnim, bottomAnim;
    MediaPlayer mySong;
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash_screen);
        icon = findViewById(R.id.iv_icon);
        nama = findViewById(R.id.tv_nama);
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        icon.setAnimation(sideAnim);
        nama.setAnimation(bottomAnim);
        MediaPlayer create = MediaPlayer.create(getBaseContext(), R.raw.efek);
        this.mySong = create;
        create.start();
        new Handler().postDelayed(() -> {
            onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
            boolean isFirstTime = onBoardingScreen.getBoolean("firstTime", true);
            if (isFirstTime) {
                SharedPreferences.Editor editor = onBoardingScreen.edit();
                editor.putBoolean("firstTime", false);
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
            finish();
        }, SPLASH_TIMER);

    }
}