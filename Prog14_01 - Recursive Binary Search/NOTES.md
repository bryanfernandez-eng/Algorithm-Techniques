# Notes on the Java Program: Recursive Binary Search Implementation

---

## Program Overview
This Java program implements and tests **recursive binary search**, a common algorithm used to efficiently search for an element in a **sorted array**.

### Key Concepts
- **Binary Search** is an efficient search algorithm that works by repeatedly dividing the search interval in half.
- **Time Complexity**: The time complexity of binary search is **O(log n)**, where `n` is the number of elements in the array. This means that the search time grows logarithmically as the size of the array increases. Binary search is faster than linear search (which has a time complexity of O(n)) when the array is large.
- The program also generates random numbers, sorts them, and then performs binary search to check if a randomly generated number is in the sorted array.

---

## Explanation of the Code

### 1. Main Method
```java
public static void main(String[] args) {
    new Prog14_01();
}
```

The main method is the entry point of the program. It creates a new instance of Prog14_01, which will trigger the constructor (Prog14_01()), executing the program.

### 2. Contstructor (`Prog14_01`)

```java
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
```

- This constructor sets up the array, fills it with random numbers, prints it before and after sorting, and finally performs a binary search for a randomly selected number.
  
- ***Random Array***: An array `list` of 10 integers is created.

- `fillArray` Method: The fillArray method is called to populate the array with random integers between 0 and 9.
- ***Sorting***: `Arrays.sort(list)` sorts the array in ascending order before performing the binary search.

##

### 3. Filling the Array (`fillArray Method`)

```java
public void fillArray(int[] list) {
    Random rnd = new Random();
    for (int i = 0; i < list.length; i++) {
        list[i] = rnd.nextInt(10);
    }
}
```
- This method fills the array `list` with random numbers between 0 and 9. The `Random` class is used to generate random integers.
- ***Time Complexity***: The time complexity for this method is O(n), where `n` is the size of the array. This is because each element is assigned a random value in a loop.

##

### 4. Printing the Array (`printArray Method`)

```java
public void printArray(int[] list) {
    for (int i = 0; i < list.length; i++) {
        System.out.print(list[i] + " ");
    }
    System.out.println();
}
```

- This method prints each element in the array, followed by a space.
- It simply iterates through the array and outputs each element.
- ***Time Complexity***: The time complexity is `O(n)` since each element is accessed once.

##

### 5. Binary Search (`binarySearch Method`)


```java
public boolean binarySearch(int[] list, int x) {
    return binarySearch(list, 0, list.length - 1, x);
}
```

- This is the public method that initiates the binary search on a sorted array list for a value x.
- It calls the private recursive method by passing the initial index `(0)` and the last index `(list.length - 1)`.

##

### Private Recursive Method

```java
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
```

- This is the actual recursive binary search algorithm. It takes the array list, the indices first and last, and the search element x.

- **Base Case**: If first exceeds last, the element is not found, and it returns `false`.

- **Recursive Step**:
  - The middle element of the array `(mid)` is calculated as `(first + last) / 2`.
  
  - If `list[mid]` equals `x`, the element is found, and `true` is returned.
  - If `list[mid]` is greater than `x`, the search continues in the left half of the array (elements before mid).
  - If `list[mid]` is less than x, the search continues in the right half (elements after mid).
##
### Time Complexity: 
The binary search algorithm has a time complexity of `O(log n)`. This is because the search space is halved with each recursive call, leading to logarithmic growth in the number of steps required to find the element.
##

### How Binary Search Works
**Initial State**: The array is sorted in `ascending order`.

**Search Process**:
- First, the middle element of the array is checked.
- If the middle element is the target value (x), the search is over.
- If the target value is smaller than the middle element, the algorithm searches the left half of the array.
- If the target value is larger than the middle element, the algorithm searches the right half.
Recursion: This process repeats recursively on the appropriate half of the array, continuously halving the search space, until the element is found or the search space is empty.
