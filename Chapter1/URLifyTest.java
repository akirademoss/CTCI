public class URLifyTest{
    public static void main(String[] args){
        String nameString = "Mr John Smith";
        char[] name = nameString.toCharArray();
        int length = name.length;

        replaceSpaces(name, length);
        
    }

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
        System.out.println("New Char Array: " + newstr);
        System.out.println("Length: " + urlstr.length);
    }
}