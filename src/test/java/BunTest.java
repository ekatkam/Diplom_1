import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {



    @Test
    public void bunCreateTest() {
        Bun bun = new Bun("test bun", 100);
        assertEquals("test bun", bun.getName());
        assertEquals(100, bun.getPrice(), 0);
    }
}
