
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Illustrates use of Random utilities.
 * 
 */
public class Prog15_01
{
    public static void main(String[] args)
    {
        new Prog15_01();
    }
    
    public Prog15_01()
    {
        Random rnd = new Random();
        
        int[] list = new int[20];
        
        fillArrayUniformDistribution(list);
        Arrays.sort(list);
        printArray(list);
        
        fillArrayNormalDistribution(list);
        Arrays.sort(list);
        printArray(list);

        fillArrayWithOsAnd1s(list, 50);
        Arrays.sort(list);
        printArray(list);

        fillArrayWithOsAnd1s(list, 80);
        Arrays.sort(list);
        printArray(list);
        
        list = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffleArray(list);
        printArray(list);
    }
    
    /**
     * Fills input array with random integers in [0, 100] using a 
     * uniform distribution.
     */
    public void fillArrayUniformDistribution(int[] list)
    {
        Random rnd = new Random();
        for(int i=0; i<list.length; i++)
        {
            list[i] = rnd.nextInt(100);
        }
    }

    /**
     * Fills input array with random integers in [-infty, +infty] using a 
     * normal distribution.
     */
    public void fillArrayNormalDistribution(int[] list)
    {
        Random rnd = new Random();
        for(int i=0; i<list.length; i++)
        {
            list[i] = (int)Math.round(rnd.nextGaussian()*10);
        }
    }
    
    public void printArray(int[] list)
    {
        for(int i=0; i<list.length; i++)
        {
            System.out.print(list[i] + " ");
        }
        
        System.out.println();
    }
    
    /**
     * Fills input array with integers in [0, 1] with approximately x% of 0's.
     */
    public void fillArrayWithOsAnd1s(int[] list, int x)
    {
        Random rnd = new Random();
        for(int i=0; i<list.length; i++)
        {
            if (rnd.nextInt(100) <= x)
                list[i] = 0;
            else
                list[i] = 1;
        }
    }    
    
    /**
     * Randomly rearrange the input array.
     */
    public void shuffleArray(int[] list)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i:list)
        {
            temp.add(i);
        }
        
        Collections.shuffle(temp);
        
        for(int i=0; i<list.length; i++)
        {
            list[i] = temp.get(i);
        }
    }
}
