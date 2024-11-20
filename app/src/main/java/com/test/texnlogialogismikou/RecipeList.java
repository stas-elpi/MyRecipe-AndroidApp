package com.test.texnlogialogismikou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RecipeList {
    static ArrayList<Recipe> ListOfRecipes= new ArrayList<>();

    public static RecipeList recipeListInstance = new RecipeList();

    public static RecipeList getInstance(){
        return recipeListInstance;
    }



    public void addRecipe(HashMap<Ingredient, Integer> ListOfRecipeIngredients, String NutritionValue, MealState meal, String name, String execution){
        Recipe recipe = new Recipe(ListOfRecipeIngredients, NutritionValue, meal, execution);
        recipe.name = name;
        ListOfRecipes.add(recipe);
        recipe.calculateCalories();
    }

    public ArrayList<Recipe> searchByIngredient(ArrayList<Ingredient> Ingredients   ){
        ArrayList<Recipe> result = new ArrayList<>();
        for(Recipe x: ListOfRecipes){
            HashMap<Ingredient,Integer> map = x.getIngredients();
            boolean check = false;
            for(Ingredient y: Ingredients){
                if(!map.containsKey(y)){
                    check =true;
                }
            }
            if(!check){
                result.add(x);
                System.out.println(x.name);
            }
        }

        return result;
    }

    public Recipe randomRecipe(){
        Random r = new Random();
        int k = r.nextInt(ListOfRecipes.size());
        return ListOfRecipes.get(k);
    }


}

