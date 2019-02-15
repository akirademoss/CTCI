package Chapter3;

import java.util.NoSuchElementException;

public class Queue<T>{

    private static class QueueNode<T>{
         private T data;
         private QueueNode<T> next;

         public QueueNode(T data){
             this.data = data;
         }
     }

     private QueueNode<T> first;
     private QueueNode<T> last;

     /**
      * Removes the first item in the list
      * @return object at top of queue
      */
     public T remove(){
         if(first == null) throw new NoSuchElementException();
         T data = first.data;
         first = first.next;
         if(first == null){
             last = null;
         }
         return data;
     }

     /**
      * Adds an item to the end of the list
      * @param item the item to be added to end of list
      */
     public void add(T item){
         QueueNode<T> t = new QueueNode<T>(item);
         //Need to make sure last node is not null so that 
         if(last != null){
             last.next = t;
         }
         last = t;
         //When the queue has only one node, the first and last node will be the same node.
         if(first == null){
             first = last;
         }
     }

     /**
      * Returns the object at the top of the queue
      * @return object at top of queue
      */
     public T peek(){
         if(first == null) throw new NoSuchElementException();
         return first.data;
     }

     /**
      * Returns true if and only if the queue is empty
      * @return true if queue is empty, otherwise returns false
      */
     public boolean isEmpty(){
         return first == null;
     }

     public void printData(){
         QueueNode<T> n = first;
         while(n != null){
             if(n.next == null){
                 System.out.println(n.data);
                 return;
             }
             System.out.print(n.data + ", ");
             n = n.next;
         }
     }
     /*****   Include the main() for testing and debugging  *****/
    public static void main(String[] args){

        //Initialize for testing
        Queue<Integer> queue = new Queue<>();

        //Test isEmpty()
        System.out.println("Print true if queue is empty, otherwise print false:");
        System.out.println(queue.isEmpty());

        //Test add(T item)
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        System.out.println("\nPrint contents of queue, in this case these are 5, 6, 7, 8, 9");
        queue.printData();

        //Test peek()
        System.out.println("\nPrint peeked node: should be 5");
        System.out.println(queue.peek());
        System.out.println("Print contents of queue, in this case these are 5, 6, 7, 8, 9");
        queue.printData();

        //Test remove()
        System.out.println("\nNode to be removed should be 5:");
        System.out.println(queue.remove());
        System.out.println("Print contents of queue, in this case these are 6, 7, 8, 9");
        queue.printData();
    }
 }