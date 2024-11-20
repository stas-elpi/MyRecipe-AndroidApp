package com.test.texnlogialogismikou;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainMenuUser extends Activity {

    ImageView searchh;

    ImageView searchh2;

    TextView label1;

    TextView label2;

    TextView label3;

    TextView label4;

    TextView label5;

    TextView label6;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.menu_user);

        super.onCreate(savedInstanceState);
        searchh = (ImageView) findViewById(R.id.search);
        searchh2 = (ImageView) findViewById(R.id.search2);
        label1 = (TextView) findViewById(R.id.label1);
        label2 = (TextView) findViewById(R.id.label2);
        label3 = (TextView) findViewById(R.id.label3);
        label4 = (TextView) findViewById(R.id.label4);
        label5 = (TextView) findViewById(R.id.label5);
        label6 = (TextView) findViewById(R.id.label6);

        RecipeList recipelist = RecipeList.getInstance();
        Recipe recommended1 = recipelist.randomRecipe();
        Recipe recommended2 = recipelist.randomRecipe();
        while(Objects.equals(recommended1.name, recommended2.name)){
            recommended2 = recipelist.randomRecipe();
        }
        HashMap<Ingredient, Integer> ing1= recommended1.getIngredients();

        String result = "";
        for (Map.Entry<Ingredient, Integer> entry : ing1.entrySet()) {
            Ingredient key = entry.getKey();
            Integer value = entry.getValue();
            result+=key.getName()+", ";
            result+=value;
            result+="\n";
        }

        HashMap<Ingredient, Integer> ing2= recommended2.getIngredients();

        String result2 = "";
        for (Map.Entry<Ingredient, Integer> entry : ing2.entrySet()) {
            Ingredient key = entry.getKey();
            Integer value = entry.getValue();
            result2+=key.getName()+", ";
            result2+=value;
            result2+="\n";
        }

        String exec = recommended1.returnExecution();
        String exec2 = recommended2.returnExecution();
        System.out.println(exec.length());
        label1.setText(recommended1.name);
        label2.setText(result);
        label5.setText(exec);
        label3.setText(recommended2.name);
        label4.setText(result2);
        label6.setText(exec2);




        searchh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), FindRecipe.class);
                startActivityForResult(myIntent, 0);
            }
        });

        searchh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(view.getContext(), CreateRecipe.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }


}
