public class Q2{
    public static void main(String[] args){
        String s1 = "gat";
        String s2 = "gat";
        String s3 = "cab";

        boolean boo;
        boo = permutation(s1, s2);
        System.out.println(boo);
        boo = permutation(s2, s3);
        System.out.println(boo);


    }

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