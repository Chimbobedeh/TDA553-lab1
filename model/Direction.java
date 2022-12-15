import java.lang.Math;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction increment() {
        int length = Direction.values().length;
        int ordinal = Math.floorMod(this.ordinal() + 1, length);
        return Direction.values()[ordinal];
    }

    public Direction decrement() {
        int length = Direction.values().length;
        int ordinal = Math.floorMod(this.ordinal() - 1, length);
        return Direction.values()[ordinal];
    }
}