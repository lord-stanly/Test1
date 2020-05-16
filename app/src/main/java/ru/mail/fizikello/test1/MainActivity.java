package ru.mail.fizikello.test1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
private DrawerLayout drawer;
private ListView list;
private String[] array;
private ArrayAdapter<String> adapter;
private Toolbar toolbar;
private int category_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Запуск основного экрана
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.fish_array);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(array)));
        list.setAdapter(adapter);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //Добовляем сшушателя нажатия для контента
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(MainActivity.this,Text_Content_Activity.class);
                intent.putExtra("category", category_index);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setTitle(R.string.fish);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if(id == R.id.id_fish)
        {
            fillArray(R.string.fish, R.array.fish_array, 0, "Рыба");
        }
        else if(id == R.id.id_na)
        {
            fillArray(R.string.na, R.array.na_array, 1, "Наживка" );
        }
        else if(id == R.id.id_sna)
        {
            fillArray(R.string.sna, R.array.sna_array, 2, "Снасти" );
        }
        else if(id == R.id.id_pri)
        {
            fillArray(R.string.pri, R.array.pri_array, 3, "Прикормка" );
        }
        else if(id == R.id.id_history)
        {
            fillArray(R.string.history, R.array.hitory_array, 4, "Истории" );
        }
        else if(id == R.id.id_advice)
        {
            fillArray(R.string.advice, R.array.advice_array, 5, "Советы" );
        }
        //Закрывает меню при любом нажатии на основные кнопки
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //оптимизирую код
    private void fillArray(int title, int arrayList, int index, String textToast)
    {
        //меняем заголовок на Тему из списка
        toolbar.setTitle(title);
        //Очистка и Перезаполнение списка
        array = getResources().getStringArray(arrayList);
        adapter.clear();
        adapter.addAll(array);
        //Передаем адаптару уведомления что есть изменения
        adapter.notifyDataSetChanged();
        //Выводим подсказку нажата кнопка Рыба
        Toast.makeText(this, textToast, Toast.LENGTH_SHORT).show();
        //Индекс при нажатии кнопки
        category_index = index;
    }
}
