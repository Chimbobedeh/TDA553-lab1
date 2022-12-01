import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import org.junit.*;
import java.awt.*;

public class SaabTest {
    private Saab95 saab;
   
    @Before
    public void setup() {
        saab = new Saab95();
    }

    @After
    public void stop_the_saab_after_test() {
        saab.stopEngine();
    }

    @Test
    public void is_saab_name_set() {
        assertEquals(saab.getModelName(), "Saab95");
    }

    @Test
    public void is_engine_power_correct() {
        assertEquals(saab.getEnginePower(), 125.0, 0.0);
    }

    @Test
    public void is_color_of_saab_correct() {
        assertEquals(saab.getColor(), Color.red);
    }

    @Test
    public void does_turbo_turn_off() {
        saab.setTurboOn(); // need to turn it on first.
        saab.setTurboOff();
        assertTrue(!saab.getTurbo());
    }

    @Test
    public void does_the_turbo_turn_on() {
        saab.setTurboOn();
        assertTrue(saab.getTurbo());   

    }

}
