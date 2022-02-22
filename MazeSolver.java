import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

public class MazeSolver {

    /**This just defines what happens once the game is won. */
    static void win() {
        System.out.println("We Win!! Position is: " + path.peek());
        System.exit(0);
    }

    // A 'Stack' containing the current path (made up of (x, y) positions)
    static LinkedList<Position> path = new LinkedList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Maze maze = new Maze(new File("Maze1.txt"));
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

            maze.set(path.pop(), 0);
            System.out.println("Dead end! Backtracking to: " + path.peek());
            if(path.isEmpty()) {
                System.out.println("***No Path Found***");
                System.exit(0);
            }
        }
    }
}