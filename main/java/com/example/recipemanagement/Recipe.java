package com.example.recipemanagement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Recipe {
    private final StringProperty recipeName;
    private final StringProperty cookingTime;
    private final StringProperty description;
    private final StringProperty instructions;
    private final StringProperty ingredients;

    public Recipe(String recipeName, String cookingTime, String description, String instructions, String ingredients) {
        this.recipeName = new SimpleStringProperty(recipeName);
        this.cookingTime = new SimpleStringProperty(cookingTime);
        this.description = new SimpleStringProperty(description);
        this.instructions = new SimpleStringProperty(instructions);
        this.ingredients = new SimpleStringProperty(ingredients);
    }

    public String getRecipeName() {
        return recipeName.get();
    }

    public StringProperty recipeProperty() {
        return recipeName;
    }

    public String getCookingTime() {
        return cookingTime.get();
    }

    public StringProperty cookingTimeProperty() {
        return cookingTime;
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public String getInstructions() {
        return instructions.get();
    }

    public StringProperty instructionsProperty() {
        return instructions;
    }

    public String getIngredients() {
        return ingredients.get();
    }

    public StringProperty ingredientsProperty() {
        return ingredients;
    }
}
