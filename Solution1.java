import java.util.*;
public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i]=sc.nextInt();
        }
        int[] result = findLongConseqSeq(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findLongConseqSeq(int[] arr) {
        int[] out = new int[2];int maxDiff = 0;
        Set<Integer> set = new HashSet<>();
        for (int k : arr) {
            set.add(k);
        }
        /*        for (int j : arr) {
            if (set.contains(j-1))
                continue;
            int end = j + 1;
            while (set.contains(end))
                end++;
            if (end-1-j > maxDiff) {
                maxDiff = end-1-j;
                out[0] = j;
                out[1] = end-1;
            }
        }*/
        for (int i : set) {
            if (!set.contains(i-1))
            {
                int curr = i;
                while (set.contains(curr+1))
                    curr++;
                if (maxDiff<curr-i)
                {
                    maxDiff = curr-i;
                    out[0]=i;
                    out[1]=curr;
                }
            }
        }
        return out;
    }
}
