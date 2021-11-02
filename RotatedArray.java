public class RotatedArray {
    public static void main(String[] args) {
        int[] arr = {3,4,1,2};
        int key = 2;
        System.out.println(findSmallestIndex(arr));


    }

    private static boolean isKeyPresent(int[] arr, int key) {
        int smallestElePos = findSmallestIndex(arr);
        if (arr[smallestElePos]==key)
            return true;

        return binarySearch(0,smallestElePos-1,arr,key) || binarySearch(smallestElePos+1,arr.length-1,arr,key);
    }

    private static boolean binarySearch(int l, int h, int[] arr, int key) {

        while (l<=h)
        {
            int mid = l+(h-l)/2;
            if (arr[mid]==key)
                return true;
            if (key>arr[mid])
                l=mid+1;
            else
                h=mid-1;
        }
        return false;
    }

    private static int findSmallestIndex(int[] arr) {
        int l = 0;
        int h = arr.length-1;
        while (l<=h && !(arr[(l+(h-l)/2)]<arr[((l+(h-l)/2)+arr.length-1)%arr.length] && arr[(l+(h-l)/2)]<arr[((l+(h-l)/2)+1)%arr.length]))
        {
            if (arr[(l+(h-l)/2)]<arr[h]) //moving to unsorted side or side which is less than mid
                h=(l+(h-l)/2)-1;
            else
                l=(l+(h-l)/2)+1;
        }
        return (l+(h-l)/2);

    }
}
