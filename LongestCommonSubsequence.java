public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "ABCBDAB";
        String s2 = "BDCABA";
        

    }

    private static int longestCommonSubsequence(String s1, String s2) {

        if (s1.equals("") || s2.equals(""))
            return 0;

        if (s1.charAt(s1.length()-1)==s2.charAt(s2.length()-1))
            return 1+ longestCommonSubsequence(s1.substring(0,s1.length()-1),s2.substring(0,s2.length()-1));
        else
            return Math.max(longestCommonSubsequence(s1.substring(0,s1.length()-1),s2), longestCommonSubsequence(s1,s2.substring(0,s2.length()-1)));


    }

/*
    private static int longestCommonSubsequence(String s1, String s2) {
        int[][] arr = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i < s1.length()+1 ; i++) {
            for (int j = 0; j < s2.length()+1 ; j++) {
                if (i==0 || j==0)
                    arr[i][j]=0;
                else
                {
                    if (s1.charAt(i-1)==s2.charAt(j-1))
                        arr[i][j]=arr[i-1][j-1]+1;
                    else
                        arr[i][j]=Math.max(arr[i-1][j],arr[i][j-1]);
                }
            }
        }
        return arr[s1.length()][s2.length()];



    }
*/









}
