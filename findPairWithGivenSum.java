import java.util.*;

public class findPairWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 4, 0, 9, 5, 1, 3};
        int sum = 6;


        System.out.println(threeSum(arr, sum));


    }
    private static ArrayList<ArrayList<Integer>> threeSum(int[] arr, int sum) {
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
        Arrays.sort(arr);
        contains3Sum(0, arr, sum, 0, new ArrayList<Integer>() ,finalList);
        return finalList;
    }

    private static void contains3Sum(int index, int[] arr, int sum, int count,ArrayList<Integer> list , ArrayList<ArrayList<Integer>> finalList) {

        if (sum == 0 && count == 3)
        {
            finalList.add(new ArrayList<>(list));
            return;
        }

        if (sum < 0 || index == arr.length)
        {
            return;
        }

        list.add(arr[index]);
        contains3Sum(index+1,arr,sum-arr[index],count+1,list,finalList);
        list.remove(list.size()-1);
        contains3Sum(index+1,arr,sum,count,list,finalList);
    }
}
