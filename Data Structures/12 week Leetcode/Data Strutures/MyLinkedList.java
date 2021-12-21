/* 
url: https://leetcode.com/problems/design-linked-list/

Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. 
val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to 
indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object-

int get(int index) Get the value of the indexth node in the linked list. 
If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. 
After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the 
linked list. If index equals the length of the linked list, the node will be appended to the 
end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.

*/

public class MyLinkedList {
    
    private class Node {
        private int val;
        private Node next;
        
        private Node() { }

        private Node(int setVal) {
            val = setVal;
        }

        private Node(int setVal, Node setNext) {
            val = setVal;
            next = setNext;
        }
        
        private void setValue(int setVal) {
            val = setVal;
        }
        
        private int getValue() {
            return val;
        }
        
        private void setNext(Node setNode) {
            next = setNode;
        }
        
        private Node getNext() {
            return next;
        }
        
    }
    
    private Node start;
    private int length;

    public MyLinkedList() {
        length = 0;
    }

    public void printList() {
        String x = "[";
        if (length > 0) {
            Node n = start;
            x += n.getValue();
            for (int i = 1; i < length; i++) {
                x += ',';
                n = n.getNext();
                x += n.getValue();
            }
        }
        x += "]";
        System.out.println(x);
    }
    
    public int get(int index) {
        /* Gets the indexth element from the Linked List */
        //assert length > 0 : "The Linked List has no elements";
        if (index < 0 || index >= length || length == 0) {
            return -1;
        }
        //assert index < length : "The specified index is greater than Linked List length";
        Node n = start;
        for (int i = 0; i < index; i++) {
            n = n.getNext();
        }
        System.out.println("get: " + n.getValue());
        return n.getValue();
    }
    
    public void addAtHead(int val) {
        /*
            * void addAtHead(int val) Add a node of value val before the first element of
            * the linked list.
            * After the insertion, the new node will be the first node of the linked list.
            */
        Node temp = start;
        start = new Node(val, temp);
        length += 1;
    }
    
    public void addAtTail(int val) {
        /*
            * void addAtTail(int val) Append a node of value val as the last element of the
            * linked list.
            */
        if (length == 0) {
            start = new Node(val);
            length +=1;
        } else {
            Node n = start;
            for (int i = 1; i < length; i++) {
                n = n.getNext(); // arrive at the last node
            }
            n.setNext(new Node(val));
            length +=1;
        }

    }
    
    public void addAtIndex(int index, int val) {
        /*
            * 
            * void addAtIndex(int index, int val) Add a node of value val before the
            * indexth node in the linked list. If index equals the length of the linked
            * list, the node will be appended to the end of the linked list. If index is
            * greater than the length, the node will not be inserted.
            */
        if (0 < index  && index <= length) {
            Node n = start;
            for (int i = 1; i < index; i++) {
                n = n.getNext(); // arrive to the node at index - 1
            }
            Node temp = n.getNext();
            n.setNext(new Node(val));
            n.getNext().setNext(temp);

            length +=1;
        } else if (index == 0) {
            this.addAtHead(val);
        }
    }
    
    public void deleteAtIndex(int index) {
        /*
            * void deleteAtIndex(int index) Delete the indexth node in the linked list, if
            * the index is valid.
            */

        if (0 < index && index < length) {
            Node n = start;
            for (int i = 1; i < index; i++) {
                n = n.getNext(); // reaching the Node at index-1
            }
            Node temp = n.getNext().getNext();
            n.setNext(temp);
            length -= 1;
        } else if (index == 0) {
            start = start.getNext();
            length -= 1;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
