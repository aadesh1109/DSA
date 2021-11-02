import java.util.Arrays;

public class _3_PartitionProblem {
    public static void main(String[] args) {
        int[] S = {7, 3, 2, 1, 5, 4, 8};
        if (!printAll3Partitions(S))
            System.out.println("Can't be partitioned");
    }

    private static boolean printAll3Partitions(int[] a) {
        if (a.length < 3)
            return false;
        int sum = Arrays.stream(a).sum();
        return (sum % 3 == 0) && printAll3Partitions(0, a, sum / 3, sum / 3, sum / 3, new int[a.length]);
    }

    private static boolean printAll3Partitions(int i, int[] a, int s1, int s2, int s3, int[] containsInListNo) {
        if (s1 < 0 || s2 < 0 || s3 < 0)
            return false;

        if (s1 == 0 && s2 == 0 && s3 == 0) {
            System.out.println(Arrays.toString(containsInListNo));
            return true;
        }

        if (i == a.length)
            return false;


        containsInListNo[i] = 1;
        boolean inc1 = printAll3Partitions(i + 1, a, s1 - a[i], s2, s3, containsInListNo);
        if (inc1)
            return true;


        containsInListNo[i] = 2;
        boolean inc2 = printAll3Partitions(i + 1, a, s1, s2 - a[i], s3, containsInListNo);
        if (inc2)
            return true;


        containsInListNo[i] = 3;
        return printAll3Partitions(i + 1, a, s1, s2, s3 - a[i], containsInListNo);
    }

//    private static boolean printAll3Partitions(int[] a) {
//        if (a.length < 3)
//            return false;
//        int sum = Arrays.stream(a).sum();
//        return (sum % 3 == 0) && printAll3Partitions(0, a, sum / 3, sum / 3, sum / 3, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
//    }
//
//    private static boolean printAll3Partitions(int i, int[] a, int s1, int s2, int s3, ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> list3) {
//        if (s1 < 0 || s2 < 0 || s3 < 0)
//            return false;
//
//        if (s1 == 0 && s2 == 0 && s3 == 0) {
//            System.out.println(list1);
//            System.out.println(list2);
//            System.out.println(list3);
//            return true;
//        }
//
//        if (i == a.length)
//            return false;
//
//
//        list1.add(a[i]);
//        boolean inc1 = printAll3Partitions(i + 1, a, s1 - a[i], s2, s3, list1, list2, list3);
//        list1.remove(list1.size() - 1);
//
//        boolean inc2 = false;
//        list2.add(a[i]);
//        if (!inc1)
//            inc2 = printAll3Partitions(i + 1, a, s1, s2 - a[i], s3, list1, list2, list3);
//        list2.remove(list2.size() - 1);
//
//        boolean inc3 = false;
//        list3.add(a[i]);
//        if (!inc1 && !inc2)
//            inc3 = printAll3Partitions(i + 1, a, s1, s2, s3 - a[i], list1, list2, list3);
//        list3.remove(list3.size() - 1);
//
//        return inc1 || inc2 || inc3;
//    }

    private static boolean partition(int[] a) {
        if (a.length < 3)
            return false;
        int sum = Arrays.stream(a).sum();
        return (sum % 3 == 0) && partition(0, a, sum / 3, sum / 3);
    }

    private static boolean partition(int i, int[] a, int s1, int s2) {
        if (s1 < 0 || s2 < 0)
            return false;

        if (s1 == 0 && s2 == 0)
            return true;

        if (i == a.length)
            return false;

        return partition(i + 1, a, s1 - a[i], s2) || partition(i + 1, a, s1, s2 - a[i]) || partition(i + 1, a, s1, s2);
    }

    private static boolean partition(int i, int[] a, int s1, int s2, int s3) {
        if (s1 < 0 || s2 < 0 || s3 < 0)
            return false;

        if (i == a.length) {
            return s1 == 0 && s2 == 0 && s3 == 0;
        }

        return partition(i + 1, a, s1 - a[i], s2, s3) || partition(i + 1, a, s1, s2 - a[i], s3) || partition(i + 1, a, s1, s2, s3 - a[i]);

    }
}
