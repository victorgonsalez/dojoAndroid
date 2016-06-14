package com.dojoandroid.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.dojoandroid.utils.Constants;

/**
 *
 * Created by Victor on 6/01/16.
 */
public class AuthenticatedActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authenticated);

        TextView nameText = (TextView) findViewById(R.id.name_text);
        Button logOutButton = (Button) findViewById(R.id.logout_button);
        Button showProductsButton = (Button) findViewById(R.id.show_producst_button);

        showProductsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AuthenticatedActivity.this, ProductActivity.class);
                startActivity(intent);
            }
        });
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableLogin();
            }
        });

        nameText.setText(getString(R.string.hello, getIntent().getStringExtra("Name")));
    }

    private void disableLogin() {
        SharedPreferences.Editor editor = getSharedPreferences(Constants.LOG_PREFERENCES, 0).edit();
        editor.putBoolean(Constants.IS_LOGGED, false);
        editor.apply();

        Intent intent = new Intent(AuthenticatedActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("Name", "android");
        startActivity(intent);

        Toast.makeText(AuthenticatedActivity.this, getString(R.string.logout), Toast.LENGTH_SHORT).show();
    }
}
