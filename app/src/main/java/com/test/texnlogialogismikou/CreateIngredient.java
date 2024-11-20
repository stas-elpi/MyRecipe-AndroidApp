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

public class CreateIngredient extends Activity {   ///mono gia admin

    IngredientLibrary library = IngredientLibrary.getInstance();
    ArrayList<Ingredient> ingredients = library.returnIngredients();


    EditText input0;
    EditText input1;

    EditText input2;


    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.create_ingredient);

        super.onCreate(savedInstanceState);

        input0 = (EditText) findViewById(R.id.input0);

        input1 = (EditText) findViewById(R.id.input1);

        input2 = (EditText) findViewById(R.id.input2);









    }


    public void getSelectedIngredient(View v) {

        String name = input0.getText().toString();   //diavazei inputs
        String cal = input1.getText().toString();
        String grams = input2.getText().toString();

        Ingredient ingredient = new Ingredient();
        ingredient.setName(name);
        ingredient.setCalories(Integer.parseInt(cal));
        ingredient.setWeigh(Integer.parseInt(grams));

        ingredients.add(ingredient);





    }

    public  void getSelectedRecipeWindow(View v){
        Intent myIntent = new Intent(v.getContext(), CreateRecipe.class);
        startActivityForResult(myIntent, 0);
    }



}
