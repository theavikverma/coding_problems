package plus;

import java.util.ArrayList;
import java.util.List;

public class Divisors {
    // Method to find the divisors of a number
    public static List<Integer> findDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        
        // Loop through all numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {  // Check if i is a divisor
                divisors.add(i);
            }
        }
        
        return divisors;  // Return the list of divisors
    }

    public static void main(String[] args) {
        int number = 36;  // Change this to test with different numbers
        
        List<Integer> divisors = findDivisors(number);
        System.out.println("Divisors of " + number + " are: " + divisors);
    }
}

