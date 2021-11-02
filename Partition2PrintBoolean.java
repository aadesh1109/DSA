import java.util.*;
public class Partition2PrintBoolean {
    public static void main(String[] args) {

        int[] A = {3,1,1,2,2,1};
        int sum = Arrays.stream(A).sum();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        boolean res = findPartitions(A, sum/2, sum/2, 0, list1, list2);
        System.out.println(res);

    }

    private static boolean findPartitions(int[] A, int s1, int s2, int index, List<Integer> list1, List<Integer> list2) {
        if(s1 < 0 || s2 < 0)
            return false;

        if(index == A.length){
            if(s1 == 0 && s2 == 0){
                System.out.println(list1);
                System.out.println(list2);
                return true;
            }
            return false;
        }

        //can be include in s1
        list1.add(A[index]);
        boolean inc1 = findPartitions(A, s1-A[index], s2, index+1, list1, list2);
        list1.remove(list1.size()-1);

        if(inc1)
            return true;

        //can be included in s2
        list2.add(A[index]);
        boolean inc2 = findPartitions(A, s1, s2-A[index], index+1, list1, list2);
        list2.remove(list2.size()-1);

        return inc2;
    }
}