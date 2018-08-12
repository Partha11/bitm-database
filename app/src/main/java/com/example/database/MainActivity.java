package com.example.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameField;
    EditText numbField;

    Button saveButton;
    Button viewButton;

    private DatabaseManager dbManager;

    private List<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initAll();
    }

    public void initAll() {

        dbManager = new DatabaseManager(MainActivity.this);

        nameField = findViewById(R.id.contactName);
        numbField = findViewById(R.id.contactNumber);

        saveButton = findViewById(R.id.saveButton);
        viewButton = findViewById(R.id.viewButton);

        saveButton.setOnClickListener(MainActivity.this);
        viewButton.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.saveButton:

                saveButtonClicked();
                break;

            case R.id.viewButton:

                viewButtonClicked();
                break;
        }
    }

    private void saveButtonClicked() {

        String name = nameField.getText().toString();
        String numb = numbField.getText().toString();

        boolean isInserted = dbManager.insertData(name, numb);

        if (isInserted)

            Toast.makeText(this, "Successful!!", Toast.LENGTH_SHORT).show();

        else

            Toast.makeText(this, "Failed!!", Toast.LENGTH_SHORT).show();
    }

    private void viewButtonClicked() {

        contactList = dbManager.getData();

        Toast.makeText(this, contactList.get(0).getContactName(), Toast.LENGTH_SHORT).show();
    }
}
