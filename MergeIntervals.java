import java.sql.Array;
import java.util.*;
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        System.out.println(Arrays.deepToString(intervals));
        int[][] a = merge(intervals);
        System.out.println(Arrays.deepToString(a));
    }

    public static int[][] merge(int[][] intervals) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            {
//                System.out.print(start + " " + end + "   ");
                if (intervals[i][0] <= end)
                    end = intervals[i][1];
                else {
                    list.add(new ArrayList<>(Arrays.asList(start, end)));
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
//                System.out.println(start + " " + end);
            }
        }
        list.add(new ArrayList<>(Arrays.asList(start, end)));
        int[][] arr = new int[list.size()][list.get(0).size()];
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = new int[]{list.get(i).get(0),list.get(i).get(1)};
        }
        return arr;
    }
}
