package br.com.etecia.myapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //apresentado o xml para o java
        bottomNavView = findViewById(R.id.bottomNavView);

        //criando evento de clique nos itens de menu
        bottomNavView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.mNews) {
                    Toast.makeText(getApplicationContext(),
                            "Cliquei em News", Toast.LENGTH_SHORT).show();
                }
                if (item.getItemId() == R.id.mGlobal) {
                    Toast.makeText(getApplicationContext(),
                            "Cliquei em Global", Toast.LENGTH_SHORT).show();
                }
                if (item.getItemId() == R.id.mForYou) {
                    Toast.makeText(getApplicationContext(),
                            "Cliquei em For You", Toast.LENGTH_SHORT).show();
                }
                if (item.getItemId() == R.id.mTrending) {
                    Toast.makeText(getApplicationContext(),
                            "Cliquei em Trending", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }
}