public class Position {
    public int x;
    public int y;

    /**
     * Creates a new Position object.
     * @param xPos X position
     * @param yPos Y position
     */
    public Position(int xPos, int yPos) {
        x = xPos;
        y = yPos;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position other = (Position) o;
        if (other.x == x && other.y == y) {
            return true;
        } else {
            return false;
        }
    }
}
