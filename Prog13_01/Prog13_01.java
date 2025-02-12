import java.util.Scanner;

/**
 * Tests finding the area of a triangle using Heron's formula.
 * 
 * @author Prof. Hernandez
 */
public class Prog13_01
{
    public static void main(String[] args)
    {
        new Prog13_01();
    }
    
    /**
     * Calculates distance between points (px, py) and (qx, qy).
     * 
     * @param px x-coordinate of point p
     * @param py y-coordinate of point p
     * @param qx x-coordinate of point q
     * @param qy y-coordinate of point q
     * @return distance between given points
     */
    private double distance(double px, double py, double qx, double qy)
    {
        return Math.sqrt(Math.pow(px-qx, 2) + Math.pow(py-qy, 2));
    }

    /**
     * Calculate the area of a triangle given the coordinates of its vertices.
     * 
     * @param x1 x-coordinate of the first vertex
     * @param y1 y-coordinate of the first vertex
     * @param x2 x-coordinate of the second vertex
     * @param y2 y-coordinate of the second vertex
     * @param x3 x-coordinate of the third vertex
     * @param y3 y-coordinate of the third vertex
     * @return area of given triangle
     */
    private double triangleArea(double x1, double y1,
                             double x2, double y2,
                             double x3, double y3)
    {
        double a = distance(x1, y1, x2, y2);
        double b = distance(x1, y1, x3, y3);
        double c = distance(x2, y2, x3, y3);

        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        
        return area;
    }
    
    /**
     * Tests the method that calculates the area of a triangle.
     */
    public Prog13_01()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the coordinates of the three vertices: ");
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        double x3 = in.nextDouble();
        double y3 = in.nextDouble();

        System.out.println("Area = " + triangleArea(x1, y1, x2, y2, x3, y3));
    }
}