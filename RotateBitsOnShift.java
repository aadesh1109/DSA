// https://www.youtube.com/watch?v=uDqUb50Bmvs&list=PLNmW52ef0uwvkul_e_wLD525jbTfMKLIJ&index=3&ab_channel=ByteByByte
public class RotateBitsOnShift { //left rotate
    public static void main(String[] args) {
        int number = 16;
        int d = 2;
        int rightRotated = rightRotateBits(number, d);
        int leftRotated = leftRotateBits(number, d);
        System.out.println(leftRotated);
        System.out.println(rightRotated);

    }

    private static int leftRotateBits(int number, int d) {
        return (number << d) | (number >> (32 - d)); //32 is no. of bits taken by an integer in java
    }

    private static int rightRotateBits(int number, int d) {
        return (number >> d) | (number << (32 - d)); //32 is no. of bits taken by an integer in java
    }



//    private static int rotateBits(int number, int d) {
//        ArrayList<Integer> bits = new ArrayList<>(32); // O(n) solution
//        int bitIndex = 0;
//        while (number > 0) {
//            bits.add(bitIndex, number % 2);
//            number /= 2;
//            bitIndex++;
//        }
//        bitIndex = 0;
//        int sum = 0;
//        int i = bits.size() - d;
//        while (bitIndex < bits.size()) {
//            sum += bits.get(i) * Math.pow(2, bitIndex);
//            bitIndex++;
//            i = (i + 1) % bits.size();
//        }
//        return sum;
//    }
}
