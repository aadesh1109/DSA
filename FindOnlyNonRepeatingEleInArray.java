//Finding the only non-repeating element in an array where every element occurs twice except one or none
//Using XOR properties here...num^num=0, 0^num=num...for most optimized solution than using hashmap/hashset and 2 pointer method(O(n2))
public class FindOnlyNonRepeatingEleInArray {
    public static void main(String[] args) {
        int[] arr = {4,6,3,2,4,2,3,6,7,7,12};
        int XORed = 0;
        for (int i : arr) {
            XORed ^= i;
        }
        if (XORed!=0)
            System.out.println(XORed+" is occurring once.");
        else
            System.out.println("No single occurring element found!");


    }
}
