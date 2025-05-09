import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {
    private Burger burger;
    Ingredient ingredient1 = new Ingredient(FILLING, "Котлета", 20.4f);
    Ingredient ingredient2 = new Ingredient(FILLING, "Салат", 10.7f);

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(30f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float expectedPrice = bun.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice();
        float actualPrice = burger.getPrice();
        assertEquals("Актуальная цена бургера не совпадает с ожидаемым результатом", expectedPrice, actualPrice, 0);
    }


    @Test
    public void getReceiptTest(){
        burger.setBuns(bun);
        when(bun.getName()).thenReturn("Черная");
        when(bun.getPrice()).thenReturn(30f);
        burger.addIngredient(ingredient);
        when(ingredient.getType()).thenReturn(SAUCE);
        when(ingredient.getName()).thenReturn("Сырный");
        when(ingredient.getPrice()).thenReturn(3.2f);

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                ingredient.getName()));
        receipt.append(String.format("(==== %s ====)%n", bun.getName()));
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        String expectedReceipt = receipt.toString();
        String actualReceipt = burger.getReceipt();
        assertEquals("Актуальный чек бургера не совпадает с ожидаемым результатом", expectedReceipt, actualReceipt);
    }
}
