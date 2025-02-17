
import java.util.Arrays;
import java.util.Random;

public class Prog14_02 {
    private int ctr;
    
    public static void main(String[] args){
        new Prog14_02(); 
    }

    public Prog14_02(){
        ctr = 0; 

        Random rnd = new Random(); 

        int[] list = {6, 0, 0, 4, 1, 2, 6, 6}; 

        printArray(list);
        Arrays.sort(list);
        printArray(list);

        int x = 9; 
        System.out.println(x + " is in the array: " + binarySearch(list, x)); 
        System.out.println("Value of counter: " + ctr);
    }

    public void printArray(int[] list){
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    public void fillArray(int[] list) {
        Random rnd = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = rnd.nextInt(10);
        }
    }

    public boolean binarySearch(int[] list, int x){
        return binarySearch(list, 0, list.length - 1, x);
    }

    public boolean binarySearch(int[] list, int first, int last, int x){
        ctr++;
        boolean found;
        
        if(first > last) return false;
        else {
            int mid = (first+last)/2; 
            if(list[mid] == x) return true;
            else if(x<list[mid]) found = binarySearch(list, first, mid-1, x);
            else found = binarySearch(list, mid+1, last, x); 
        }
        return found; 
    }
}
