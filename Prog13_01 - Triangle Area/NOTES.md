# Java Program: Area of a Triangle Using Heron's Formula

## Description
This program calculates the area of a triangle given the coordinates of its three vertices using **Heron's formula**. The formula calculates the area of a triangle based on the side lengths, which are determined by the distance between the vertices.

## Key Concepts

### 1. **Distance Calculation**
The distance between two points (p and q) in a 2D plane is calculated using the **distance formula**:
- Formula: `√((x2 - x1)^2 + (y2 - y1)^2)`
- Used to calculate the lengths of the sides of the triangle.

### 2. **Heron’s Formula for Area**
Heron's formula is used to calculate the area of a triangle when the lengths of all three sides are known:
- Semi-perimeter (s) = `(a + b + c) / 2`, where `a`, `b`, and `c` are the lengths of the triangle's sides.
- Area = `√(s * (s - a) * (s - b) * (s - c))`

## Methods in the Program

### 1. **`distance` Method**
- **Parameters:** Coordinates of two points `(px, py)` and `(qx, qy)`.
- **Returns:** The distance between the two points.
- **Usage:** This method is used to calculate the lengths of the sides of the triangle.

### 2. **`triangleArea` Method**
- **Parameters:** Coordinates of the three vertices of the triangle `(x1, y1)`, `(x2, y2)`, `(x3, y3)`.
- **Returns:** The area of the triangle using Heron's formula.
- **Steps:**
  1. Calculate the side lengths using the `distance` method.
  2. Compute the semi-perimeter `s`.
  3. Calculate and return the area.

### 3. **Main Constructor `Prog13_01`**
- **Purpose:** It prompts the user to input the coordinates of the triangle's three vertices and then computes and displays the area of the triangle.
- **Steps:**
  1. Accepts the coordinates of the three vertices from the user.
  2. Calls the `triangleArea` method to calculate the area.
  3. Displays the calculated area.

## Example Input/Output

### Input
Enter the coordinates of the three vertices: 0 0 4 0 0 3

### Output 
Area = 6.0


## Additional Notes
- **Scanner** is used for user input.
- **Math.sqrt()** and **Math.pow()** are used to calculate the square root and powers for distance and area computation.
