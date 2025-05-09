import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

public class IngredientTest {
    private Ingredient ingredient;
    private String expectedName = "Огурцы";
    private float expectedPrice = 8.5f;

    @Before
    public void setUp() {
        ingredient = new Ingredient(FILLING,"Огурцы", 8.5f);
    }

    @Test
    public void checkNameIngredientTest() {
        String actualName = ingredient.getName();
        assertEquals("Актуальное название ингредиента не совпадает с ожидаемым результатом", expectedName, actualName);
    }

    @Test
    public void checkPriceIngredientTest(){
        float actualPrice = ingredient.getPrice();
        assertEquals("Актуальная цена ингредиента не совпадает с ожидаемым результатом", expectedPrice, actualPrice, 0);
    }
}
