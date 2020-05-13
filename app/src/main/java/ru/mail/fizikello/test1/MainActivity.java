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
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,array);
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
        if(id == R.id.nav_home)
        {
            Toast.makeText(this, "вы нажали nav_home", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.nav_gallery)
        {
            Toast.makeText(this, "вы нажали nav_gallery", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.nav_slideshow)
        {
            Toast.makeText(this, "вы нажали nav_slideshow", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.nav_tools)
        {
            Toast.makeText(this, "вы нажали nav_tools", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.nav_shape)
        {
            Toast.makeText(this, "вы нажали nav_shape", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.nav_send)
        {
            Toast.makeText(this, "вы нажали nav_send", Toast.LENGTH_SHORT).show();
        }
        //Закрывает меню при любом нажатии на основные кнопки
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
