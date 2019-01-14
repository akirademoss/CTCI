import java.util.NoSuchElementException;
import java.util.EmptyStackException;
 
 public class Stack<T>{

    private static class StackNode<T>{
         private T data;
         private StackNode<T> next;

         public StackNode(T data){
             this.data = data;
         }
     }

     private StackNode<T> top;

     /**
      * Removes and returns object at top of the Stack
      * @return object at top of stack
      */
     public T pop(){
         if(top == null) throw new EmptyStackException();
         T item = top.data;
         top = top.next;
         return item;
     }

     /**
      * Inserts an object at the top of the Stack.
      * @param item the item to be added to the top of the stack
      */
     public void push(T item){
         StackNode<T> t = new StackNode<T>(item);
         t.next = top;
         top = t;
     }

     /**
      * Returns the object at the top of the Stack without removing it
      * @return object at top of stack
      */
     public T peek(){
         if(top == null) throw new EmptyStackException();
         return top.data;
     }

     /**
      * Returns true if and only if the stack is empty
      * @return true if stack is empty, otherwise returns false
      */
     public boolean isEmpty(){
         return top == null;
     }

     public void printData(){
         StackNode<T> n = top;
         while(n != null){
             if(n.next == null){
                System.out.print(n.data + "\n");
                return;
             }
             System.out.print(n.data + ", ");
             n = n.next;
         }
     }
     
    /*****   Include the main() for testing and debugging  *****/
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        //Test isEmpty()
        System.out.println("Print true if stack is empty, otherwise print false: ");
        System.out.println(stack.isEmpty());

        //Test push(T item)
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        System.out.println("\nPrint contents of the stack, in this case 9,8,7,6,5: ");
        stack.printData();


        //Test pop()
        System.out.println("\nPop the top value of the stack, should be 9: ");
        System.out.println(stack.pop());
        System.out.println("Contents of stack should now be 8,7,6,5: ");
        stack.printData();

        //Test peek()
        System.out.println("\nPrint the top value of the stack without removing.  Should be 8: ");
        System.out.println(stack.peek());
        System.out.println("Conents of stack remain 8,7,6,5: ");
        stack.printData();
    }
 }