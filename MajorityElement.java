import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 4, 4, 4, 3, 2, 2};
        int num = findMajorityEle(arr);
        System.out.println(num);
    }

    //Moore's Voting Algo
    private static int findMajorityEle(int[] arr) {
        int majorityEle = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length ; i++) {
            if (arr[i]==majorityEle)
                count++;
            else
                count--;

            if (count==0)
            {
                majorityEle=arr[i];
                count=1;
            }

        }
        if (count>0)
        {
            int c=0;
            for (int j : arr) {
                if (j == majorityEle)
                    c++;
                if (c > arr.length / 2) {
                    return majorityEle;
                }

            }
            return -1;
        }

        return -1;

    }
/*
    private static int findMajorityEle(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int j : arr) {
            if (!map.containsKey(j))
                map.put(j, 1);
            else {
                int v = map.get(j);
                map.put(j, ++v);
                if (map.get(j) > arr.length / 2)
                    return j;
            }
        }
        return -1;
    }*/


}
