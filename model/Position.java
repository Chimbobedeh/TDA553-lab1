public class Position {
    private Double x, y;
    private Direction direction;

    Position(Double x, Double y) {
        this.x = x;
        this.y = y;
        this.direction = Direction.NORTH;
    }

    Position(double x, double y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public String toString() {
        return String.format("%s, %s", getX(), getY());
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceTo(Position other) {
        double distance = Math.abs(x - other.getX()) + Math.abs(y - other.getY());
        return distance;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setX(double newX) {
        x = newX;
    }

    public void setY(double newY) {
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
        result = prime * result + ((x == null) ? 0 : x.hashCode());
        result = prime * result + ((y == null) ? 0 : y.hashCode());
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
        if (x == null) {
            if (other.x != null)
                return false;
        } else if (!x.equals(other.x))
            return false;
        if (y == null) {
            if (other.y != null)
                return false;
        } else if (!y.equals(other.y))
            return false;
        if (direction != other.direction)
            return false;
        return true;
    }
}