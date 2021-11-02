public class StringPermutations {
    public static void main(String[] args) {
        String str = "cab";
        permute(0,str.toCharArray(),str);
    }

    private static boolean permute(int curInd,char[] ch,String str) {

        if (curInd==ch.length)
        {
            if (String.valueOf(ch).compareTo(str)>0)
            {System.out.println(String.valueOf(ch));return true;}
            return false;
        }

        for (int i = curInd; i < ch.length ; i++) {

            swap(i,curInd,ch);
            if(permute(curInd+1,ch,str))
                return true;
            swap(i,curInd,ch);
        }
        return false;
    }

    private static void swap(int curInd , int i , char[] ch)
    {
        char temp = ch[i];
        ch[i]=ch[curInd];
        ch[curInd]=temp;
    }
}