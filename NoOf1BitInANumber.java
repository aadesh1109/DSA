//finding the no. of 1s in binary representation of a number
public class NoOf1BitInANumber {
    public static void main(String[] args) {
        int a = 31;
        int ones = findOnes(a);
        System.out.println(ones);
    }

    private static int findOnes(int a) {
        int count = 0;
        while (a>0)
        {
//            if (a%2==1)
//                count++;
//            a/=2;

            a=a&a-1;// optimized solution
            count++;
        }
        return count;
    }
}
