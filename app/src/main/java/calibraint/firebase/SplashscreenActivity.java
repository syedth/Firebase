package calibraint.firebase;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class SplashscreenActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        int SPLASH_TIME_OUT = 3000;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                firebaseAuth = FirebaseAuth.getInstance();
                if (firebaseAuth.getCurrentUser() != null) {
                    Intent i = new Intent(SplashscreenActivity.this, HomeActivity.class);
                    startActivity(i);
                }else {
                    Intent i = new Intent(SplashscreenActivity.this, MainActivity.class);
                    startActivity(i);
                }
                finish();

            }
        },SPLASH_TIME_OUT);
    }
}
