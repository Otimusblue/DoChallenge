package LinkedList;

import org.w3c.dom.Node;

public class LinkedList {
	
    Node head ; // head of list
    static class Node {
    	    int data; 
    	    Node next;
    	  //Contructor
    	    Node(int d) { 
    	    	data = d; next = null; 
    	    	} 
    	}
    //print the list
    public void printList() {
    	Node n = head;
    	while(n != null) {
    		System.out.print(n.data+ " ");
    		n = n.next;
    	}
    }

public static void main(String[] args) {
	LinkedList llist = new LinkedList();
	llist.head = new Node(1);
    Node second = new Node(2);
    Node third = new Node(3);
    
    llist.head.next = second; //Link first node to second node
    second.next = third;
    
    llist.printList();
}

}