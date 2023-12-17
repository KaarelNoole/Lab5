package com.nagel.lab5.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RecipeViewModel extends AndroidViewModel {
    private final RecipeRepository repository;
    private final LiveData<List<Recipe>> allRecipes;

    public RecipeViewModel(@NonNull Application application){
        super(application);
        repository = new RecipeRepository(application);
        allRecipes = repository.getAllRecipes();
    }

    public void Insert(Recipe recipe){
        repository.Insert(recipe);
    }
    public void update(Recipe recipe){
        repository.Update(recipe);
    }
    public void delete(Recipe recipe){
        repository.Delete(recipe);
    }
    public void deleteAll(Recipe recipe){
        repository.DeleteAll(recipe);
    }
    public LiveData<List<Recipe>> getAllRecipes(){
        return allRecipes;
    }
}
