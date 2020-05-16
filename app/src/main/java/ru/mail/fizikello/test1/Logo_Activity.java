package ru.mail.fizikello.test1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class Logo_Activity extends Activity {
    private Animation logoAnim, buttonLogoAnim;
    private Button bAnim;
    private ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_activity);
        init();

    }
    private void init(){
        // Загружаем анимации в переменные
        logoAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo_anim);
        buttonLogoAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_anim);


        logoImage = findViewById(R.id.logoView) ;
        bAnim = findViewById(R.id.buttonAnim);
        //Запускаем анимацию
        logoImage.startAnimation(logoAnim);
        bAnim.startAnimation(buttonLogoAnim);

    }

    public void onClickStart(View view) {
        Intent i = new Intent(Logo_Activity.this,MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
