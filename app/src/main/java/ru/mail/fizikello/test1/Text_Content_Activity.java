package ru.mail.fizikello.test1;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Подключаем наш экран
        setContentView(R.layout.text_content);
        reciveIntent();
    }

    private void reciveIntent()
    {
        Intent i = getIntent();

    }
}
