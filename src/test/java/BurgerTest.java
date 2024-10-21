import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient anotherIngredient;
    @Mock
    Bun bun;

    @Spy
    Burger burger;


    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertNotNull(burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        int actualArraySize = burger.ingredients.size();
        Assert.assertNotEquals(0, actualArraySize);
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int actualArraySize = burger.ingredients.size();
        Assert.assertEquals(0, actualArraySize);
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);
        Ingredient initialIngredientWithIndex1 = burger.ingredients.get(1);
        assertEquals(anotherIngredient, initialIngredientWithIndex1);
        burger.moveIngredient(0, 1);
        Ingredient actualIngredientWithIndex1 = burger.ingredients.get(1);
        assertEquals(ingredient, actualIngredientWithIndex1);
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(200F);
        Mockito.when(anotherIngredient.getPrice()).thenReturn(300F);
        float actualBurgerPrice = burger.getPrice();
        assertEquals(700, actualBurgerPrice, 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);
        Mockito.when(bun.getName()).thenReturn("test bun");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("test ingredient 1");
        Mockito.when(anotherIngredient.getType()).thenReturn(FILLING);
        Mockito.when(anotherIngredient.getName()).thenReturn("test ingredient 2");
        Mockito.when(burger.getPrice()).thenReturn(1000F);
        String actualReceipt = burger.getReceipt();
        String expectedReceipt = ("(==== test bun ====)\r\n" +
                "= sauce test ingredient 1 =\r\n" +
                "= filling test ingredient 2 =\r\n" +
                "(==== test bun ====)\r\n" +
                "\r\n" +
                "Price: 1000,000000" +
                "\r\n");
        assertEquals(expectedReceipt, actualReceipt);
    }

}
