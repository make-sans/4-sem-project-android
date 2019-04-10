package com.example.projectcrudfind;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity implements View.OnClickListener{



    Button buttonRegister;
    EditText editName, editUsername, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

              editName =  (EditText)  findViewById(R.id.editName);
              editUsername = (EditText) findViewById(R.id.editUsername);
              editPassword = (EditText) findViewById(R.id.editPassword);

              buttonRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonRegister:

                String name = editName.getText().toString();
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();

                User registeredData = new User(name, username, password);
                startActivity(new Intent(this, Login.class));
                break;

        }
    }
}
