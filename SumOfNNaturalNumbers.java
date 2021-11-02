public class SumOfNNaturalNumbers {
    public static void main(String[] args) {
        int n = 3;
        int sum = findSum(n);
        System.out.println(sum);
    }

    private static int findSum(int n) {
        if (n==1)
            return 1;
        return n+findSum(n-1);
    }
}
