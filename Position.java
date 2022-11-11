public class Position {
    private int x, y;
    private Direction direction;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.direction = Direction.NORTH;
    }

    Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setX(int newX) {
	    x = newX;
    }

    public void setY(int newY) {
        y = newY;
    }

    public void setDirection(Direction d) {
        direction = d;
    }

    public void incrementDirection() {
        direction = direction.increment();
    }

    public void decrementDirection() {
        direction = direction.decrement();
    }

    public void move(double factor) {
        switch (direction) {
            case NORTH:
                y += factor;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        result = prime * result + ((direction == null) ? 0 : direction.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position other = (Position) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        if (direction != other.direction)
            return false;
        return true;
    }
    
}