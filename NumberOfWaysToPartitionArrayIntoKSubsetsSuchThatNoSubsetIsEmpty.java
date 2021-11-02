public class NumberOfWaysToPartitionArrayIntoKSubsetsSuchThatNoSubsetIsEmpty {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int k =2;
        int ways = findNumberOfWaysToPartition(arr,k);
        System.out.println(ways);
    }

    private static int findNumberOfWaysToPartition(int[] arr, int k) {
        return findNumberOfWaysToPartition(0,arr,k,0);
    }

    private static int findNumberOfWaysToPartition(int start, int[] arr, int k, int count) {
        if (start==arr.length){
            if (k==0)
                return count+1;
            return count;
        }

        for (int i = start; i < arr.length ; i++) {
            count = findNumberOfWaysToPartition(i+1,arr,k-1,count);
        }
        return count;
    }
}
