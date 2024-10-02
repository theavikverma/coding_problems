package plus;

class LCM {
    public static int lcm(int n1, int n2) {
    int max = Math.max(n1, n2);
        for(int i = max ; ;i = i+max){
            if(i%n1 == 0 && i%n2 == 0){
                return i;
            }
        }
    }
    public static void main(String[] args) {
        int num1 = 4;
        int num2 = 12;
        
        int result = lcm(num1, num2);
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + result);
    }
}
