package com.test.texnlogialogismikou;

import java.util.ArrayList;

public class IngredientLibrary {



    private ArrayList<Ingredient> Ingredients= new ArrayList<>();

    public static IngredientLibrary IngredientInstance = new IngredientLibrary();

    public static IngredientLibrary getInstance(){
        return IngredientInstance;
    }

    public void addIngredient(Ingredient in){
        Ingredients.add(in);
    }

    public ArrayList returnIngredients(){
        return Ingredients;
    }
}
