package ru.mail.fizikello.test1;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Запуск основного экрана
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.fish_array);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(array)));
        list.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if(id == R.id.id_fish)
        {
            //Очистка и Перезаполнение списка
            array = getResources().getStringArray(R.array.fish_array);
            adapter.clear();
            adapter.addAll(array);
            //Передаем адаптару уведомления что есть изменения
            adapter.notifyDataSetChanged();
            //Выводим подсказку что нажата кнопка Рыба
            Toast.makeText(this, "Рыба", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.id_na)
        {
            array = getResources().getStringArray(R.array.na_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Наживка", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.id_sna)
        {
            array = getResources().getStringArray(R.array.sna_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Снасти", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.id_pri)
        {
            array = getResources().getStringArray(R.array.pri_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Прикормка", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.id_history)
        {
            array = getResources().getStringArray(R.array.hitory_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Истории", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.id_advice)
        {
            array = getResources().getStringArray(R.array.advice_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Советы", Toast.LENGTH_SHORT).show();
        }
        //Закрывает меню при любом нажатии на основные кнопки
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
