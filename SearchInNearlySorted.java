public class SearchInNearlySorted {
    public static void main(String[] args) {
        int[] arr =  {10, 3, 40, 20, 50, 80, 70};
        int key = 70;
        System.out.println(search(arr,key));
    }

    private static int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length-1;
        while (low<=high)
        {
            int mid = low+(high-low)/2;
            if (arr[mid]==key)
                return mid;
            if (mid-1>=low && arr[mid-1]==key)
                return mid-1;
            if (mid+1<=high && arr[mid+1]==key)
                return mid+1;
            if (key<arr[mid])
                high=mid-2;
            else
                low=mid+2;

        }
        return -1;
    }
}
