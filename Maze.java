public class Maze {
    public int[][] current;
    public Position start;
    public int[][] baseMaze;

    /**
     * Constructs a maze based on a 2-dimensional array.
     * @param data  A 2-dimensional array with 1 = Path, 0 = Wall, 2 = Destination.
     * @param startPosition  A Position object telling the maze where the player starts. (0,0) is top left corner.
     */
    public Maze(int[][] data, Position startPosition) {
        baseMaze = data;
        current = data;
        start = startPosition;
    }

    /**
     * Changes one block in the 'Current' maze data. (Does not change base maze)
     * @param pos  The position of the block to change.
     * @param val  The value to change it to.
     */
    public void set(Position pos, int val) {
        current[pos.y][pos.x] = val;
    }

    /**
     * Returns the value in the 'Current' maze data.
     * @param pos  The position of the value you want to return.
     * @return The value of the block pointed to by 'pos'.
     */
    public int get(Position pos) {
        try {
            return current[pos.y][pos.x];
        } catch (Exception e) {
            //Nothing at the moment
            return -2;
        }
        
    }

    /**
     * Returns the value in the Initial Maze (baseMaze) maze data.
     * @param pos  The position of the value you want to return.
     * @return The value of the block pointed to by 'pos'.
     */
    public int getBase(Position pos) {
        return baseMaze[pos.y][pos.x];
    }
}
