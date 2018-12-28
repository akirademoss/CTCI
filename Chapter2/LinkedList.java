import java.util.Set;
import java.util.HashSet;

public class LinkedList{
   
    Node head;
   
    public class Node{
    Node next = null;
    int data;
    public Node(int d){ data = d;}
    }

    public void addFirst(int d){
        if(head == null){
            head = new Node(d);
        }
    }

    public void appendToTail(int d){
        Node end = new Node(d);
        Node n = head;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    public Node deleteNote(int d){
        Node n = head;

        if(n.data == d){
            return head.next;
        }

        while(n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }

    public void printData(){
        Node n = head;
        while(n!= null){
            System.out.println(n.data);
            n = n.next;
        }
        
    }

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
        LinkedList llist = new LinkedList(); 

        llist.addFirst(0);
        llist.appendToTail(1);
        llist.appendToTail(2);
        llist.appendToTail(3);
        llist.appendToTail(4);
        llist.appendToTail(5);
        llist.appendToTail(3);
        llist.appendToTail(3);
        llist.printData();
        llist.deleteDups();
        System.out.println( "\n");
        llist.printData();
    }
}

