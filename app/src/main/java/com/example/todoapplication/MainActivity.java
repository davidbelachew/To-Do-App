package com.example.todoapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Declare variables for the list and its adapter, as well as the views for adding tasks
    private ArrayList<String> toDoList;
    private ArrayAdapter<String> toDoAdapter;
    private ListView toDoListView;
    private Button addButton;
    private EditText addTaskEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the list and its adapter
        toDoList = new ArrayList<>();
        toDoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, toDoList);

        // Get a reference to the ListView and the views for adding tasks
        toDoListView = findViewById(R.id.to_do_list_view);
        addButton = findViewById(R.id.add_button);
        addTaskEditText = findViewById(R.id.add_task_edit_text);

        // Set the adapter for the ListView
        toDoListView.setAdapter(toDoAdapter);

        // Set an OnItemClickListener for the ListView
        toDoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the task that was clicked on
                String task = toDoList.get(position);

                // Remove the task from the list and update the ListView
                toDoList.remove(position);
                toDoAdapter.notifyDataSetChanged();

                // Show a toast message to confirm that the task was completed
                Toast.makeText(MainActivity.this, "Task '" + task + "' completed!", Toast.LENGTH_SHORT).show();
            }
        });

        // Set an OnClickListener for the add button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the task to add from the EditText
                String newTask = addTaskEditText.getText().toString();

                // Add the task to the list and update the ListView
                toDoList.add(newTask);
                toDoAdapter.notifyDataSetChanged();

                // Clear the EditText
                addTaskEditText.setText("");
            }
        });
    }
}
