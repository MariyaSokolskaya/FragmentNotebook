package com.example.fragmentnotebook;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CurrentTasksFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrentTasksFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CurrentTasksFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CurrentTasksFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CurrentTasksFragment newInstance(String param1, String param2) {
        CurrentTasksFragment fragment = new CurrentTasksFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    EditText newTaskText;
    Button newTaskButton;
    LinearLayout tasksLayout;
    public final String FILENAME = "tasks.txt";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_current_tasks, container, false);
        newTaskText = v.findViewById(R.id.enterTaskText);
        tasksLayout = v.findViewById(R.id.currentTasksList);
        newTaskButton = v.findViewById(R.id.enterButton);

        newTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = newTaskText.getText().toString();
                newTaskText.setText("");
                //TODO введенную задачу записываем в файл

                //TODO создаём объекты интерфейса в зависимости от чтения из файла
                //создать объект интерфейса
                TextView newTask = new TextView(getContext());
                //настроить объект интерфейса
                newTask.setText(task);


                //Создать параметры нового элемента
                LinearLayout.LayoutParams layoutParams = new LinearLayout
                        .LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                
                //Добавить элемент интерфейса
                tasksLayout.addView(newTask, layoutParams);
                //обращение к дочерним элемнтам layout
                //tasksLayout.getChildCount();
                //tasksLayout.getChildAt(0);
            }
        });

        return v;
    }
}