package com.dojoandroid.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dojoandroid.utils.Constants;

/**
 * Main activity of the application
 *
 * Created by Victor on 6/01/16.
 */
public class MainActivity extends Activity {

    private EditText mUserInput;
    private EditText mPassInput;
    private String mUserName;
    private String mPassword;
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedPreferences = getSharedPreferences(Constants.LOG_PREFERENCES, 0);
        setContentView(R.layout.activity_main);
        isAppLogged();
    }

    private void isAppLogged() {

        if (mSharedPreferences.getBoolean("IS_LOGGED", false)) {

            //TODO CREATE A LANDING SCREEN INSTEAD OF USE SUMMARY FOR IT.
            Intent intent = new Intent(MainActivity.this, AuthenticatedActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.putExtra("Name", "android");
            startActivity(intent);
        } else {
            loadUI();
        }
    }

    private void enableLogin(){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(Constants.IS_LOGGED, true);
        editor.apply();
        isAppLogged();
    }

    private void loadUI() {
        mUserInput = (EditText) findViewById(R.id.main_user_input);
        mPassInput = (EditText) findViewById(R.id.main_password_input);
        Button loginButton = (Button) findViewById(R.id.main_button_login);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                mUserName = mUserInput.getText().toString();
                mPassword = mPassInput.getText().toString();

                if (mUserName != null && mUserName.equals("android")
                        && mPassword != null && mPassword.equals("android123")) {

                    enableLogin();
                    isAppLogged();
                    Toast.makeText(MainActivity.this, getString(R.string.welcome), Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.wrong_data), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
