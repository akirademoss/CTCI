public class Q2{
    /*****   Include the main() for testing and debugging  *****/
    public static void main(String[] args){
        String s1 = "gat";
        String s2 = "tag";
        String s3 = "cab";

        System.out.println("print true if two strings are permutations of one another, otherwise print false\n");
        System.out.println("'gat' and 'tag': " + permutation(s1, s2));
        System.out.println("'tag' and 'cab': " + permutation(s2, s3));
    }

    // Q2 solution
    public static boolean permutation(String s, String t){
        int[] letters = new int[128];

        char[] s_array = s.toCharArray();
        for(char c : s_array){
            letters[c]++;
        }

        for(int i=0; i<t.length(); i++){
            int c = (int) t.charAt(i);
            letters[c]--;
            if(letters[c]<0){
                return false;
            }
        }
        return true;
    }
}