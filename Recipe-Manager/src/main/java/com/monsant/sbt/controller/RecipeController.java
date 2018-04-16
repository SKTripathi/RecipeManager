package com.monsant.sbt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.monsant.sbt.bean.Recipe;
import com.monsant.sbt.service.RecipeService;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	public void setRecipeService(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping(value = "/recipe/{id}", method = RequestMethod.GET)
	public @ResponseBody Recipe getRecipeById(@PathVariable("id") int recipeId) {
		Recipe recipe = recipeService.getRecipeById(recipeId);
		return recipe;
	}
	
	@RequestMapping(value = "/addRecipe", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addRecipe(@RequestBody Recipe recipe) {
		//boolean isSaved = false;
		System.out.print("Recipe Succesfully called.....");
		//isSaved = 
		recipeService.addRecipe(recipe);
		System.out.print("Recipe Succesfully added.....");
		//return isSaved;
	} 
	
	@RequestMapping(value = "/recipeList", method = RequestMethod.GET)
	public @ResponseBody List<Recipe> listRecipe(){
		List<Recipe>  recipeList =recipeService.listRecipe();
		
		//System.out.print(recipeList);
		
		return recipeList;

	}

}
