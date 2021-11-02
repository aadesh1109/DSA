public class CheckWhether2StringsAreANAGRAMSOfEachOther {
    public static void main(String[] args) {
        String a = "banana";
        String b = "banana";
        boolean isAnagram = checkAnagram(a,b);
        System.out.println(isAnagram);
    }

    private static boolean checkAnagram(String a, String b) {
        if (a.length()!=b.length())
            return false;
        a=a.toUpperCase();b=b.toUpperCase();
        int[] charCount = new int[256];
        for (int i = 0; i < a.length() ; i++) {
            charCount[a.charAt(i)]++;
        }
        for (int i = 0; i < b.length() ; i++) {
            charCount[a.charAt(i)]--;
        }
        for (int i : charCount) {
            if (i > 0)
                return false;
        }
        return true;
    }
}
