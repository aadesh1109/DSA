public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {2, 4, 10, 10, 10, 10, 10, 18, 20, 20, 20};
        int key = 10;
        int firstOccurrence = findFirstOccurrence(arr, key);
        int lastOccurrence = findLastOccurrence(arr, key);
        System.out.println(firstOccurrence + " " + lastOccurrence);
        System.out.println("count = " + (lastOccurrence - firstOccurrence + 1));

    }

    private static int findLastOccurrence(int[] arr, int key) {
        int lastOccurrence = Integer.MIN_VALUE;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                lastOccurrence = mid;
            }

            if (key >= arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return lastOccurrence;

    }

    private static int findFirstOccurrence(int[] arr, int key) {
        int firstOccurrence = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                firstOccurrence = mid;
            }

            if (key <= arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return firstOccurrence;


    }
}
