import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PeakElement {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,1));
        System.out.println(solve(list));
    }

    public static int solve(ArrayList<Integer> A) {
        if (A.size() == 1)
            return A.get(0);
        int low = 0;
        int high = A.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && mid < A.size() - 1) {
                if (A.get(mid) > A.get(mid + 1) && A.get(mid) > A.get(mid - 1))
                    return A.get(mid);
                if (A.get(mid + 1) > A.get(mid - 1))
                    low = mid + 1;
                else
                    high = mid - 1;
            } else if (mid == 0) {
                if (A.get(mid) > A.get(mid + 1))
                    return A.get(mid);
                else
                    low = mid + 1;
            } else {
                if (A.get(mid) > A.get(mid - 1))
                    return A.get(mid);
                else
                    high = mid - 1;
            }
        }
        return 0;
    }
}
