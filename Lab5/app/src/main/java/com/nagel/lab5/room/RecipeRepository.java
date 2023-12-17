package com.nagel.lab5.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RecipeRepository {
    private final RecipeDao recipdao;
    private final LiveData<List<Recipe>> allRecipes;

    public RecipeRepository(Application application) {
        RecipeDB db = RecipeDB.getInstance(application);
        recipdao = db.recipeDao();
        allRecipes = recipdao.getAllRecipes();
    }

    public void Insert(Recipe recipe){
        new InsertRecipeAsyncTask(recipdao).execute(recipe);
    }
    public void Delete(Recipe recipe){
        new DeleteRecipeAsyncTask(recipdao).execute(recipe);
    }
    public void Update(Recipe recipe){
        new UpdateRecipeAsyncTask(recipdao).execute(recipe);
    }
    public void DeleteAll(Recipe recipe){
        new DeleteAllRecipesAsyncTask(recipdao).execute(recipe);
    }
    public LiveData<List<Recipe>> getAllRecipes()
    {
    return allRecipes;
    }

    public static class InsertRecipeAsyncTask extends AsyncTask<Recipe, Void, Void>{
        private final RecipeDao recipdao;
        public InsertRecipeAsyncTask(RecipeDao recipeDao){
            this.recipdao = recipeDao;
        }

        @Override
        protected Void doInBackground(Recipe... recipes) {
            recipdao.insert(recipes[0]);
            return null;
        }
    }
    public static class DeleteRecipeAsyncTask extends AsyncTask<Recipe,Void, Void>{
        private final RecipeDao recipdao;
        public DeleteRecipeAsyncTask(RecipeDao recipeDao){
            this.recipdao = recipeDao;
        }
        @Override
        protected Void doInBackground(Recipe... recipes) {
            recipdao.delete(recipes[0]);
            return null;
        }
    }
    public static class UpdateRecipeAsyncTask extends AsyncTask<Recipe,Void, Void>{
        private final RecipeDao recipdao;
        public UpdateRecipeAsyncTask(RecipeDao recipeDao){
            this.recipdao = recipeDao;
        }
        @Override
        protected Void doInBackground(Recipe... recipes) {
            recipdao.update(recipes[0]);
            return null;
        }
    }
    public static class DeleteAllRecipesAsyncTask extends AsyncTask<Recipe,Void,Void>{
        private final RecipeDao recipdao;
        public DeleteAllRecipesAsyncTask(RecipeDao recipeDao){
            this.recipdao = recipeDao;
        }

        @Override
        protected Void doInBackground(Recipe... recipes) {
            recipdao.deleteAllRecipes();
            return null;
        }

    }
}
