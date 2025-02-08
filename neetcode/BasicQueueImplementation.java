public class Queue {
    private int maxSize; // Maximum size of the queue
    private int[] queueArray; // Array to store queue elements
    private int front; // Index of the front element
    private int rear; // Index of the rear element
    private int currentSize; // Current number of elements in the queue

    // Constructor to initialize the queue
    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0; // Queue is initially empty
    }

    // Method to add an element to the rear of the queue
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % maxSize; // Circular increment for rear
        queueArray[rear] = value;
        currentSize++;
    }

    // Method to remove and return the front element of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Return a default value indicating queue is empty
        }
        int removedValue = queueArray[front];
        front = (front + 1) % maxSize; // Circular increment for front
        currentSize--;
        return removedValue;
    }

    // Method to return the front element of the queue without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No element to peek.");
            return -1; // Return a default value indicating queue is empty
        }
        return queueArray[front];
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return (currentSize == maxSize);
    }

    // Method to display the queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue (front to rear): ");
        int count = 0;
        int i = front;
        while (count < currentSize) {
            System.out.print(queueArray[i] + " ");
            i = (i + 1) % maxSize; // Circular increment
            count++;
        }
        System.out.println();
    }

    // Main method to test the queue implementation
    public static void main(String[] args) {
        Queue queue = new Queue(5); // Create a queue of size 5

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display(); // Output: Queue (front to rear): 10 20 30

        System.out.println("Dequeued element: " + queue.dequeue()); // Output: Dequeued element: 10
        queue.display(); // Output: Queue (front to rear): 20 30

        System.out.println("Front element: " + queue.peek()); // Output: Front element: 20
        queue.display(); // Output: Queue (front to rear): 20 30

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // Output: Queue is full. Cannot enqueue 60
        queue.display(); // Output: Queue (front to rear): 20 30 40 50

        queue.enqueue(70); // Output: Queue is full. Cannot enqueue 70
    }
}