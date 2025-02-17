import java.util.Arrays;
import java.util.Random;

public class Prog14_02_01 {
    private int ctr;
    
    public static void main(String[] args){
        new Prog14_02_01(); 
    }

    public Prog14_02_01() {
        int size = 1000; // You can increase the size if you need

        for (int i = 1; i <= size; i++) { // Loop from 1 to size
            ctr = 0;  // Reset counter for each test
            int[] list = new int[i];
            fillArray(list);
            Arrays.sort(list);
            int x = list[list.length - 1] + 1; // Search for the largest element
            binarySearch(list, x);
            System.out.println(i + " " + ctr);
        }
    }

    public void fillArray(int[] list) {
        Random rnd = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = rnd.nextInt(list.length); // Generate random values between 0 and list.length-1
        }
    }

    public boolean binarySearch(int[] list, int x) {
        return binarySearch(list, 0, list.length - 1, x);
    }

    public boolean binarySearch(int[] list, int first, int last, int x) {
        ctr++;
        boolean found;
        
        if (first > last) return false;
        else {
            int mid = (first + last) / 2; 
            if (list[mid] == x) return true;
            else if (x < list[mid]) found = binarySearch(list, first, mid - 1, x);
            else found = binarySearch(list, mid + 1, last, x); 
        }
        return found; 
    }
}
