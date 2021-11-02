public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-27,-4,-2,-1,0,3,7,10,11,16,19};
        int key = 0;
        int foundAt = searchForKeyRecursively(arr,key);
        if (foundAt == -1)
            System.out.println("Not found!");
        else
            System.out.println("Found at : "+foundAt);
    }

    private static int searchForKeyRecursively(int[] arr, int key) {
        return searchForKeyRecursivelyHelper(0,arr.length-1,arr,key);
    }

    private static int searchForKeyRecursivelyHelper(int low, int high, int[] arr, int key) {
        if (low>high)
            return -1;
        int mid = low+(high-low)/2;
        if (arr[mid]==key)
        {
            return mid;
        }
        else if (arr[mid]>key)
            return searchForKeyRecursivelyHelper(low,mid-1,arr,key);
        else
            return searchForKeyRecursivelyHelper(mid+1,high,arr,key);
    }

    private static int searchForKey(int[] arr, int key) { //iterative search
        int low = 0;
        int high = arr.length-1;
        while (low<=high)
        {
            int mid = low+(high-low)/2;
            if (arr[mid]==key)
                return mid;
            else if (arr[mid]>key)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
}
