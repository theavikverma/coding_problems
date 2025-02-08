public class Stack {
    private int maxSize; // Maximum size of the stack
    private int[] stackArray; // Array to store stack elements
    private int top; // Index of the top element

    // Constructor to initialize the stack
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Stack is initially empty
    }

    // Method to add an element to the top of the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
            return;
        }
        stackArray[++top] = value; // Increment top and insert the value
    }

    // Method to remove and return the top element of the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; // Return a default value indicating stack is empty
        }
        return stackArray[top--]; // Return the top element and decrement top
    }

    // Method to return the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No element to peek.");
            return -1; // Return a default value indicating stack is empty
        }
        return stackArray[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    // Method to display the stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the stack implementation
    public static void main(String[] args) {
        Stack stack = new Stack(5); // Create a stack of size 5

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display(); // Output: Stack (top to bottom): 30 20 10

        System.out.println("Popped element: " + stack.pop()); // Output: Popped element: 30
        stack.display(); // Output: Stack (top to bottom): 20 10

        System.out.println("Top element: " + stack.peek()); // Output: Top element: 20
        stack.display(); // Output: Stack (top to bottom): 20 10

        stack.push(40);
        stack.push(50);
        stack.push(60); // Output: Stack is full. Cannot push 60
        stack.display(); // Output: Stack (top to bottom): 50 40 20 10
    }
}