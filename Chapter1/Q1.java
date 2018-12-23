public class Q1{

    public static void main(String[] args){
        String str1 = "apples";
        String str2 = "abcdefghijklmnopqrstuvwxyz";

        if(isUniqueChars(str1)){
            System.out.println("str1 is TRUE\n");
        }
        else{
            System.out.println("str1 is FALSE\n");
        }

        if(isUniqueChars(str2)){
            System.out.println("str2 is TRUE\n");
        }
        else{
            System.out.println("str2 is FALSE\n");
        }

    }

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
