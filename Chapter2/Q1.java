package Chapter2;

/**
 * @author Akira Ka DeMoss
 */

import java.util.Set;
import java.util.HashSet;

/**
 * A simple yet robust LinkedList implementation
 */
public class Q1{
   
    Node head;
   
    public class Node{
    Node next = null;
    int data;
    public Node(int d){ data = d;}
    }

    // Add Node to end of LinkedList
    public void appendToTail(int d){
        Node end = new Node(d);
        Node n = head;
        // Check if head has been set
        if(head == null){
            head = new Node(d);
            return;
        }
        while(n.next != null){
            n = n.next;
        }
        n.next = end;       
    }

    // Delete first occurance of a Node
    public void deleteNode(int d){
        Node n = head;

        // Set new head if node to delete is the head
        if(n.data == d){
            head = head.next;
            return;
        }

        // Check for the null pointer and update links 
        // if node to delete is found
        while(n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
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
            }
            else{
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
        
    }

/*****   Include the main() for testing and debugging  *****/
    public static void main(String[] args){
        Q1 llist = new Q1(); 

        llist.appendToTail(0);
        llist.appendToTail(1);
        llist.appendToTail(2);
        llist.appendToTail(3);
        llist.appendToTail(4);
        llist.appendToTail(5);
        llist.appendToTail(3);
        llist.appendToTail(3);
        System.out.println("\n\nBelow we insert elements 0,1,2,3,4,5,3,3. \n" + "LinkedList contains elements 0,1,2,3,4,5,3,3: \n");
        llist.printData();
        llist.deleteDups();
        System.out.println("Below we delete all duplicates of 3. \n" + "LinkedList contains elements 0,1,2,3,4,5: \n");
        llist.printData();
    }
}

