import java.util.Arrays;
import java.util.Random;

/*
 * Determines how many times a given value x occurs in a sorted array. Based 
 * on recursive binary search. O(log n)
 * 
 * @author Prof. Hernandez
 */

public class Prog14_03 {
    public int LocateLeftEnd(int[] list, int first, int last, int x) {
        int loc;
        if (first > last)
            loc = first;
        else {
            int mid = (first + last) / 2;
            System.out.println(mid + ", ");
            if (x <= list[mid])
                loc = LocateLeftEnd(list, first, mid-1, x);
            else
                loc = LocateLeftEnd(list, mid + 1, last, x);
        }
        return loc;
    }

    private int locateRightEnd(int[] list, int first, int last, int x){
        int loc; 
        if (first > last) loc = last; 
        else {
            int mid = (first + last) / 2; 
            if (x >= list[mid]) loc = locateRightEnd(list, mid+1, last, x); 
            else loc = locateRightEnd(list, first, mid-1, x); 
        }
        return loc;
    }

}