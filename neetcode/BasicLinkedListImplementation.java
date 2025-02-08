package neetcode;

/*
Basic Implementation of singly linkedlist in java
 */

class SinglyLinkedList {

    // Node class to represent each element in the list
    static class Node {
        int data;
        Node next;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the list
    private Node head;

    // Constructor to initialize an empty list
    public SinglyLinkedList() {
        head = null;
    }

    // Add a new node at the end of the list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // If the list is empty, the new node becomes the head
        } else {
            Node current = head;
            // Traverse to the last node
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; // Add the new node at the end
        }
    }

    // Add a new node at the beginning of the list
    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head; // New node points to the old head
        head = newNode; // Update head to new node
    }

    // Delete a node with a specific value
    public void delete(int data) {
        if (head == null) return; // If the list is empty, do nothing

        // If the head node itself holds the value to be deleted
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        // Find the previous node of the node to be deleted
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        // If the value was found, delete it
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Print the entire list
    public void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test the linked list
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Append elements to the list
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);

        // Print the list
        System.out.println("Initial List:");
        list.printList();

        // Prepend an element to the list
        list.prepend(5);
        System.out.println("\nList after prepending 5:");
        list.printList();

        // Delete an element from the list
        list.delete(20);
        System.out.println("\nList after deleting 20:");
        list.printList();
    }
}

/*
 Basic Implementation of Doubly linked list in Java
 */

class DoublyLinkedList {

    // Node class to represent each element in the list
    static class Node {
        int data;
        Node next;
        Node prev;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Head and Tail of the list
    private Node head;
    private Node tail;

    // Constructor to initialize an empty list
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Add a new node at the end of the list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode; // If the list is empty, the new node becomes both head and tail
        } else {
            tail.next = newNode; // Make the current tail point to the new node
            newNode.prev = tail; // Make the new node's prev pointer point to the old tail
            tail = newNode; // Move the tail pointer to the new node
        }
    }

    // Add a new node at the beginning of the list
    public void prepend(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode; // If the list is empty, the new node becomes both head and tail
        } else {
            newNode.next = head; // New node points to the current head
            head.prev = newNode; // Current head's prev pointer points to the new node
            head = newNode; // Move the head pointer to the new node
        }
    }

    // Delete a node with a specific value
    public void delete(int data) {
        if (head == null) return; // If the list is empty, do nothing

        Node current = head;

        // If the head node itself holds the value to be deleted
        if (current.data == data) {
            if (head == tail) { // If there is only one node
                head = null;
                tail = null;
            } else {
                head = head.next; // Move the head pointer to the next node
                head.prev = null; // Set the previous pointer of the new head to null
            }
            return;
        }

        // Traverse the list to find the node to delete
        while (current != null && current.data != data) {
            current = current.next;
        }

        // If the node is found
        if (current != null) {
            if (current.next != null) {
                current.next.prev = current.prev; // Make the next node's prev pointer point to the current node's prev
            } else {
                tail = current.prev; // If it's the last node, update the tail
            }

            if (current.prev != null) {
                current.prev.next = current.next; // Make the previous node's next pointer point to the current node's next
            }
        }
    }

    // Print the entire list from head to tail
    public void printListForward() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Print the entire list from tail to head
    public void printListBackward() {
        if (tail == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    // Main method to test the doubly linked list
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Append elements to the list
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);

        // Print the list from head to tail
        System.out.println("List (Forward):");
        list.printListForward();

        // Print the list from tail to head
        System.out.println("List (Backward):");
        list.printListBackward();

        // Prepend an element to the list
        list.prepend(5);
        System.out.println("\nList after prepending 5 (Forward):");
        list.printListForward();

        // Delete an element from the list
        list.delete(20);
        System.out.println("\nList after deleting 20 (Forward):");
        list.printListForward();
    }
}

/*
Circular Linkedlist implementation in Java
 */


class CircularLinkedList {

    // Node class to represent each element in the list
    static class Node {
        int data;
        Node next;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the list
    private Node head;

    // Constructor to initialize an empty list
    public CircularLinkedList() {
        head = null;
    }

    // Add a new node at the end of the list
    public void append(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head; // Point to itself, making it circular
        } else {
            Node current = head;
            // Traverse to the last node
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode; // Last node points to the new node
            newNode.next = head; // New node points back to the head, maintaining circularity
        }
    }

    // Add a new node at the beginning of the list
    public void prepend(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head; // Point to itself, making it circular
        } else {
            newNode.next = head;
            // Find the last node and update its next pointer to the new node
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode; // Last node points to the new node
            head = newNode; // Move the head pointer to the new node
        }
    }

    // Delete a node with a specific value
    public void delete(int data) {
        if (head == null) return; // If the list is empty, do nothing

        Node current = head;

        // If the head node itself holds the value to be deleted
        if (current.data == data) {
            if (head.next == head) { // If there is only one node
                head = null;
            } else {
                // Traverse to the last node
                while (current.next != head) {
                    current = current.next;
                }
                // Make the last node point to the next of the head
                current.next = head.next;
                head = head.next; // Move the head pointer to the next node
            }
            return;
        }

        // Traverse the list to find the node to delete
        while (current.next != head && current.data != data) {
            current = current.next;
        }

        // If the node is found
        if (current.data == data) {
            current.next = current.next.next; // Skip the node to delete it
        }
    }

    // Print the entire list (starting from the head)
    public void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head); // Continue until we come back to the head
        System.out.println("(head)");
    }

    // Main method to test the circular linked list
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        // Append elements to the list
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);

        // Print the list
        System.out.println("List after appending elements:");
        list.printList();

        // Prepend an element to the list
        list.prepend(5);
        System.out.println("\nList after prepending 5:");
        list.printList();

        // Delete an element from the list
        list.delete(20);
        System.out.println("\nList after deleting 20:");
        list.printList();

        // Delete the head
        list.delete(5);
        System.out.println("\nList after deleting head (5):");
        list.printList();
    }
}




