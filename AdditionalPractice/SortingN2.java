package AdditionalPractice;

public class SortingN2 {
    


    //note: this problem involves sorting an array and returning the smallest element
    public static void main(String[] args){
    
        int[] array = {6,3,9,8,5,1};
    
        

    
   
        
        int smallest = getSmallestN2(array);
    
        System.out.println("The smallest integer is: " + smallest);
    }


    public static int getSmallestN2(int[] arr){
        for(int i = 0; i<arr.length; i++){
            int temp;
            for (int j = 0; j<arr.length-1; j++){
                if(arr[i] < arr[j]){
                    temp = arr[j]; 
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr[0];
    }
    
    public static int getSmallest(int[] arr){
        return 0;
    }
}