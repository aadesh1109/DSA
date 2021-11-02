public class NumOfBitsChangedToConvertFromAToB {
    public static void main(String[] args) {
        int a = 22, b = 27;
        int res = a^b;
        int count = 0;
//        while (res>0) //first method
//        {
//            if ((res&1)==1)
//                count++;
//            res=res>>1;
//        }

        while (res>0) //second method(more optimized solution)
        {
            res=res&res-1;// n&n-1 which clears least significant bit to 0 (1-->0)
            count++;
        }
        System.out.println(count);
    }
}
