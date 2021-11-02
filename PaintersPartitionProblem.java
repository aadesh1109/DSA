import java.util.Arrays;

public class PaintersPartitionProblem /*Painter's Partition */{
    public static void main(String[] args) {
        int[] arr = {10, 40,40,10};
        int painters = 2;
        int timePerBoard = 1;
        int min = (Arrays.stream(arr).max().getAsInt())*timePerBoard;
        int max = (Arrays.stream(arr).sum())*timePerBoard;
        int minTime = 0;
        while (min<=max)
        {
            int mid = (min+max)/2;
            int painterWanted = getCount(mid,arr);
            if (painterWanted>painters)
                min=mid+1;
            else
            {
                minTime=mid;
                max = mid-1;

            }
        }
        System.out.println(minTime);

    }

    private static int getCount(int mid, int[] arr) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i]>mid)
                return Integer.MAX_VALUE;
            sum+=arr[i];
            if (sum>mid)
            {
                sum=arr[i];
                count++;
            }
        }
        return count;
    }
}
