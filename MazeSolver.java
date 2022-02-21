import java.util.LinkedList;

public class MazeSolver {

    //The current Maze
    //0 = Wall
    //1 = Path
    //2 = Destination
    static int[][] maze = {
        {2, 0, 1, 1},
        {1, 1, 0, 1},
        {0, 1, 1, 1}
    };

    // A 'Stack' containing the current path (made up of (x, y) positions)
    static LinkedList<Position> path = new LinkedList<>();

    public static void main(String[] args) {
        Position p = new Position(3, 0);
        path.push(p);

        maze[path.peek().y][path.peek().x] = 0;
        System.out.print(maze[0][3]);
    }
}
