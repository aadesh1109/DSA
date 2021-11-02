public class CheckIfAStringIsROTATEDPALINDROME {
    public static void main(String[] args) {
        String str = "CDCBAAB";
        System.out.println(isRotatedPalindrome(str));

    }

    private static boolean isRotatedPalindrome(String str) {
        str = str + str;
        for (int i = 0; i < str.length(); i++) {
            if (expandAndCheck(str, i, i) || expandAndCheck(str, i, i + 1))
                return true;
        }
        return false;
    }

    private static boolean expandAndCheck(String str, int low, int high) { //check question Longest Palindromic Substring Problem for clarification
        while (low >= 0 && high < str.length() &&
                (str.charAt(low) == str.charAt(high))) {
            if (high - low + 1 == str.length() / 2)
                return true;
            low--;
            high++;
        }
        return false;
    }


//    //finding all the rotations of input string and checking any one of them is palindrome or not( naive approach )
//    public static boolean isRotatedPalindrome(String str) {
//        for (int i = 0; i < str.length(); i++) {
//            String toCheck = str.substring(i) + str.substring(0, i);
//            if (isPalindrome(toCheck, 0, toCheck.length() - 1)) {
////                System.out.println(toCheck);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static boolean isPalindrome(String str, int low, int high) {
//        if (low >= high)
//            return true;
//        return str.charAt(low) == str.charAt(high) && isPalindrome(str, low + 1, high - 1);
//    }
}
