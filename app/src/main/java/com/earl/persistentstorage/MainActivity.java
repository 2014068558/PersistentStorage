package com.earl.persistentstorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUname, etPw;
    Button btnSave, btnDisplay;
    TextView tvDisplay;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUname = (EditText) findViewById (R.id.editUname);
        etPw = (EditText) findViewById (R.id.editPw);
        btnSave = (Button) findViewById (R.id.save);
        btnDisplay = (Button) findViewById (R.id.display);
        tvDisplay = (TextView) findViewById (R.id.tv_display);
        preferences = getPreferences(Context.MODE_PRIVATE);

    }

    public void saveInfo (View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", etUname.getText().toString());
        editor.putString("password", etPw.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();

    }

    public void loadInfo (View view) {
        String user = preferences.getString("Username", "");
        String pwd = preferences.getString("Password", "");
        tvDisplay.setText("The password of " + user + " is " + pwd);

    }
}
