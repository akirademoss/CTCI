public class Q5{
    /*****   Include the main() for testing and debugging  *****/
    public static void main(String[] args){
        String s1 = "pale";
        String s2 = "ple";

        String s3 = "pales";
        String s4 = "pale";

        String s5 = "pale";
        String s6 = "bale";

        String s7 = "pale";
        String s8 = "bake";

        System.out.println("Print true if string is one edit away, otherwise print false\n");
        
        oneAway(s1, s2);
        oneAway(s3, s4);
        oneAway(s5, s6);
        oneAway(s7, s8);


    }

    public static boolean oneAway(String str1, String str2){
        int compIndex = 0, countDiff = 0, i = 0;
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();

        for(i = 0; i < str2.length(); i++){
            if(str1Arr[compIndex] != str2Arr[i]){
                if(str1Arr[compIndex + 1] == str2Arr[i]){
                    compIndex++;
                }
                else if(str1Arr[compIndex] == str2Arr[i +1]){
                    compIndex--;
                }
                if(countDiff > 0){
                    System.out.println(str1 + " , " + str2 + " -> false");
                    return false;
                }
                countDiff++;
            }
            compIndex++; 
        }
        System.out.println(str1 + " , " + str2 + " -> true");
        return true;
    }

}
