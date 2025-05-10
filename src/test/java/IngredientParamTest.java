import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientParamTest {
    private IngredientType type;
    private String name;
    private float price;
    private IngredientType expectedType;


    public IngredientParamTest(IngredientType type, String name, float price, IngredientType expectedType){
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredient() {
        return new Object[][] {
                {SAUCE, "Барбекю", 2.8f, SAUCE},
                {FILLING, "Огурцы", 8.5f, FILLING}
        };
    }

    @Test
    public void checkIngredientTypeTest(){
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        assertEquals("Актуальный тип ингредиента не совпадает с ожидаемым результатом", expectedType, actualType);
    }
}
