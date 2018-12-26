import java.util.Set;
import java.util.HashSet;

public class Q1{
   
    Node head;
   
    public static class Node{
    Node next = null;
    int data;
    public Node(int d){ data = d;}
    }

    public void appendToTail(Node head, int d){
        Node end = new Node(d);
        Node n = head;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    public Node deleteNote(Node head, int d){
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

    public void printData(Node head){
        Node n = head;
        while(n!= null){
            System.out.println(n.data);
            n = n.next;
        }
        
    }

    public void deleteDups(Node head){
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

    public static void main(String[] args){
        Q1 llist = new Q1(); 

        llist.head = new Node(0);
        llist.appendToTail(llist.head, 1);
        llist.appendToTail(llist.head, 2);
        llist.appendToTail(llist.head, 3);
        llist.appendToTail(llist.head, 4);
        llist.appendToTail(llist.head, 5);
        llist.appendToTail(llist.head, 3);
        llist.appendToTail(llist.head, 3);
        llist.printData(llist.head);
        llist.deleteDups(llist.head);
        System.out.println( "\n");
        llist.printData(llist.head);
    }
}

