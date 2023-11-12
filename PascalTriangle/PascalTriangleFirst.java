package PascalTriangle;

//In this case, we are given the row number r and the column number c, 
//and we need to find out the element at position (r,c). 
class PascalTriangleFirst {

    public static void main(String[] args) {
        int r = 4; // row number
        int c = 3; // col number
        long element = pascalTriangle(r, c);
        System.out.println("The element at position (r,c) is: " + element);
    }

    private static long pascalTriangle(int r, int c) {
        long element = nCr(r-1,c-1);
        return element;
    }

    private static long nCr(int n, int r) {
        long result = 1;
        for(int i=0;i<r;i++){
            result = result * (n - i);
            result = result / (i + 1);
        }
        return result;
    }
    
}
