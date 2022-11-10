/*
enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT
}
*/

public class Position {
// x represents movement in x-plane and y represents movement in the y-plane
    private int x, y;
    private int direction;
    private int[] directions = {0, 1, 2, 3};

    Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.direction = 0;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
	    this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void incrementDirection() {
        this.direction += 1;
        this.direction %= 4;
    }

    public void decrementDirection() {
        this.direction += 1;
        this.direction %= 4;
    }

    public void move(double factor) {
        // if direction is neråt  --> y-= factor
        // if direction is uppåt --> y += factor
        // if direction is höger --> x += factor
        // if direction is vänster --> x -= factor

        // turnRight --> this.direction = Direction.RIGHT
        // turnLeft --> this.direction = Direction.LEFT
        // Should we %= 4 here?
        switch (this.direction) {
            case 0:
                // UP
                y += factor;
            case 1:
                // RIGHT
                x += factor;
            case 2:
                // DOWN
                y -= factor;
            case 3:
                // LEFT
                x -= factor;
        }
        /*
        if (y < 0){
          this.y -= factor;
          this.x -= factor

        }
        else if(y => 0){
            this.y += factor;
            this.x += factor;
        }
        this.x += factor;
        this.y += factor;
        */
    }
    
    public void setXNegagtive() {
        // if X is positive, negate it
        if (this.x > 0) {
            this.x *=  -1;
        }
    }
    
    public void setXPositive() {
        // if X is negative, negate it
        if (this.x < 0) {
            this.x = -this.x;
        }
        this.x += 0;
    }
}