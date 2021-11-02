public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "abcdabc";
        System.out.println(checkRepeatedSubstringPattern(s));
    }

    public static boolean checkRepeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len / 2; i > 0; i--) {
            if (len % i == 0) {
                String stringToRepeat = s.substring(0, i);
                int numberOfTimesToRepeat = len / i;
                StringBuilder stringFormedAfterRepeating = new StringBuilder();
                for (int j = 0; j < numberOfTimesToRepeat; j++) {
                    stringFormedAfterRepeating.append(stringToRepeat);
                }
                if (stringFormedAfterRepeating.toString().equals(s))
                    return true;
            }
        }
        return false;
    }
}
