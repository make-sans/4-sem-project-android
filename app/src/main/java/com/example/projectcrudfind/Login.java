package com.example.projectcrudfind;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity implements View.OnClickListener {



    Button buttonLogin;
    EditText editUsername, editPassword;
    TextView textViewRegisterLink;
    UserDetailsStorage userDetailsStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassword = (EditText) findViewById(R.id.editPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        textViewRegisterLink = (TextView)  findViewById(R.id.textViewRegisterLink);
        buttonLogin.setOnClickListener(this);
        textViewRegisterLink.setOnClickListener(this);
        userDetailsStorage = new UserDetailsStorage(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonLogin:

                User user = new User(null, null, null);
                userDetailsStorage.storeUserData(user);
                userDetailsStorage.setLoggedInUser(true);

                break;

            case R.id.textViewRegisterLink:

                    startActivity(new Intent(this, Register.class));
                    break;



        }
    }
}
