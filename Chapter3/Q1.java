import java.util.EmptyStackException;

class Q1{
    //4 global class variables
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    /**
     * set the stackCapacity, initialize values and size arrays
     * @param stackSize the size of each stack to be implemented
     */
    public Q1(int stackSize){
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    /**
     * push a value to a chosen stack
     * @param stackNum
     * @param value
     * @throws FullStackException
     */
    //Note should  be FullStackException but changing so this compiles
    public void push(int stackNum, int value) throws EmptyStackException{
        //Check for space for next element
        //Note should  be FullStackException but changing so this compiles
        if(isFull(stackNum)){
            throw new EmptyStackException();
        }
        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }

    /**
     * pop a value from a chosen stack
     * @param stackNum selected stack
     * @return value to be removedd
     */
    public int pop(int stackNum){
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        int topIndex = indexOfTop(stackNum);
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;
        return value;
    }

    /**
     * peek a value
     * @param stackNum selected stack
     * @return
     */
    public int peek(int stackNum){
        if (isEmpty(stackNum)){
            throw new EmptyStackException();
        }
        return values[indexOfTop(stackNum)];
    }

    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }

    /**
     * Return if stack is full
     * @param stackNum stack identifier
     * @return true if stack's allocated space in array is full capacity
     */
    public boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;
    }

    /**
     * Returns the index of the top of the stack
     * @param stackNum selected stack
     * @return index of top of stack
     */
    private int indexOfTop(int stackNum){
        //stack offset
        int offset = stackNum * stackCapacity;
        //size offset
        int size = sizes[stackNum];
        //last in (top of stack)
        return offset + size - 1;
    }

    private void printStack(int stackNum){
        int startOffset = stackNum * stackCapacity;
        int endOffset = startOffset + sizes[stackNum];
        for(int i=startOffset; i < endOffset; i++){
            System.out.println(values[i]);
        }
    }

    public static void main(String[] args){
        Q1 stackArray = new Q1(3);
        stackArray.push(0, 0);
        stackArray.push(0, 1);
        stackArray.push(0, 2);
        stackArray.push(1, 1);
        stackArray.push(1, 2);
        stackArray.push(1, 3);
        stackArray.push(2, 2);
        stackArray.push(2, 3);
        stackArray.push(2, 4);
        stackArray.printStack(1);
    }
}