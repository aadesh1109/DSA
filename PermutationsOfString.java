import java.util.Arrays;

public class PermutationsOfString {
    public static void main(String[] args) {
        String s = "ABCD";
        permutations(s.toCharArray(), 0);
    }

    private static void permutations(char[] charArray, int index) {
        if (index==charArray.length)
        {
            System.out.println(String.valueOf(charArray));
            return;
        }

        for (int i = index; i < charArray.length ; i++) {
            swap(index,i,charArray);
            permutations(charArray,index+1);
            swap(index,i,charArray);
        }

    }

    private static void swap(int index, int i, char[] charArray) {
        char temp = charArray[index];
        charArray[index]=charArray[i];
        charArray[i]=temp;
    }
}
