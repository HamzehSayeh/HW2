package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.najah.code.Recipe;
import main.najah.code.RecipeBook;

class RecipeBookTest {

    @Test
    @DisplayName("Test adding a recipe")
    void testAddRecipe() {
        RecipeBook book = new RecipeBook();
        Recipe recipe = new Recipe();
        recipe.setName("Coffee");

        assertTrue(book.addRecipe(recipe));
    }

    @Test
    @DisplayName("Test deleting a recipe")
    void testDeleteRecipe() {
        RecipeBook book = new RecipeBook();
        Recipe recipe = new Recipe();
        recipe.setName("Tea");

        book.addRecipe(recipe);
        assertEquals("Tea", book.deleteRecipe(0));
    }

    @Test
    @DisplayName("Test deleting a non-existing recipe")
    void testDeleteNonExistingRecipe() {
        RecipeBook book = new RecipeBook();
        assertNull(book.deleteRecipe(0));
    }
}
