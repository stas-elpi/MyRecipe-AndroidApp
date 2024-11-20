package com.test.texnlogialogismikou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Recipe {
    private final HashMap<Ingredient, Integer> ListOfRecipeIngredients;
    private String NutritionValue;
    int TotalCalories;
    private MealState meal;

    String name;

    private String exetcution = "";

    Recipe(HashMap<Ingredient, Integer> ListOfRecipeIngredients, String NutritionValue, MealState meal, String exetcution){
        this.ListOfRecipeIngredients = ListOfRecipeIngredients;
        this.NutritionValue = NutritionValue;
        this.meal =meal;
        this.exetcution = exetcution;
    }

    public int calculateCalories(){
        Iterator<Map.Entry<Ingredient, Integer>> it = ListOfRecipeIngredients.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Ingredient, Integer> pair = (Map.Entry<Ingredient, Integer>)it.next();
            TotalCalories+=pair.getKey().getCalories()*pair.getValue();
        }
        return TotalCalories;
    }
    public MealState getMeal(){
        return meal;
    }
    public String getNutritionValue(){
        return NutritionValue;
    }

    public String returnExecution() {
        return exetcution;
    }

    public HashMap<Ingredient, Integer> getIngredients() {
        return ListOfRecipeIngredients;
    }
}
