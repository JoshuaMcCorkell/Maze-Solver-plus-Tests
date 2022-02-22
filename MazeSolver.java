import java.util.LinkedList;

public class MazeSolver {

    static void win() {
        System.out.println("We Win!! Position is: " + path.peek());
        System.exit(0);
    }

    static int[][] myMaze = {
        {2, 1, 1, 0, 0, 1, 1, 1},
        {1, 1, 1, 1, 1, 0, 1, 1},
        {0, 0, 0, 0, 1, 0, 0, 1},
        {0, 1, 1, 1, 1, 0, 1, 1},
        {0, 1, 0, 0, 0, 0, 1, 0},
        {0, 1, 1, 1, 1, 1, 1, 0}
    };

    // A 'Stack' containing the current path (made up of (x, y) positions)
    static LinkedList<Position> path = new LinkedList<>();

    public static void main(String[] args) {
        Maze maze = new Maze(myMaze, new Position(5, 0));
        path.push(maze.start);
        Position next;

        while (true) {
            //down
            next = new Position(path.peek().x, path.peek().y + 1);
            if (maze.get(next) == 2) {
                path.push(next);
                win();
                break; //This code is never reached, it just suppresses the error.
            } else if (maze.get(next) == 1 && !path.contains(next)) {
                path.push(next);  
                System.out.println("Moved down. Postition now: " + path.peek());
                continue;
            }

            //left
            next = new Position(path.peek().x - 1, path.peek().y);
            if (maze.get(next) == 2) {
                path.push(next);
                win();
            } else if (maze.get(next) == 1 && !path.contains(next)) {
                path.push(next);  
                System.out.println("Moved left. Postition now: " + path.peek());
                continue;
            }

            //up
            next = new Position(path.peek().x, path.peek().y - 1);
            if (maze.get(next) == 2) {
                path.push(next);
                win();
            } else if (maze.get(next) == 1 && !path.contains(next)) {
                path.push(next);  
                System.out.println("Moved up. Postition now: " + path.peek());
                continue;
            }

            //right
            next = new Position(path.peek().x + 1, path.peek().y);
            if (maze.get(next) == 2) {
                path.push(next);
                win();
            } else if (maze.get(next) == 1 && !path.contains(next)) {
                path.push(next);  
                System.out.println("Moved right. Postition now: " + path.peek());
                continue;
            }
        }
        
    }
}
//2:56:00
