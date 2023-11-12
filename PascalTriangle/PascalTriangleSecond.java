package PascalTriangle;
//Given the row number n. Print the n-th row of Pascal’s triangle.
class PascalTriangleSecond {

    public static void main(String[] args) {
        int n = 5;
        pascalTriangle(n);
    }

    private static void pascalTriangle(int n) {

        long ans = 1;
        System.out.print(ans + " "); // printing 1st element

        // Printing the rest of the part:
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            System.out.print(ans + " ");
        }
        System.out.println();
    }
    
}

//Time Complexity: O(N) where N = given row number. Here we are using only a single loop.
//Space Complexity: O(1) as we not using any extra space.
