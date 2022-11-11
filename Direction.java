import java.lang.Math;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction increment() {
        int ordinal = Math.floorMod(this.ordinal() + 1, 4);
        return Direction.values()[ordinal];
    }

    public Direction decrement() {
        int ordinal = Math.floorMod(this.ordinal() - 1, 4);
        return Direction.values()[ordinal];
    }
}