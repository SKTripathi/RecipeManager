var app = angular.module("recipeManager", ['ngRoute']);


app.controller("recipeController", ['$scope','$http', function($scope,$http, $location, $window) {
	
	$scope.addRecipe = function (isValid, recipe){
		console.log(recipe);
		if(recipe !== undefined ){
			if(recipe.name !== undefined && recipe.firstIngredient !== undefined){
				$http({
					  method: 'POST',
					  url: 'http://localhost:8082/RecipeManagerNew/addRecipe',
					  data : angular.toJson(recipe)
					}).then(function successCallback(response) {
					    $scope.name = '';
					    
					    
					  }, function errorCallback(response) {
					    // called asynchronously if an error occurs
					    // or server returns response with an error status.
					  });
				
			}	
		}else{
			console.log('No data to save. Please enter data');
		}
		
		
	};
	
	// Simple GET request example:
	$scope.fetRecipeData = function (recipe){
		
	};
	
	$scope.fetchRecipe = function (recipe){
		recipe = recipe.name;
		console.log('Recipe data :: ' + recipe);
		console.log('http://localhost:8082/RecipeManagerNew/recipe/'+recipe.id);
		 $http({
			  method: 'GET',
			  url: 'http://localhost:8082/RecipeManagerNew/recipe/'+recipe.id
			}).then(function successCallback(response) {
				$scope.recipeData = response.data;
				
				console.log('response value  :: '+$scope.recipeData);
			    window.location.href = "#/listRecipe";
			  }, function errorCallback(response) {
			    // called asynchronously if an error occurs
			    // or server returns response with an error status.
			  });
			
	};
	
	$scope.fetchRecipeList = function (){
		$http({
			  method: 'GET',
			  url: 'http://localhost:8082/RecipeManagerNew/recipeList'
			}).then(function successCallback(response) {
			    // this callback will be called asynchronously
			    // when the response is available
				$scope.recipeList = response.data;
			  }, function errorCallback(response) {
			    // called asynchronously if an error occurs
			    // or server returns response with an error status.
			  });
			
	}
		
	
	
}]);



	
	app.config(function ($routeProvider,$locationProvider){
		$locationProvider.hashPrefix('');
	   	 $routeProvider.when('/', {templateUrl : 'template/home.html'}),
	   	 
	   	$routeProvider.when('/addRecipe', {templateUrl : 'template/addRecipe.html'}),
	   	
	   	$routeProvider.when('/listRecipe', {templateUrl : 'template/listRecipe.html'});
	   	 
	    });
    
	
	
        
	      // service
	     
	     
	     app.init=function(){
		     angular.bootstrap(document,['recipeManager']);
		
 };