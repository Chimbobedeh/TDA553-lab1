import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        Car volvo = new Volvo240();
        volvo.startEngine();
        volvo.turnLeft();
        volvo.turnLeft();
        volvo.move();
        Position pos = volvo.getPosition();
        out.println(pos.getX());
        out.println(pos.getY());
    }
}