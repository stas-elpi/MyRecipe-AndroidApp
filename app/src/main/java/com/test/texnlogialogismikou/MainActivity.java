package com.test.texnlogialogismikou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Passwords passwords = Passwords.getInstance();

    HashMap<String,String> passwordsmap = passwords.passwordmap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        MaterialButton loginbtn2 = (MaterialButton) findViewById(R.id.loginbtn2);

        //admin and admin
        try {
            createDatabase();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
                    //correct
                    Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(v.getContext(), CreateIngredient.class);
                    startActivityForResult(myIntent, 0);
                } else if (username.getText().toString().equals("user") && password.getText().toString().equals("user")) {
                    Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(v.getContext(), MainMenuUser.class);
                    startActivityForResult(myIntent, 0);
                } else if (Objects.equals(passwordsmap.get(username.getText().toString()), password.getText().toString())) {
                    Toast.makeText(MainActivity.this,"LOGIN SUCCESSFUL",Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(v.getContext(), MainMenuUser.class);
                    startActivityForResult(myIntent, 0);
                } else
                    //incorrect
                    Toast.makeText(MainActivity.this,"INCORRECT PASSWORD OR USERNAME",Toast.LENGTH_SHORT).show();
            }
        });

        loginbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(v.getContext(), Register.class);
                startActivityForResult(myIntent, 0);
            }
        });


    }

    public void createDatabase() throws CloneNotSupportedException {
        RecipeList recipeList = RecipeList.getInstance();
        IngredientLibrary ingredient_library= IngredientLibrary.getInstance();
        MealState lunch = MealState.LUNCH;
        MealState brunch = MealState.BRUNCH;
        MealState breakfast = MealState.BREAKFAST;

        Ingredient small_tomato = new Ingredient();
        small_tomato.setName("Small Tomato");
        small_tomato.setCalories(19);
        small_tomato.setWeigh(100);

        Ingredient feta_cheese = new Ingredient();
        feta_cheese.setName("Feta Cheese");
        feta_cheese.setWeigh(100);
        feta_cheese.setCalories(264);

        Ingredient spaghetti = new Ingredient();
        spaghetti.setName("Spaghetti");
        spaghetti.setWeigh(100);
        spaghetti.setCalories(158);

        Ingredient egg = new Ingredient();
        egg.setName("Egg");
        egg.setWeigh(50);
        egg.setCalories(80);

        Ingredient potato = new Ingredient();
        potato.setName("Potato");
        potato.setWeigh(100);
        potato.setCalories(110);

        Ingredient garlic = new Ingredient();
        garlic.setName("Garlic");
        garlic.setWeigh(50);
        garlic.setCalories(56);

        Ingredient masturd = new Ingredient();
        masturd.setName("Mustard");
        masturd.setWeigh(50);
        masturd.setCalories(33);

        Ingredient mashed_tomato = new Ingredient();
        mashed_tomato.setName("Mashed Tomato");
        mashed_tomato.setWeigh(100);
        mashed_tomato.setCalories(38);


        Ingredient clam = new Ingredient();
        clam.setName("Clam");
        clam.setWeigh(100);
        clam.setCalories(148);

        Ingredient onion = new Ingredient();
        onion.setName("onion");
        onion.setWeigh(100);
        onion.setCalories(40);

        Ingredient tuna_can  = new Ingredient();
        tuna_can.setName("Tuna Can");
        tuna_can.setWeigh(100);
        tuna_can.setCalories(132);

        Ingredient lentils  = new Ingredient();
        lentils.setName("lentils");
        lentils.setWeigh(100);
        lentils.setCalories(116);

        Ingredient sliceOfBread  = new Ingredient();
        sliceOfBread.setName("slice of bread");
        sliceOfBread.setWeigh(40);
        sliceOfBread.setCalories(106);


        ingredient_library.addIngredient(small_tomato);
        ingredient_library.addIngredient(feta_cheese);
        ingredient_library.addIngredient(spaghetti);
        ingredient_library.addIngredient(onion);
        ingredient_library.addIngredient(masturd);
        ingredient_library.addIngredient(mashed_tomato);
        ingredient_library.addIngredient(potato);
        ingredient_library.addIngredient(garlic);
        ingredient_library.addIngredient(egg);
        ingredient_library.addIngredient(tuna_can);
        ingredient_library.addIngredient(clam);
        ingredient_library.addIngredient(lentils);
        ingredient_library.addIngredient(onion);



        HashMap<Ingredient, Integer> Tuna_Spaghetti = new HashMap();
        Tuna_Spaghetti.put(tuna_can, 1);
        Tuna_Spaghetti.put(mashed_tomato, 1);
        Tuna_Spaghetti.put(garlic, 1);
        Tuna_Spaghetti.put(onion, 1);

        String execution = "Add the chopped onion to the pan and sauté it with a little sugar to caramelize\n" +
                "Then add the can along with its juice if it's in oil (nicer but unhealthier) \n" +
                "Add some cinnamon, pepper and garlic powder \n" +
                "Put in the tomato puree and leave it for a while with the heat turned down \n" +
                "The sauce is ready and you serve it with pasta ";
        recipeList.addRecipe(Tuna_Spaghetti, "medium", lunch,"Spaghetti with tuna", execution);




        HashMap<Ingredient, Integer> feta_spaghetti = new HashMap();
        feta_spaghetti.put(spaghetti, 1);
        feta_spaghetti.put(feta_cheese, 2);
        feta_spaghetti.put(small_tomato, 1);

        execution = "Preheat oven to 200°C (180ºC fan). In a large ovenproof pan or medium \n" +
                "baking dish, combine tomatoes, shallot, garlic, and most of the olive oil.\n " +
                "Season with salt and chilli flakes and toss to combine. \n" +
                "Place feta into centre of tomato mixture and drizzle top with remaining \n" +
                "olive oil. Scatter thyme over tomatoes. Bake for 40 to 45 minutes, until \n" +
                "tomatoes are bursting and feta is golden on top. \n" +
                "Meanwhile, in a large pot of salted boiling water, cook pasta according to \n" +
                "package instructions. Reserve 120ml pasta water before draining.\n" +
                "\n" +
                "To pan with tomatoes and feta, add cooked pasta, reserved pasta water, and \n" +
                "lemon zest (if using) to pan and stir until completely combined. Garnish with basil before serving.";
        recipeList.addRecipe(feta_spaghetti, "medium", lunch,"Feta Spaghetti", execution);




        HashMap<Ingredient, Integer> tomato_soup = new HashMap();
        tomato_soup.put(small_tomato, 2);
        tomato_soup.put(onion, 2);
        tomato_soup.put(garlic, 1);

        execution = "Put tomatoes cut into large pieces in the oven along with the onion. \n" +
                "Add enough garlic powder oil, oregano pepper and salt. \n" +
                "Put them in the oven until the tomatoes start to shrivel. \n" +
                "Immediately after that, throw them in the blender a few at a time along with their juices.\n" +
                "Put them in a saucepan and pour in half a glass of milk (full) and water.\n" +
                "Wait until they boil and then add water or salt and pepper if needed. \n" +
                "Combined with toasted bread.";
        recipeList.addRecipe(tomato_soup, "high", lunch,"Tomato Soup", execution);



        HashMap<Ingredient, Integer> Clams_Masturd = new HashMap();
        Clams_Masturd.put(clam, 1);
        Clams_Masturd.put(feta_cheese, 1);
        Clams_Masturd.put(garlic, 1);
        Clams_Masturd.put(masturd, 1);

        execution = "Defrost the mussels several hours before putting them in the canner \n" +
                "Once thawed, rinse them and at the same time turn on the stove and put oil in the pan to boil \n" +
                "Once the oil is boiling, add mustard (2-3 tablespoons), garlic powder and \n" +
                "some spice for a little more spicy taste (issa issa)\n" +
                "Stir and add the mussels after drying them with some paper first so that they don't have too much water \n" +
                "With the oil and the sauce burnt, leave the mussels in for exactly 3 minutes , stirring every minute or so \n" +
                "Once the three minutes are up, lower the heat ( to 1 ) and pour in half a glass of wine. \n" +
                "Cover and let them simmer for 4-5 minutes.\n" +
                "Once they're done, turn off the heat and let them sit for a couple of minutes. \n" +
                "Finally, grate some feta cheese and stir it in. \n" +
                "They are ready to be served with a little rice or oatmeal ";
        recipeList.addRecipe(Clams_Masturd, "High", lunch,"Clams With Masturd", execution);




        HashMap<Ingredient, Integer> lentils_soup = new HashMap();
        lentils_soup.put(mashed_tomato, 1);
        lentils_soup.put(lentils, 3);
        lentils_soup.put(onion, 1);
        lentils_soup.put(garlic, 1);

        execution = "I put them on a tray to look for stones \n" +
                "Finely chop an onion (in a bowl)\n" +
                "and put it aside \n" +
                "If you have fresh tomatoes, put them in the bowl. \n" +
                "Otherwise we'll have pulp.\n" +
                "Put oil in the pot and let it burn and once it's hot add the \n" +
                " onion until it's shiny and then immediately add the lentils \n" +
                "Add the chopped tomato, \n" +
                "Add pepper, oregano and garlic powder and add enough hot water \n" +
                "Bring it to boil and once it comes to a boil, lower the heat and let the lentils simmer, \n" +
                "checking if it needs water supplement for about forty minutes";
        recipeList.addRecipe(lentils_soup, "high", lunch,"Lentils Soup", execution);





        HashMap<Ingredient, Integer> tomato_onion_feta_salad = new HashMap();
        tomato_onion_feta_salad.put(feta_cheese, 1);
        tomato_onion_feta_salad.put(small_tomato, 1);
        tomato_onion_feta_salad.put(onion, 1);

        execution = "1. In a bowl, combine the diced tomato and thinly sliced onion.\n" +
                "2. Drizzle the olive oil over the tomato and onion mixture.\n" +
                "3. Season with salt and pepper to taste.\n" +
                "4. Toss everything together to coat the ingredients with the olive oil and seasoning.\n" +
                "5. Sprinkle the crumbled feta cheese over the top of the salad.\n" +
                "6. Garnish with fresh parsley.\n" +
                "7. Serve the Tomato, Onion, and Feta Salad as a refreshing side dish or light lunch";
        recipeList.addRecipe(tomato_onion_feta_salad, "high", brunch,"Tomato, Onion and Feta Salad", execution);



        HashMap<Ingredient, Integer> Tuna_Tomato_Sandwhich = new HashMap();
        Tuna_Tomato_Sandwhich.put(tuna_can, 1);
        Tuna_Tomato_Sandwhich.put(small_tomato, 1);
        Tuna_Tomato_Sandwhich.put(sliceOfBread, 2);

        execution = "Spread mayonnaise on one slice of bread.\n" +
                "Place the tuna on top of the mayonnaise.\n" +
                "Add the tomato slices and season with salt and pepper.\n" +
                "Optionally, add lettuce or spinach leaves.\n" +
                "Top with the second slice of bread.\n" +
                "Cut the sandwich in half if desired and enjoy.";
        recipeList.addRecipe(Tuna_Tomato_Sandwhich, "high", breakfast,"Tuna and Tomato Sandwhich", execution);



        HashMap<Ingredient, Integer> bakedPotato_feta = new HashMap();
        bakedPotato_feta.put(sliceOfBread, 2);
        bakedPotato_feta.put(feta_cheese, 1);

        execution = "Preheat the oven to 400°F (200°C).\n" +
                "Wash and scrub the potato.\n" +
                "Prick the potato several times with a fork.\n" +
                "Rub the potato with olive oil and sprinkle with salt and pepper.\n" +
                "Place the potato on a baking sheet and bake for about 45 minutes or until tender.\n" +
                "Slice the potato open and sprinkle the crumbled feta cheese on top.\n" +
                "Serve the baked potato with feta as a delicious and simple side dish.";
        recipeList.addRecipe(bakedPotato_feta, "medium", lunch,"Baked Potato with Feta", execution);



        HashMap<Ingredient, Integer> TomatoFetaBruchetta = new HashMap();
        TomatoFetaBruchetta.put(spaghetti, 1);
        TomatoFetaBruchetta.put(feta_cheese, 2);
        TomatoFetaBruchetta.put(small_tomato, 1);

        execution = "Preheat the oven to 375°F (190°C).\n" +
                "Place the bread slices on a baking sheet.\n" +
                "Optional: Rub the bread slices with the cut sides of the garlic clove for extra flavor.\n" +
                "Toast the bread slices in the oven until golden and crispy.\n" +
                "In a bowl, combine the diced tomato, crumbled feta cheese, chopped basil, salt, and pepper.\n" +
                "Spoon the tomato and feta mixture onto the toasted bread slices.\n" +
                "Serve the Tomato and Feta Bruschetta as an appetizer or snack.";
        recipeList.addRecipe(TomatoFetaBruchetta, "high", lunch,"Tomato and Feta Bruschetta", execution);


        HashMap<Ingredient, Integer> Omelette = new HashMap();
        Omelette.put(egg, 2);
        Omelette.put(onion, 1);
        Omelette.put(feta_cheese, 1);

        execution = "In a bowl, beat the eggs and season with salt and pepper.\n" +
                "Heat the olive oil or butter in a non-stick skillet over medium heat.\n" +
                "Add the thinly sliced onion and sauté until softened and slightly caramelized.\n" +
                "Pour the beaten eggs into the skillet with the onions.\n" +
                "Cook the omelette until the eggs are set, gently lifting the edges \n" +
                "and tilting the pan to allow the uncooked egg to flow to the edges.\n" +
                "Sprinkle the crumbled feta cheese over one half of the omelette.\n" +
                "Fold the other half of the omelette over the cheese to form a half-moon shape.\n" +
                "Cook for another minute until the cheese melts.";
        recipeList.addRecipe(Omelette, "low", lunch,"Onion and Feta Omelette", execution);






    }
}