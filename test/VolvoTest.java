import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.*;
import java.awt.*;

public class VolvoTest {
    private Volvo240 volvo;
   

    @Before
    public void setup() {
        volvo = new Volvo240();
        
    }

    @After
    public void stop_the_volvo_after_test() {
        volvo.stopEngine();
    }

    @Test
    public void is_volvo_name_set() {
        assertEquals(volvo.getModelName(), "Volvo240");
    }

    
    @Test
    public void is_engine_power_correct() {
        assertEquals(volvo.getEnginePower(), 100.0, 0.0);
    }

    @Test
    public void is_color_of_volvo_correct() {
        assertEquals(volvo.getColor(), Color.black);
    }

    @Test
    public void does_trimfactor_boost_speed() {
        volvo.gas(1);
        double expected = (volvo.getEnginePower() * 0.01 * volvo.getTrimFactor());
        assertEquals(expected, volvo.getCurrentSpeed(), 0.0);

    }

}
