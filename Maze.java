import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
    public int[][] current;
    public Position start;

    /**
     * Constructs a maze based on a 2-dimensional array.
     * @param data  A 2-dimensional array with 1 = Path, 0 = Wall, 2 = Destination.
     * @param startPosition  A Position object telling the maze where the player starts. (0,0) is top left corner.
     */
    public Maze(int[][] data, Position startPosition) {
        //Copy into the 'baseMaze' Array
        current = new int[data.length][];
        for(int i = 0; i < data.length; i++) {
            int[] arrayRow = data[i];
            int arrayRowLen = arrayRow.length;
            current[i] = new int[arrayRowLen];
            System.arraycopy(arrayRow, 0, current[i], 0, arrayRowLen);
        }
        start = startPosition;
    }

    /**
     * Constructs a maze based on a File containing the maze data.
     * <ul>
     * <li><strong>First line of File:</strong> x,y The dimensions of the maze. <em>Must be rectangular</em></li>
     * <li><strong>Second line of File:</strong> x,y The starting position of the maze. <em>0,0 is top left corner</em></li>
     * <li><strong>Rest of File:</strong> The data for the maze. <em>1 = Path, 0 = Wall, 2 = Destination</em></li>
     * </ul>
     * @param file  A file object with the file to construct the maze from.
     * @throws FileNotFoundException
     */
    public Maze(File file) throws FileNotFoundException {
            //Create the scanner and initialize the variables
            Scanner readFile = new Scanner(file);

            String[] dimensionsString = readFile.nextLine().split(",");
            int[] dimensions = {Integer.parseInt(dimensionsString[0]), Integer.parseInt(dimensionsString[1])};

            current = new int[dimensions[1]][dimensions[0]];
            
            String[] startPos = readFile.nextLine().split(",");
            start = new Position(Integer.parseInt(startPos[0]), Integer.parseInt(startPos[1]));
            
            //Read from the File
            try{
                String[] line;
                for (int i = 0; i < dimensions[1]; i++) {
                    line = readFile.nextLine().split("");
                    for (int j = 0; j < dimensions[0]; j++) {
                        current[i][j] = Integer.parseInt(line[j]);
                    }
                }
            } catch(java.util.NoSuchElementException e) {
                System.out.println("File was not formatted correctly! There are probably not enough rows in the maze to match the dimensions given.");
                readFile.close();
                throw e;
            } catch(java.lang.ArrayIndexOutOfBoundsException e) {
                System.out.println("File was not formatted correctly! There are probably not enough blocks (numbers) in one of the rows of the maze to match the dimensions given.");
                readFile.close();
                throw e;
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
     * 
     * Returns -2 if position is out of bounds.
     * @param pos  The position of the value you want to return.
     * @return The value of the block pointed to by 'pos'.
     */
    public int get(Position pos) {
        if(pos.y < 0 || pos.x < 0 || pos.y >= current.length || pos.x >= current[pos.y].length ) {
            return -2;
        }
        return current[pos.y][pos.x];
    }
} //4:00:00