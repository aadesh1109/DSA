import java.util.*;

public class DivideArrayInSetsOfKConsecutiveNumbers {
    public static void main(String[] args) {
        int[] arr = {3,3,2,2,1,1};
        int k = 3;
        System.out.println(isPossibleDivide(arr,k));
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
    }

    private static boolean isPossibleDivide(int[] arr, int k) {
        if (arr.length%k!=0)
            return false;
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < arr.length/k ; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < arr.length ; i++) {
            for (int j = 0; j < lists.size() ; j++) {

                if (lists.get(j).isEmpty() || (lists.get(j).size()<k && arr[i]-lists.get(j).get(lists.get(j).size()-1)==1))
                {
                    lists.get(j).add(arr[i]);
                    break;
                }
            }
        }
        for (int i = 0; i < lists.size() ; i++) {
            if (lists.get(i).size()!=k)
                return false;
        }

        /*for (ArrayList<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i+" ");
            }
            System.out.println();
        }*/
        return true;
    }






/*    public static boolean isPossibleDivide(int[] nums, int k) //recursive method
{
        if (nums.length%k!=0)
            return false;
        Arrays.sort(nums);
        boolean[] taken = new boolean[nums.length];
        return isPossibleDivide(0,nums,0,k,nums.length/k,taken,-1);

    }

    private static boolean isPossibleDivide(int i, int[] nums, int curr_count ,int k, int buckets , boolean[] taken ,int lastTaken) {

        if (buckets==0)
            return true;

        if (curr_count==k)
            return isPossibleDivide(0,nums,0,k,buckets-1,taken,-1);

        if (i==nums.length)
            return false;

        if (!taken[i] && nums[i]-lastTaken==1)
            {
                taken[i]=true;
                if (isPossibleDivide(i+1,nums,curr_count+1,k,buckets,taken,nums[i]))
                    return true;
                taken[i]=false;
            }

            return isPossibleDivide(i+1,nums,curr_count,k,buckets,taken,lastTaken);
    }*/
}
