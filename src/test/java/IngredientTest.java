import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private final IngredientType expectedIngredientType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientTest(IngredientType type, String name, float price, IngredientType expectedIngredientType, String expectedName, float expectedPrice) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.expectedIngredientType = expectedIngredientType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredient() {
        return new Object[][] {
                {IngredientType.FILLING, "ingredientWithFilling", 100, IngredientType.FILLING, "ingredientWithFilling", 100},
                {IngredientType.SAUCE, "ingredientWithFilling", 50, IngredientType.SAUCE, "ingredientWithFilling", 50},
        };
    }

    @Test
    public void ingredientCreateTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(expectedIngredientType, ingredient.getType());
        assertEquals(expectedName, ingredient.getName());
        assertEquals(expectedPrice, ingredient.getPrice(), 0);
    }
}
