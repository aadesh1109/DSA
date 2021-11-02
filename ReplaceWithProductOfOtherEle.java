import java.util.Arrays;

public class ReplaceWithProductOfOtherEle {
    public static void main(String[] args) {
        int[] arr = {5,3,4,2,6,8};
        function(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void function(int[] arr) {
        function(0,arr,1);
    }

    private static int function(int i, int[] arr,int left) {
        if (i==arr.length)
            return 1;


        int right = function(i+1,arr,left*arr[i]);
        int r = arr[i];
        arr[i]=left*right;
        return right*r;




    }
}
