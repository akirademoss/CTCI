/**
 * @author Akira Ka DeMoss
 */

import java.util.Set;
import java.util.HashSet;

/**
 * A simple yet robust LinkedList implementation
 */
public class Q2{
   
    Node head;
    //track size for Q2
    int size;
    
    public class Node{
    Node next = null;
    int data;
    public Node(int d){ data = d;}}

    // Add Node to end of LinkedList
    public void appendToTail(int d){
        Node end = new Node(d);
        Node n = head;
        // Check if head has been set
        if(head == null){
            head = new Node(d);
            //track size for Q2
            size++;
            return;
        }
        while(n.next != null){
            n = n.next;
        }
        n.next = end;   
        //track size for Q2    
        size++;
    }

    // Delete first occurance of a Node
    public void deleteNode(int d){
        Node n = head;

        // Set new head if node to delete is the head
        if(n.data == d){
            head = head.next;
            //track size for Q2
            size--;
            return;
        }

        // Check for the null pointer and update links 
        // if node to delete is found
        while(n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
                //track size for Q2
                size--;
                return;
            }
            n = n.next;
        }
        return;
    }

    // Print out the contents of the LinkedList 
    public void printData(){
        Node n = head;
        System.out.print("null-> ");
        while(n!= null){
            System.out.print(n.data + "-> ");
            n = n.next;
        }
        System.out.print("null \n \n \n");
        
    }

    //Note this is Question 1 solution
    public void deleteDups(){
        Set<Integer> set = new HashSet<Integer>();
        Node n = head;
        Node previous = null;
        while(n!= null){
            if(set.contains(n.data)){
                previous.next = n.next;
                //track size for Q2
                size--;
            }
            else{
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
        
    }

    //Q2 brute force solution
    public void deleteKthToLast1(int k){
        Node n = head;
        Node previous = null;
        int numElements = 0;
        int nth;
        //need to know the # of elements
        while(n != null){
            n = n.next;
            numElements++; 
        }
        //need to subtract k from # of elements to get nth value
        nth = numElements - k;
        //Now we can scan for element from head
        n = head;
        if(nth > 0){
            while((n != null)&&(nth > 0)){
                previous = n;
                n = n.next;
                nth--;
            }
            previous.next = n.next;
            size--;
        }
        else{
            //System.out.print("Value exceeds number of elements in list");
        }
    }

    //Q2 with size tracked
    public void deleteKthToLast(int k){
        Node n = head;
        Node previous = null;
        if((head == null) || (k > size)){
            return;
        }
        while(k < size){
            previous = n;
            n = n.next;
            k++;
        }
        previous.next = n.next;
        size--;
    }
    

/*****   Include the main() for testing and debugging  *****/
    public static void main(String[] args){
       Q2 llist1 = new Q2(); 
       Q2 llist = new Q2();

        //Initializing our list data
        llist1.appendToTail(0);
        llist1.appendToTail(1);
        llist1.appendToTail(2);
        llist1.appendToTail(3);
        llist1.appendToTail(4);
        llist1.appendToTail(5);

        System.out.println("Deleting the kth to last element of a linked list where k = 2\n");
        

        //Q2 solution 1
        System.out.println("Solution 1.) brute force solution:\n");
        System.out.println("Initial contents of LinkedList:");
        llist1.printData();
        llist1.deleteKthToLast1(2);
        System.out.println("Contents of LinkedList after deletion:");
        llist1.printData();
        System.out.println();
        System.out.println();
        System.out.println();

        //Initializing our list data
        llist.appendToTail(0);
        llist.appendToTail(1);
        llist.appendToTail(2);
        llist.appendToTail(3);
        llist.appendToTail(4);
        llist.appendToTail(5);


        //Q2 solution 2
        System.out.println("Solution 2.) optimized solution:\n");
        System.out.println("Initial contents of LinkedList:");
        llist.printData();
        llist.deleteKthToLast(2);
        System.out.println("Contents of LinkedList after delection:");
        llist.printData();
    }
}

