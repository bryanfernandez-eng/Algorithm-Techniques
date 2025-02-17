import java.math.BigInteger;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This program, Assignment 1, compares the performance of deterministic and
 * randomized algorithms for primality testing.
 * It tests a sequence of large integers (BigIntegers) for primality using both
 * approaches and records the time taken for each test.
 * This process runs for one hour, and the results are written to a CSV file.
 * 
 * @author Bryan Alexander Fernandez
 * @section COP4534 U01 1251
 * @PID 6507363
 */
public class Assignment_1 {

    // BigInteger Constant values
    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = BigInteger.TWO;
    private static final BigInteger THREE = BigInteger.valueOf(3);
    private static final Random RANDOM = new Random();

    /**
     * It creates an instance of the Assignment_1 class, initiating the primality
     * testing process.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        new Assignment_1();
    }

    /**
     * Constructs an instance of Assignment_1 and begins the primality testing
     * process. Generates a sequence of large integers, tests their primality using
     * both deterministic and randomized methods, and records the results in a CSV
     * file.
     */
    public Assignment_1() {
        String outputFileName = "output.csv";
        PrintWriter output = null;

        try {
            output = new PrintWriter(new FileWriter(outputFileName));
            output.println("Value, Time of DA, Prime? (According to DA), Time of RA, Prime? (According to RA)");
        } catch (IOException e) {
            System.exit(1);
        }

        BigInteger FIRST = new BigInteger("10000000000000819");
        BigInteger current = FIRST;

        long startTime = System.currentTimeMillis();
        long duration = 60 * 60 * 1_000; // 1 hour in milliseconds

        // Run the loop for exactly one hour (60 minutes * 60 seconds * 1000
        // milliseconds).
        for (; System.currentTimeMillis() - startTime <= duration; current = current.add(ONE)) {
            // Deterministic Algorithm
            long startingTimeDeterministic = System.nanoTime();
            boolean isPrimeDeterministicResult = isPrimeDeterministic(current);
            long elapsedTimeDeterministic = System.nanoTime() - startingTimeDeterministic;
            String isPrimeDeterministic = isPrimeDeterministicResult ? "YES" : "NO";

            // Randomized Algorithm
            long startingTimeRandomized = System.nanoTime();
            boolean isPrimeRandomizedResult = isPrimeRandomized(current, 10);
            long elapsedTimeRandomized = System.nanoTime() - startingTimeRandomized;
            String isPrimeRandomized = isPrimeRandomizedResult ? "YES" : "NO";

            output.println(current + "," + elapsedTimeDeterministic + "," + isPrimeDeterministic + ","
                    + elapsedTimeRandomized + "," + isPrimeRandomized);

            System.out.println(current + "," + elapsedTimeDeterministic + "," + isPrimeDeterministic + ","
                    + elapsedTimeRandomized + "," + isPrimeRandomized);
        }

        output.close();
    }

    /*
     * Determines if a given integer is prime.
     * This function originates from Prog15_05. It was modified marginally.
     * 
     * @param n given integer; n must be greater than or equal 1
     * 
     * @return true if n is prime, false otherwise
     * 
     * @author Antonio Hernandez
     */
    public boolean isPrimeDeterministic(BigInteger num) {
        if (num.compareTo(ONE) <= 0)
            return false;
        if (num.equals(TWO))
            return true;
        if (num.mod(TWO).equals(ZERO))
            return false; // Even numbers greater than 2 are not prime
        BigInteger s = num.sqrt();

        for (BigInteger i = THREE; i.compareTo(s) <= 0; i = i.add(TWO))
            if (num.mod(i).equals(ZERO))
                return false;

        return true;
    }

    /**
     * Determines whether a given BigInteger is prime using a randomized approach
     * 
     * @param num        The number to be tested for primality
     * @param iterations The number of iterations to increase accuracy
     * @return true if the number is likely prime, false otherwise
     */
    public boolean isPrimeRandomized(BigInteger n, int iterations) {
        if (n.compareTo(BigInteger.ONE) <= 0)
            return false;
        if (n.equals(BigInteger.TWO))
            return true; // 2 is prime

        for (int i = 0; i < iterations; i++) {
            // Generate random base a in range [2, n-2]
            BigInteger a = getRandomBase(n);

            // Compute a^(n-1) % n
            if (!a.modPow(n.subtract(BigInteger.ONE), n).equals(BigInteger.ONE))
                return false; // Composite found
        }
        return true;
    }

    /*
     * Generates a random base a in the range [2, n-2]
     * 
     * @param n The number n to be tested for primality
     */
    private BigInteger getRandomBase(BigInteger n) {
        BigInteger min = BigInteger.TWO;
        BigInteger max = n.subtract(BigInteger.TWO);
        return new BigInteger(max.bitLength(), RANDOM).mod(max.subtract(min).add(BigInteger.ONE)).add(min);
    }
}
