package com.test.texnlogialogismikou;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.widget.ActivityChooserView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class FindRecipe extends Activity {

    Spinner spinner;
    IngredientLibrary library = IngredientLibrary.getInstance();
    ArrayList<Ingredient> ingredients = library.returnIngredients();

    ArrayList<Ingredient> criteria = new ArrayList();

    TextView label1;

    TextView label2;

    TextView label3;

    TextView label4;

    TextView label5;

    TextView label6;

    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.findrecipe);

        super.onCreate(savedInstanceState);
        spinner = findViewById(R.id.spinner);

        label1 = (TextView) findViewById(R.id.l1);
        label2 = (TextView) findViewById(R.id.l2);
        label3 = (TextView) findViewById(R.id.l3);
        label4 = (TextView) findViewById(R.id.l4);
        label5 = (TextView) findViewById(R.id.l5);
        label6 = (TextView) findViewById(R.id.l6);



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
        RecipeList recipeList = RecipeList.getInstance();
        ArrayList<Recipe> result = recipeList.searchByIngredient(criteria);




        if(result.size()>0){
            Recipe recommended1 = result.get(0);
            HashMap<Ingredient, Integer> ing1= recommended1.getIngredients();
            String result1 = "";
            for (Map.Entry<Ingredient, Integer> entry : ing1.entrySet()) {
                Ingredient key = entry.getKey();
                Integer value = entry.getValue();
                result1+=key.getName()+", ";
                result1+=value;
                result1+="\n";
            }
            String exec = recommended1.returnExecution();
            label1.setText(recommended1.name);
            label2.setText(result1);
            label3.setText(exec);
        }
        if(result.size()>1){
            Recipe recommended2 = result.get(1);
            HashMap<Ingredient, Integer> ing2= recommended2.getIngredients();

            String result2 = "";
            for (Map.Entry<Ingredient, Integer> entry : ing2.entrySet()) {
                Ingredient key = entry.getKey();
                Integer value = entry.getValue();
                result2+=key.getName()+", ";
                result2+=value;
                result2+="\n";
            }

            String exec2 = recommended2.returnExecution();
            label4.setText(recommended2.name);
            label5.setText(result2);
            label6.setText(exec2);
        }

    }
}
