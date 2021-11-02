//Finding two non-repeating elements in an array where every element occurs twice except two
//Using XOR properties here...num^num=0, 0^num=num...for most optimized solution than using hashmap/hashset and 2 pointer method(O(n2))
//for reference watch Anuj Bhaiya DSA playlist video 4!
public class FindTwoNonRepeatingEleInArray {
    public static void main(String[] args) {
        int[] arr = {5,4,1,4,3,5,1,2};
        int XORed = 0;
        for (int i : arr) {
            XORed ^= i;
        }
        int num = XORed&(XORed-1); //to clear least significant set(1) bit to 0
        int diff = XORed-num;//finding difference to calc bit number
        int bitNumber = log2(diff);//calc bit where difference came
        int XORed1=XORed,XORed0=XORed;
        for (int i : arr) {
            int number = i & (1 << bitNumber);
            if (number > 0)
                XORed1 ^= i;
            else
                XORed0 ^= i;
        }
        System.out.println(XORed0 +" "+XORed1);
    }

    public static int log2(int N)
    {
        // calculate log2 N indirectly
        // using log() method
        int result = (int)(Math.log(N) / Math.log(2));
        return result;
    }
}
