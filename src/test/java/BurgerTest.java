import org.junit.Before;
import org.junit.Test;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

public class BurgerTest {
    private Burger burger;
    Ingredient ingredient1 = new Ingredient(FILLING, "Котлета", 20.4f);
    Ingredient ingredient2 = new Ingredient(FILLING, "Салат", 10.7f);

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        List<Ingredient> expectedIngredients = List.of(ingredient1, ingredient2);
        List<Ingredient> actualIngredients = burger.ingredients;
        assertEquals("Актуальные ингредиенты бургера отличны от ожидаемого результата", expectedIngredients, actualIngredients);
    }

    @Test
    public void removeIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        List<Ingredient> actualIngredients = burger.ingredients;
        List<Ingredient> expectedIngredients = List.of(ingredient2);
        assertEquals("Актуальные ингредиенты бургера отличны от ожидаемого результата", expectedIngredients, actualIngredients);
    }

    @Test
    public void moveIngredientTest(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        List<Ingredient> actualIngredients = burger.ingredients;
        List<Ingredient> expectedIngredients = List.of(ingredient2, ingredient1);
        assertEquals("Актуальные ингредиенты бургера отличны от ожидаемого результата", expectedIngredients, actualIngredients);
    }
}
