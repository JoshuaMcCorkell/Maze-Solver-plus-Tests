package Tests;
class MultiDimensionalArraysTest {
    public static void main(String[] args) {
        int[] [] data = {
            {4, 5, 8, 2},
            {10, 6, 2, -7},
            {1, 7, 3, 9}
        };

        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }

        //This seems more logical... :
        System.out.println();
        for(int[] i : data) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}

//2:38:05