package com.monsant.sbt.service;

import java.util.List;

import com.monsant.sbt.bean.Recipe;
import com.monsant.sbt.dao.RecipeDao;


public class RecipeService {

	RecipeDao recipeDao;

	public RecipeDao getRecipeDao() {
		return recipeDao;
	}
	public void setRecipeDao(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
	}
	
	public boolean addRecipe(Recipe recipe){
		return recipeDao.addRecipe(recipe);
		
	}
	public Recipe getRecipeById(int RecipeId) {
	       return recipeDao.getRecipeById(RecipeId);
		
	}
	public List<Recipe> listRecipe(){
		return recipeDao.listRecipe();
	}

	


}
