package AdditionalPractice;

import java.util.*;


//Given an array of integers, output all pairs that they add up to a specific target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.


public class TwoSum {
    
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    
    
    public static void main(String[] args){

    int[] array = {1,3,2,2,5,46,6,7,4};
    
    twoSum(array, 5);
    
    twoSum1(array, 5);
    
    twoSum2(array, 5);
    
    }
    
    //BRUTE FORCE EXAMPLE
    //works if duplicates are OK
    public static void twoSum(int[] arr, int k){
        for (int i =0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[i] + arr[j] == k){
                    System.out.println("(" + arr[i] + "," + arr[j] + ")");
                }
            }
        }
    }
    
    //HASHMAP EXAMPLE
    //works if not okay duplicates
    public static void twoSum1(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int compliment = k - arr[i];
            if(map.containsKey(compliment)){
                System.out.println("(" + map.get(compliment) + "," + arr[i] + ")");
            }
            map.put(compliment, i);
        }
    }
    
    //HASHSET EXAMPLE
    //best solution
    public static void twoSum2(int[] arr, int k){
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0; i<arr.length; i++){
            int compliment = k - arr[i];
            if(set.contains(compliment)){
                System.out.println("(" + compliment + "," + arr[i] + ")");
                set.remove(compliment);
            }
            set.add(arr[i]);
        }
    }
    
    
}