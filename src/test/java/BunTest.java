import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;
    private String expectedName = "Белая с кунжутом";
    private float expectedPrice = 30.5f;

    @Before
    public void setUp() {
        bun = new Bun("Белая с кунжутом", 30.5f);
    }

    @Test
    public void checkNameBunTest() {
        String actualName = bun.getName();
        assertEquals("Актуальное название булочки не совпадает с ожидаемым результатом", expectedName, actualName);
    }

    @Test
    public void checkPriceBunTest(){
        float actualPrice = bun.getPrice();
        assertEquals("Актуальная цена булочки не совпадает с ожидаемым результатом", expectedPrice, actualPrice, 0);
    }
}
