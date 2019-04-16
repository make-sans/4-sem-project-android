package com.example.projectcrudfind;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttonLogout;
    EditText editName, editUsername;
    UserDetailsStorage userDetailsStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        editName =  (EditText) findViewById(R.id.editName);
        editUsername = (EditText) findViewById(R.id.editUsername);

        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(this);

        userDetailsStorage = new UserDetailsStorage(this);
    }

    @Override
    protected void onStart(){
        super.onStart();

        if (authenticate() == true) {
            displayUserDetails();
        }
        else {
            startActivity(new Intent(MainActivity.this, Login.class));

        }
    }

    private boolean authenticate(){

        return userDetailsStorage.getUserLoggedIn();
    }

    private void displayUserDetails(){
        User user = userDetailsStorage.getLoggedInUser();
        editUsername.setText(user.username);
        editName.setText(user.name);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonLogout:
                userDetailsStorage.clearUserData();
                userDetailsStorage.setLoggedInUser(false);


                startActivity(new Intent(this, Login.class));

                break;

        }
    }
}
