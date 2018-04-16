package com.monsant.sbt.dao;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.monsant.sbt.bean.Recipe;

public class RecipeDao extends JdbcDaoSupport {
	DataSource dataSource;

	public boolean addRecipe(Recipe recipe) {
		try {

			String query = "INSERT INTO recipes "
					+ " (First_Ingredient,Second_Ingredient,Third_Ingredient,Fourth_Ingredient,name) "
					+ " VALUES" + "  ('" + recipe.getFirstIngredient() + "','"
					+ recipe.getSecondIngredient() + "','"
					+ recipe.getThirdIngredient() + "','"
					+ recipe.getFourthIngredient() + "','"
					+ recipe.getName() + "')";

			getJdbcTemplate().execute(query);
			return true;
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			return false;
		}
	}

	public Recipe getRecipeById(int recipeId) {
		Recipe recipe = new Recipe();
		try {
			// Execute a query
			System.out.println("Creating statement...");
			String query = "select * FROM recipes " + "WHERE id = ?";
			Object[] inputs = new Object[] { recipeId };
			recipe = (Recipe) getJdbcTemplate().queryForObject(query, inputs,
					new BeanPropertyRowMapper(Recipe.class));
			if(recipe == null){
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recipe;
	}

	public List<Recipe> listRecipe() {
		List<Recipe> recipeList = new ArrayList<Recipe>();

		try {
			String query = "SELECT * FROM recipes";
			recipeList = getJdbcTemplate().query(query,
					new BeanPropertyRowMapper(Recipe.class));
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return recipeList;
	}
}
