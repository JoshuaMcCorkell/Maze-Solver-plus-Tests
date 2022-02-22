package Tests;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class InputOutputTest{

    public static void gradesInOut() {
        Scanner consoleIn = new Scanner(System.in);
        System.out.print("How many grades do you want to input: ");
        int size = consoleIn.nextInt();
        int[] grades = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("#" + String.valueOf(i + 1) + ": ");
            grades[i] = consoleIn.nextInt();
        }

        for (int i = 0; i < size; i++) {
            System.out.print(grades[i] + "  ");
        }

        consoleIn.close();
    }

    public static void readFileData() throws FileNotFoundException {
        Scanner readFile = new Scanner(new File("Students.txt"));
        
        List<String> students = new ArrayList<>();
        
        while (readFile.hasNextLine()) {
            students.add(readFile.nextLine());
        }

        for (String studentName : students){
            System.out.println("Name: " + studentName);
        }

        readFile.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        gradesInOut();
        readFileData();
    }
}