import java.util.Scanner;

public class VideoTesting1{

    static String x = "This is a Property!";
    static int y = 100;

    public static int square(int num) {
        return num * num;
    }

    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);

        System.out.print("What is your name: ");
        String name = consoleIn.nextLine();

        if (name.equals("Joshua")) {
            System.out.println("Hello Joshua!");
        }
        else {
            System.out.println("You are NOT welcome, " + name + "!"); 
            consoleIn.close(); 
            return;
        }

        int i = 0;
        while (i < 5) {
            System.out.println("i = " + i);
            i++;
        }

        for (i = 0; i < 5; i++) {
            System.out.println("i = " + i);
        }

        i = 0;
        do {
            System.out.println("i = " + i);
            i++;
        } while(i < 5);
        
        consoleIn.close();
    }
}
//37:30  (1:26:53)