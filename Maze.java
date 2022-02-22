import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
     * Constructs a maze based on a File containing the maze as 1s and 0s (and 2s).
     * @param file  The file the maze is found in
     * @throws FileNotFoundException
     */
    public Maze(File file) throws FileNotFoundException {
            
            //Create the scanner and initialize the variables
            Scanner readFile = new Scanner(file);

            String[] dimensions = readFile.nextLine().split(",");
            baseMaze = new int[Integer.parseInt(dimensions[1])][Integer.parseInt(dimensions[0])];
            
            String[] startPos = readFile.nextLine().split(",");
            start = new Position(Integer.parseInt(startPos[0]), Integer.parseInt(startPos[1]));
            
            //Read from the File
            String[] line;
            int row = 0;
            while(readFile.hasNextLine()) {
                line = readFile.nextLine().split("");
                for (int i = 0; i < line.length; i++) {
                    baseMaze[row][i] = Integer.parseInt(line[i]);
                }
                row++;
            }

            //Copy into the 'Current' Array
            current = new int[baseMaze.length][];
            for(int i = 0; i < baseMaze.length; i++) {
                int[] arrayRow = baseMaze[i];
                int arrayRowLen = arrayRow.length;
                current[i] = new int[arrayRowLen];
                System.arraycopy(arrayRow, 0, current[i], 0, arrayRowLen);
            }

            readFile.close();
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
