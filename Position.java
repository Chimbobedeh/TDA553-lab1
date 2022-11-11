public class Position {
    private int x, y;
    private Direction direction;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.direction = Direction.NORTH;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setX(int x) {
	    this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(Direction d) {
        this.direction = d;
    }

    public void incrementDirection() {
        this.direction = this.direction.increment();
    }

    public void decrementDirection() {
        this.direction = this.direction.decrement();
    }

    public void move(double factor) {
        switch (this.direction) {
            case NORTH:
                this.y += factor;
                break;
            case EAST:
                x += factor;
                break;
            case SOUTH:
                y -= factor;
                break;
            case WEST:
                x -= factor;
                break;
        }
    }
}