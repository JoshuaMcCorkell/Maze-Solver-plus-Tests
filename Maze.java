public class Maze {
    public int[][] current;
    public Position start;
    public int[][] baseMaze;

    public Maze(int[][] data, Position startPosition) {
        baseMaze = data;
        current = data;
        start = startPosition;
    }

    public void set(int x, int y, int val) {
        current[y][x] = val;
    }
}
