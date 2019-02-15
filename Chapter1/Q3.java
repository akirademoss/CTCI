package Chapter1;

public class Q3 {
    /*****   Include the main() for testing and debugging  *****/
    public static void main(String[] args){
        String nameString = "Mr John Smith";
        char[] name = nameString.toCharArray();
        int length = name.length;
        System.out.println("Original String: 'Mr John Smith'");
        replaceSpaces(name, length);
    }

    // Q3 solution
    public static void replaceSpaces(char[] str, int trueLength){
        int spaceCount = 0, index = 0, i = 0;
        for(i=0;i<trueLength;i++){
            if(str[i] == ' '){
                spaceCount++;
            }
        }


        if(trueLength < str.length){
            str[trueLength] = '\0';
        }

        char urlstr[] = new char[trueLength + spaceCount * 2];
        for(i = 0;  i < trueLength; i++){
            if(str[i] == ' '){
                urlstr[index] = '%';
                urlstr[index + 1] = '2';
                urlstr[index + 2] = '0';
                index = index + 3;
            }
            else{
                urlstr[index] = str[i];
                index++;
            }
        }        
        String newstr = String.valueOf(urlstr);
        System.out.println("New Char Array: '" + newstr +"'");
    }
}
