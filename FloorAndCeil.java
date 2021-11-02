public class FloorAndCeil {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,10,10,12,19};
        int key = 11;
        minDiffToKeyEle(key,arr);

    }

    private static void minDiffToKeyEle(int key, int[] arr) {
        int l = 0;
        int h = arr.length-1;
        while (l<=h)
        {
            int mid = l+(h-l)/2;
            if (arr[mid]==key)
            {
                arr[l]=key;
                arr[h]=key;
                break;
            }
            else if (key<arr[mid])
                h=mid-1;
            else
                l=mid+1;
        }

        System.out.println(Math.min(Math.abs(arr[l]-key),Math.abs(arr[h]-key)));
    }




    private static int findCeil(int[] arr, int key) {
        int l = 0;
        int h = arr.length-1;
        int candidate = Integer.MAX_VALUE;

        while (l<=h)
        {
            int mid = l+(h-l)/2;
            if (arr[mid]==key)
                return key;
            else if (arr[mid]>key)
            {
                if (candidate>arr[mid])
                    candidate=arr[mid];
                h=mid-1;
            }
            else
                l=mid+1;
        }

        return candidate;
    }

    private static int findFloor(int[] arr, int key) {
        int l = 0;
        int h = arr.length-1;
        int candidate = Integer.MIN_VALUE;
        while (l<=h)
        {
            int mid = l+(h-l)/2;
            if (arr[mid]==key)
                return key;
            else if (arr[mid]<key)
            {
                if (candidate<arr[mid])
                    candidate=arr[mid];
                l=mid+1;
            }
            else
                h=mid-1;
        }
        return candidate;

    }
}
