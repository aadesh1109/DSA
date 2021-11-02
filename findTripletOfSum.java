import java.util.ArrayList;
import java.util.Arrays;

public class findTripletOfSum {
    public static void main(String[] args) {
        int[] A = { 2, 7, 4, 0, 9, 5, 1, 3 };
        int sum = 6;
        ArrayList<ArrayList<Integer>> finalList = findTriplet(A,sum);
        for (ArrayList<Integer> list : finalList) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    private static ArrayList<ArrayList<Integer>> findTriplet(int[] a, int sum) {
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        findTriplet(0,a,sum,list,finalList);
        return finalList;

    }

    private static void findTriplet(int i, int[] a, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> finalList) {

        if (sum==0 && list.size()==3)
        {
            finalList.add(new ArrayList<>(list));
            return;
        }

        if (i==a.length || list.size()==3)
            return;

        if (sum-a[i]>=0) //if want to consider curr ele
        {
            list.add(a[i]); //choose
            findTriplet(i+1,a,sum-a[i],list,finalList); //explore
            list.remove(list.size()-1); //un-choose
        }

        findTriplet(i+1,a,sum,list,finalList); //without considering curr ele

    }
}
