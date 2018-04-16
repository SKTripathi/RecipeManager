package com.monsant.sbt.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.monsant.sbt.bean.Recipe;
import com.monsant.sbt.service.RecipeService;

public class TestRecipeController {

	private static RecipeController recipeController = new RecipeController();
	private static RecipeService recipeService = mock(RecipeService.class);
	Recipe test = mock(Recipe.class);
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		recipeController.setRecipeService(recipeService);
	}
	@Before
	public void setUp() throws Exception {
		System.out.println("before");
	}

	@Test
	public void testGetRecipeWhenIdNotexist(){
		System.out.println("test case getRecipe");
		when(recipeService.getRecipeById(2)).thenReturn(null);
		
		assertNull(recipeController.getRecipeById(2));
	}
	
	@Test
	public void testGetRecipeWhenIdexist(){
		Recipe recipe = new Recipe();
		recipe.setName("Recipe2");
		when(recipeService.getRecipeById(2)).thenReturn(recipe);
		
		assertEquals("Recipe2",recipeController.getRecipeById(2).getName());
		
	}
	
}
