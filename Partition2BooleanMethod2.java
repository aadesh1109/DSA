import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition2BooleanMethod2 {
    public static void main(String[] args) {
        int[] A = {1,5,11,5};
        int sum = Arrays.stream(A).sum();
        boolean res = findPartitions(A, sum/2, sum/2, 0);
        System.out.println(res);
    }

    private static boolean findPartitions(int[] A, int s1, int s2, int index) {
        if(index == A.length){
            if(s1 == 0 && s2 == 0){

                return true;
            }
            return false;
        }
        boolean inc1 = false;
        boolean inc2 = false;
        if (s1-A[index]>=0)
            inc1 = findPartitions(A, s1-A[index], s2, index+1);

        if(inc1)
            return true;

        if (s2-A[index]>=0)
            inc2 = findPartitions(A, s1, s2-A[index], index+1);

        return inc2;


    }
}