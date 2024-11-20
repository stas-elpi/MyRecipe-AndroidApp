package com.test.texnlogialogismikou;

import android.app.Activity;
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

public class CreateRecipe extends Activity {

    Spinner spinner;
    IngredientLibrary library = IngredientLibrary.getInstance();
    ArrayList<Ingredient> ingredients = library.returnIngredients();

    ArrayList<Ingredient> criteria = new ArrayList();

    EditText input1;

    EditText input2;


    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.create_recipe);

        super.onCreate(savedInstanceState);
        spinner = findViewById(R.id.spinner);

        input1 = (EditText) findViewById(R.id.input1);

        input2 = (EditText) findViewById(R.id.input2);




        ArrayAdapter<Ingredient> adapter = new ArrayAdapter<Ingredient>(this,
                android.R.layout.simple_spinner_item, ingredients);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Ingredient ingredient = (Ingredient) parent.getSelectedItem();
                criteria.add(ingredient);    //add ingredient every time its chosen
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

    }


    public void getSelectedIngredient(View v) {
        if (!flag){
            criteria.remove(0);  //remove first element because it was added on its own
            flag=true;
        }
        String name = input1.getText().toString();
        String exec = input2.getText().toString();
        RecipeList recipeList = RecipeList.getInstance();
        MealState lunch = MealState.LUNCH;
        HashMap<Ingredient, Integer> map = new HashMap();
        for(Ingredient r:criteria){
            map.put(r,1);
        }
        recipeList.addRecipe(map, "medium", lunch,name,exec);
        System.out.println(name);
        System.out.println(map.size());
        System.out.println(exec);





        }


}
