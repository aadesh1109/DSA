public class FindNoOfTimesArrayRotated {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 1, 2, 3, 4};
        int rotatedTimes = findSmallestIndex(arr);
        System.out.println(rotatedTimes);
    }

    private static int findSmallestIndex(int[] arr) {
        if (arr.length == 1)
            return 0;
        if (arr.length == 0)
            return -1;
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int nextToMid = (mid + 1) % arr.length; // this modulo is done here to prevent out of bounds exception
            int prevToMid = (mid - 1 + arr.length) % arr.length; // // this modulo is done here to prevent out of bounds exception
            if (arr[mid] < arr[prevToMid] && arr[mid] <= arr[nextToMid])
                return mid;
            if (arr[mid] < arr[h])
                h = mid - 1;
            else
                l = mid + 1;
        }
        return -1;

    }
}
