//Gray number or not
public class CheckWhether2NumbersDifferBy1BitOrNot {
    public static void main(String[] args) {
        boolean isGray = check(1,1);
        System.out.println(isGray);
    }

    private static boolean check(int i, int j) {
        if (i==j)
            return false;
        int number = i^j;
        return (number & number - 1) == 0;
    }
}
