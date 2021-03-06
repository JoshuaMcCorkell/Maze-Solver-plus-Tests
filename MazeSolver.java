import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;

public class MazeSolver {
    private LinkedList<Position> path = new LinkedList<>();
    private LinkedList<String> pathString = new LinkedList<>();
    private Maze maze;
    private boolean done = false;

    /**
     * Creates a new 'MazeSolver' object with the maze passed in.
     * @param toSolve  The maze to solve.
     */
    public MazeSolver(Maze toSolve) {
        maze = toSolve;
        path.push(maze.start);
        pathString.push("Starting at: " + maze.start);
    }

    /**This just defines what happens once the maze is solved. */
    private void win() {
        pathString.add("Path found! Position is: " + path.peek());
        done = true;
    }

    /**
     * Attemps to 'move' to the location defined by newPosition
     * 
     * If successful, returns true, adds the position to the 'path' stack, and prints the movement to the console.
     * @param directionString  This is a string that describes the movement, e.g. "West".
     * @param newPosition  The position to attempt to move to.
     * @return  Returns false if move was unsuccessful, and true if move was successful. If a win occurs, calls the win() method.
     */
    private boolean move(String directionString, Position newPosition) {
        if (maze.get(newPosition) == 2) {
            path.push(newPosition);
            win();
            return true;
        } else if (maze.get(newPosition) == 1 && !path.contains(newPosition)) {
            path.push(newPosition);  
            pathString.add("Moved " + directionString + ". Postition now: " + path.peek());
            return true;
        } 
        return false;
    }

    /**Solves the current maze, outputting it's progress to the console.
     * 
     * <strong>This method will change the base maze.</strong>
     */
    public boolean solve() {
        Position next;

        //Main Loop that solves the maze.
        while (true) {
            if (done) {
                return true;
            }
            //down
            next = new Position(path.peek().x, path.peek().y + 1);
            if (move("South", next)) {
                continue;
            }

            //left
            next = new Position(path.peek().x - 1, path.peek().y);
            if (move("West", next)) {
                continue;
            }

            //up
            next = new Position(path.peek().x, path.peek().y - 1);
            if (move("North", next)) {
                continue;
            }

            //right
            next = new Position(path.peek().x + 1, path.peek().y);
            if (move("East", next)) {
                continue;
            }

            //dead end
            maze.set(path.pop(), -1);
            pathString.removeLast();
            if(path.isEmpty()) {
                //No Path
                return false;
            }
        }
    }

    /**Prints the path the solver took to the console. */
    public void printPath() {
        for(String s : pathString) {
            System.out.println(s);
            
        }
        System.out.println("Length of path: " + path.size() + " steps");
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Maze myMaze = new Maze(new File("Maze1.txt"));
        MazeSolver solver = new MazeSolver(myMaze);
        if (solver.solve()) {
            solver.printPath();
        } else {
            System.out.println("No Path Found...");
        }   
    }
}