public class Q1{

/*****   Include the main() for testing and debugging  *****/
    public static void main(String[] args){
        String str1 = "apples";
        String str2 = "racing";

        System.out.println("print true if the string is unique, otherwise print false\n");
        System.out.println("'apples' is a unique string: " + isUniqueChars(str1));
        System.out.println("'racing' is a unique string: " + isUniqueChars(str2));
    }

    // Q1 solution 
    public static boolean isUniqueChars(String str){
        if(str.length() > 128){
            return false;
        }

        boolean[] char_set = new boolean[128];
        for(int i=0; i<str.length(); i++){
            int val = str.charAt(i);
            if(char_set[val]){
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

}
