package com.test.texnlogialogismikou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.widget.ActivityChooserView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Register extends Activity {







    EditText input1;

    EditText input2;


    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.register);

        super.onCreate(savedInstanceState);

        input1 = (EditText) findViewById(R.id.input1);

        input2 = (EditText) findViewById(R.id.input2);






    }


    public void registernow(View v) {
        String name = input1.getText().toString();
        String pass = input2.getText().toString();
        Passwords password = Passwords.getInstance();
        HashMap<String, String> passwordmap= password.passwordmap;
        passwordmap.put(name,pass);
        Intent myIntent = new Intent(v.getContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);






    }


}
