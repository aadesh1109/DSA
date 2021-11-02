import java.util.Arrays;

public class GenerateTripletsWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 0, 9, 5, 1, 3};
        int sum = 6;
        generateTripletsWithGivenSum(arr, sum);
    }

    private static void generateTripletsWithGivenSum(int[] arr, int sum) {
        Arrays.sort(arr);
        generateTripletsWithGivenSum(0,3,arr,sum,"");
    }
    private static void generateTripletsWithGivenSum(int ind, int k, int[] arr, int sum, String str) {
        if (k==0)
        {
            if (sum==0)
                System.out.println("("+str.substring(0,str.length()-1)+")");
            return;
        }

        if (ind==arr.length || sum<0)
            return;


        generateTripletsWithGivenSum(ind+1,k-1,arr,sum-arr[ind],str+arr[ind]+" ");
        generateTripletsWithGivenSum(ind+1,k,arr,sum,str);

    }
}
