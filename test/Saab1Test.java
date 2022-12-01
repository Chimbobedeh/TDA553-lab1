import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.*;
import java.awt.*;

public class Saab1Test {
    
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
    public void is_Nr_Doors_set() {
        assertEquals(saab.getNrDoors(), 4);
    }

    @Test
    public void is_engine_power_correct() {
        assertEquals(125.0, saab.getEnginePower(), 0.0);
    }

    @Test
    public void is_color_of_saab_correct() {
        assertEquals(saab.getColor(), Color.red);
    }

    @Test
    public void can_we_set_new_color_on_saab() {
        saab.setColor(Color.blue);
        assertEquals(saab.getColor(), Color.blue);
    }

    @Test
    public void is_saab_engine_started() {
        saab.startEngine();
        assertEquals(saab.getCurrentSpeed(), 0.1, 0.0);
    }

    @Test
    public void is_saab_engine_stopped() {
        saab.stopEngine();
        assertEquals(saab.getCurrentSpeed(), 0.0, 0.0);
    }

    @Test
    public void is_brake_set_and_decreases_speed() {
        saab.startEngine();
        saab.brake(1.0);
        assertEquals(saab.getCurrentSpeed(), 0.0, 0.0);
    }

    @Test
    public void gas_not_work_outside_interval() {
        saab.startEngine();
        assertThrows(IllegalArgumentException.class, () -> {
            saab.gas(5.0);
        });
    }

    @Test
    public void break_not_work_outside_interval() {
        saab.startEngine();
        assertThrows(IllegalArgumentException.class, () -> {
            saab.brake(5.0);
        });
    }

    @Test
    public void is_gas_set_and_increases_speed() {
        saab.startEngine();
        saab.gas(1.0);
        assertEquals(1.35, saab.getCurrentSpeed(), 0);
    }

    @Test
    public void testTurnLeft() {
        saab.turnLeft();
        assertEquals(saab.getDirection(), Direction.WEST);
        saab.turnLeft();
        assertEquals(saab.getDirection(), Direction.SOUTH);
        saab.turnLeft();
        assertEquals(saab.getDirection(), Direction.EAST);
        saab.turnLeft();
        assertEquals(saab.getDirection(), Direction.NORTH);
    }

    @Test
    public void testTurnRight() {
        saab.turnRight();
        assertEquals(saab.getDirection(), Direction.EAST);
        saab.turnRight();
        assertEquals(saab.getDirection(), Direction.SOUTH);
        saab.turnRight();
        assertEquals(saab.getDirection(), Direction.WEST);
        saab.turnRight();
        assertEquals(saab.getDirection(), Direction.NORTH);
    }

    @Test // TODOOOOOOO
    public void testMovement() {
        saab.startEngine();
        saab.turnRight();
        saab.move();
        assertEquals(saab.getPosition(), new Position(0.1, 0, Direction.EAST));
        saab.turnRight();
        saab.move();
        assertEquals(saab.getPosition(), new Position(0.1, -0.1, Direction.SOUTH));
        saab.turnRight();
        saab.move();
        assertEquals(saab.getPosition(), new Position(0, -0.1, Direction.WEST));
        saab.turnRight();
        saab.move();
        assertEquals(saab.getPosition(), new Position(0, 0, Direction.NORTH));
    }

    @Test
    public void is_turbo_on_for_saab() {
        saab.setTurboOn();
        assertTrue(saab.getTurbo());
    }

    @Test
    public void is_turbo_off_for_saab() {
        saab.setTurboOff();
        assertTrue(!saab.getTurbo());
    }

    @Test
    public void is_speedfactor_for_saab_correct() {
        saab.setTurboOn();
        double expected = saab.getEnginePower() * 0.01 * 1.3;
        assertEquals(expected, saab.speedFactor(), 0.0);
    }

    @Test
    public void brake_does_not_increase_speed() {
        saab.startEngine();
        assertThrows(IllegalArgumentException.class, () -> {
            saab.brake(-1);
        });
    }

    @Test
    public void gas_does_not_decrease_speed() {
        saab.startEngine();
        assertThrows(IllegalArgumentException.class, () -> {
            saab.gas(-1);
        });
    }

    @Test
    public void speed_cannot_exceed_engine_power() {
        double maxPower = saab.getEnginePower();
        for (int i = 0; i < (int) maxPower + 5; i++) {
            saab.gas(1.0);
        }
        assertEquals(saab.getCurrentSpeed(), saab.getEnginePower(), 0.0);
    }

    @Test
    public void speed_does_not_go_below_zero() {
        saab.startEngine();
        for (int i = 0; i <= (int) saab.getCurrentSpeed() + 5; i++) {
            saab.brake(1);
        }
    }

}
