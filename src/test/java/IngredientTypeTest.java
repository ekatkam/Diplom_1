import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final String type;

    public IngredientTypeTest(String type) {
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] ingredientTypeData() {
        return new Object[][] {
                {"SAUCE"},
                {"FILLING"},
        };
    }

    @Test
    public void ingredientTypeTest() {
        assertThat(IngredientType.valueOf(type), is(notNullValue()));
    }
}
