import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class IngredientTypeParamTest {
    private IngredientType type;
    private String typeName;

    public IngredientTypeParamTest(IngredientType type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientType() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void checkIngredientTypeTest() {
        assertEquals(type, IngredientType.valueOf(typeName));
    }
}