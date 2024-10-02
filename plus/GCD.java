package plus;
class GCD {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;  // Base case: if b is 0, GCD is a
        }
        return gcd(b, a % b);  // Recursive call
    }

    public static void main(String[] args) {
        int num1 = 56;
        int num2 = 98;
        
        int result = gcd(num1, num2);
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + result);
    }
}
