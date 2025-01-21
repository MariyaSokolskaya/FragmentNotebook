package com.example.fragmentnotebook;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button currentFragmentButton, finalFragmentButton;
    //менеджер фрагментов
    FragmentManager fm;
    //Фрагменты
    CurrentTasksFragment currentTasksFragment;
    FinalTasksFragment finalTasksFragment;
    //контейнер для фрагментов
    FrameLayout fragmentContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentFragmentButton = findViewById(R.id.currentTasks);
        finalFragmentButton = findViewById(R.id.finalTasks);
        fragmentContainer = findViewById(R.id.fragmentContainer);

        //подключение менеджера
        fm = getSupportFragmentManager();
        //создание фрагментов
        currentTasksFragment = new CurrentTasksFragment();
        finalTasksFragment = new FinalTasksFragment();

        FragmentTransaction ft = fm.beginTransaction();
        if(savedInstanceState == null){
            ft.add(R.id.fragmentContainer, currentTasksFragment);
            ft.commit();
        }

        currentFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragmentContainer, currentTasksFragment);
                ft.commit();
                currentFragmentButton.setEnabled(false);
                finalFragmentButton.setEnabled(true);
            }
        });
        finalFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragmentContainer, finalTasksFragment);
                ft.commit();
                finalFragmentButton.setEnabled(false);
                currentFragmentButton.setEnabled(true);
            }
        });
    }
}