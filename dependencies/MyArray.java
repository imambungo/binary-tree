package dependencies;

import java.util.Random;

public class MyArray {
    public int[] randomArray(int length) {
        Random rand = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = rand.nextInt(10 * length) + 1;
        }
        return arr;
    }

    public void printArray(int[] toPrint) {
        for (int i:toPrint) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}