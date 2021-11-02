public class StringMatch /*Rabin-Karp*/{
    public static void main(String[] args) {
        String longString = "ccaccaaedba";
        String toSearch = "dba";
        boolean b = match(toSearch,longString);
        System.out.println(b);
        
    }

    private static boolean match( String toSearch, String longString) {

        int toSearchHash = findHash(toSearch);
        int n = findHash(longString.substring(0,toSearch.length()));

        if (toSearchHash==n)
            return true;
        else
        {
            int i = 1;
            int j = toSearch.length();
            while (j<longString.length())
            {
                n-=((int)longString.charAt(i-1)-96)*Math.pow(10,toSearch.length()-1);
                n*=10;
                n+=((int)longString.charAt(j)-96);
                if (toSearchHash == n)
                    return true;
                i++;
                j++;
            }
            return false;
        }
    }

    private static int findHash(String toSearch) {
        int Hash = 0;
        for (int i = toSearch.length()-1; i >=0 ; i--) {
            Hash+=((int)toSearch.charAt(toSearch.length()-1-i)-96)*Math.pow(10,i);
        }
        return Hash;
    }
}
