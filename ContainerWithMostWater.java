import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ContainerWithMostWater
{
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

    }


/*    public static int maxArea(int[] height) { //not a optimized solution
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        for (int i = 0; i < height.length ; i++) {
            int farthestGreatest = Integer.MAX_VALUE;
            for (int j = i-1; j > -1 ; j--) {
                if (height[j]>=height[i])
                    farthestGreatest = height[j];
            }
            left[i]=farthestGreatest;
        }

        for (int i = height.length-1; i > -1 ; i--) {
            int smallestGreater = Integer.MAX_VALUE;
            for (int j = i+1; j < height.length ; j++) {
                if (height[j]>=height[i])
                    smallestGreater = height[j];
            }
            right[i]=smallestGreater;
        }
       *//* System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));*//*

        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < height.length ; i++) {
            if (left[i]!=Integer.MAX_VALUE && right[i]!=Integer.MAX_VALUE)
            {
                int firstInd = findFirstInRange(left[i],i,height);
                int lastInd = findLastInRange(right[i],i,height);
                int prod = Math.min(left[i],right[i])*Math.abs(lastInd-firstInd);
                maxArea = Math.max(maxArea,prod);
            }
            else if (left[i]==Integer.MAX_VALUE)
            {
                int lastInd = findLastInRange(right[i],i,height);
                int prod = height[i]*(lastInd-i);
                maxArea = Math.max(maxArea,prod);
            }
            else if (right[i]==Integer.MAX_VALUE)
            {
                int firstInd = findFirstInRange(left[i],i,height);
                int prod = height[i]*(i-firstInd);
                maxArea = Math.max(maxArea,prod);
            }
        }
        return maxArea;
    }

    private static int findFirstInRange(int num, int range , int[] height) {
        for (int i = 0; i < range ; i++) {
            if (height[i]==num)
                return i;
        }
        return 0;
    }

    private static int findLastInRange(int num, int range , int[] height) {

        for (int i = height.length-1; i > range ; i--) {
            if (height[i]==num)
                return i;
        }
        return 0;
    }*/
}
