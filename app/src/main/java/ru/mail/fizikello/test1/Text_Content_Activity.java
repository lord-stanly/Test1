package ru.mail.fizikello.test1;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Text_Content_Activity extends AppCompatActivity {
    private TextView text_content;
    private Typeface face_1;
    private ImageView iContent;
    private int position;
    private int category;
    private int array_fish [] = {R.string.fish_1, R.string.fish_2,R.string.fish_3, R.string.fish_4, R.string.fish_5};
    private int array_na [] = {R.string.na_1, R.string.na_2,R.string.na_3, R.string.na_4, R.string.na_5};
    private int array_image_fish [] = {R.drawable.karp, R.drawable.schuka,R.drawable.som, R.drawable.osetr, R.drawable.nalim};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Подключаем наш экран
        setContentView(R.layout.text_content);
        init();
        reciveIntent();
    }

    private void reciveIntent()
    {
        Intent i = getIntent();
        if(i != null)
        {
            category = i.getIntExtra("category",0);
            position = i.getIntExtra("position",0);
        }
        switch(category){
            case 0:
                iContent.setImageResource(array_image_fish[position]);
                text_content.setText(array_fish[position]);
                break;
            case 1:
                /*iContent.setImageResource(array_image_fish[position]);*/
                text_content.setText(array_na[position]);
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
        }


    }

    private void init(){
        text_content = findViewById(R.id.text_main_content);
        iContent = findViewById(R.id.imageContent);
        //Подгружаем шрифты
        face_1 = Typeface.createFromAsset(this.getAssets(),"fonts/RuslanDisplay-Regular.ttf");
        text_content.setTypeface(face_1);

    }
}
