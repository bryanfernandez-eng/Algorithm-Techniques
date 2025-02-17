import java.util.Arrays;
import java.util.Random;

/*
 * Implements and tests recursive binary search 
 */

public class Prog14_01 {

    public static void main(String[] args) {
        new Prog14_01();
    }

    /*
     * Tester
     */
    public Prog14_01() {
        Random rnd = new Random(); 
        int[] list = new int[10]; 
        fillArray(list);
        printArray(list);
        Arrays.sort(list);
        printArray(list);

        int x = rnd.nextInt(10); 
        System.out.println("Search for " + x + " : " + binarySearch(list, x));
    }

    /*
     * Fills given array with random numbers in [0, 9].
     */

    public void fillArray(int[] list) {
        Random rnd = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = rnd.nextInt(10);
        }
    }

    /*
     * Prints given array.
     */

    public void printArray(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    /*
     * Binary search method
     * 
     * @param list sorted array
     * 
     * @param x search element
     * 
     * @return true if x is in the list, false otherwise
     */

    public boolean binarySearch(int[] list, int x) {
        return binarySearch(list, 0, list.length - 1, x);
    }

    /*
     * Determines if search element is in
     * locations [first, last] of given array
     * 
     * @param list sorted array
     * 
     * @param first left index
     * 
     * @param last right index
     * 
     * @param x search element
     * 
     * @return true if x is in the list, false otherwise
     */

    public boolean binarySearch(int[] list, int first, int last, int x) {
        boolean found;
        if (first > last) {
            found = false;
        } else {
            int mid = (first + last) / 2;
            if (list[mid] == x)
                found = true;
            else if (list[mid] > x)
                found = binarySearch(list, first, mid - 1, x);
            else
                found = binarySearch(list, mid + 1, last, x);
        }
        return found;
    }
}