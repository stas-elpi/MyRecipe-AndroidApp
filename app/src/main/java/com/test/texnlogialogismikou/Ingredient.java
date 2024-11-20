package com.test.texnlogialogismikou;

import androidx.annotation.NonNull;

public class Ingredient implements Cloneable{
    private String name ="";
    private int calories;

    private int weight = 0;



    Ingredient(){

    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName(){
        return name;
    }
    public int getCalories(){
        return calories;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setCalories(int calories){
        this.calories = calories;
    }
    public void setWeigh(int weight){
        this.weight=weight;
    }

    public int getWeigh(){
        return weight;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
