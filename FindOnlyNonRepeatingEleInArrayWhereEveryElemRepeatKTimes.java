//Finding the only non-repeating element in an array where every element occurs k times except that one
public class FindOnlyNonRepeatingEleInArrayWhereEveryElemRepeatKTimes {
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4,2,2,1,4,5,1,1,2,4};
        int[] bitsCount = new int[32];//int size is 4 bytes, i byte=8bit, 4*8=32bits for array size
        for (int i : arr) {
            int num = i;
            int bitIndex = 0;
            while (num > 0) {
                bitsCount[bitIndex] += num % 2;
                bitIndex++;
                num /= 2;
            }
        }
        //        System.out.println(Arrays.toString(bitsCount));
        int number = 0;
        //if number in multiple of 3n(0,3,6,9,...), it means no bit of number which is occurring once is present on that bit index
        //if number in multiple of 3n+1(1,4,7,10,....) , it means a bit of number which is occurring once is present on that bit index
        for (int i = 0; i < bitsCount.length; i++) {
            if (bitsCount[i]%k==0) //here numbers in bitCount array can multiple of 3(3n...where n=0,1,2...) or 3n+1 or 1 or 0
                number+=0*Math.pow(2,i); //
            else
                number+=1*Math.pow(2,i);//considering 1 extra bit there of a number occurring once to change from binary to decimal
        }
        System.out.println(number);
    }
}
