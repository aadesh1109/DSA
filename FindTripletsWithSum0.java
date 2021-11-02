import java.util.Arrays;

// 2 POINTERS ALGORITHM
// applied on sorted array
public class FindTripletsWithSum0 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,4,-1,3,-4,0,3};
        boolean isPresent = findTriplets(arr);
        System.out.println(isPresent);
    }

    private static boolean findTriplets(int[] arr) {
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        int i=0;
        while (i< arr.length)
        {
            int j = i+1;
            int k = arr.length-1;
            while (j<k)
            {
                if (arr[j]+arr[k]==-arr[i]){
//                    System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
                    return true;}
                else if (arr[j]+arr[k]>-arr[i])
                    k--;
                else
                    j++;
            }
            i++;
        }
        return false;
    }
}
