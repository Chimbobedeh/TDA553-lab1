
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.*;

public class CarRepairShopTest {

    private CarRepairShop repairShop;
    private Saab95 saab;
    private Saab95 saab1;
    private Saab95 saab2;
    private Saab95 saab3;
    private Saab95 saab4;
    private Saab95 saab5;

    @Before
    public void setup() {
        repairShop = new CarRepairShop();
        saab = new Saab95();
        saab1 = new Saab95();        
        saab2 = new Saab95();
        saab3 = new Saab95();
        saab4 = new Saab95();
        saab5 = new Saab95();
        saab.stopEngine();

    }

    @After
    public void after_test() {
       
    }

    // Test methods to lower/raise the Platform.
    // The angle of the platform can not be lower than 0o or higher than 70o
    // If the platform has an angle other than 0o then the truck must be stationary
    // The platform must not be raised if the truck is in motion
    // The truck must not be able to drive if the platform is raised.

    
    // test_load_car, test_unload_car
    // cannot_unload_not_loaded_car
    // storage_cannot_exceed_maximumCapacity
    // can_only_unload_if_last_in_line
    @Test
    public void test_load_car() {
        // TODO
        saab.startEngine();
        saab.gas(1);
        saab.move();
        repairShop.loadCar(saab);        
        assertTrue(repairShop.getLoadedCars().size() == 1);
        // && transporter.isLoaded(saab) <--?

    }

    @Test
    public void test_unload_car() {
        // TODO
        saab.startEngine();
        saab.gas(0.9);
        saab.move();
        repairShop.loadCar(saab);
        repairShop.unloadCar(saab);

        assertTrue(repairShop.getLoadedCars().size() == 0);
    }

    @Test
    public void storage_cannot_exceed_maximumCapacity() {
        repairShop.loadCar(saab);
        repairShop.loadCar(saab1);
        repairShop.loadCar(saab2);
        repairShop.loadCar(saab3);
        repairShop.loadCar(saab4);
        repairShop.loadCar(saab5);
        assertEquals(6, repairShop.getLoadedCars().size());
    }
    
    @Test
    public void is_transporter_loaded_with_car() {
        repairShop.loadCar(saab);
        assertTrue(repairShop.isLoaded(saab));
    }

    @Test
    public void test_unload_cars_position() {
        saab.startEngine();
        saab.gas(0.9);
        saab.move();
        repairShop.loadCar(saab);
        repairShop.unloadCar(saab);
        assertEquals(repairShop.getPosition().distanceTo(saab.getPosition()), 2.0,1.0);
    }
}
