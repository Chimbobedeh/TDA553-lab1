import static java.lang.System.out;
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        int a;
        a = Math.floorMod(-1, 4);
        out.println(a);
        Car volvo = new Volvo240();
        volvo.startEngine();
        volvo.turnLeft();
        volvo.move();
        Position pos = volvo.getPosition();
        out.println(pos.getX());
        out.println(pos.getY());
    }
}