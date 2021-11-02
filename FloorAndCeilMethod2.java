public class FloorAndCeilMethod2 {
    public static void main(String[] args) {
        int[] arr = {1,2,4,7,9,10,11,14,17};
        int key = 0;
        System.out.println(findFloor(arr,key));
    }

    private static int findFloor(int[] arr, int key) {
        int low = 0;
        int high = arr.length-1;
        while (low<high)
        {
            int mid = low+(high-low)/2;
            if (arr[mid]==key)
                return key;
            if (key<arr[mid])
                high=mid-1;
            else
                low=mid+1;
        }
        if (arr[low]>key )
        {
            if (low-1>=0)
                return arr[low-1];
            else
                return -1;
        }
        else
            return arr[low];

    }
}
