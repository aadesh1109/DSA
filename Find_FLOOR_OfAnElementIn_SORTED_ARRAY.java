public class Find_FLOOR_OfAnElementIn_SORTED_ARRAY {
    public static void main(String[] args) {
        int ele = 0;
        int[] arr = {1,2,3,4,5,8,10,12,19,21,27,31};
        int floor = findFloor(arr, ele);
        System.out.println(floor);
    }

    private static int findFloor(int[] arr, int ele) {
        int low = 0;
        int high = arr.length-1;
        while (low<=high)
        {
            int mid = low+(high-low)/2;
            if (arr[mid]==ele)
                return ele;
            else if (arr[mid]<ele)
            {
                low=mid+1;
            }
            else
                high=mid-1;
        }
        if (high==-1)
            return -1;

        return arr[high];
    }
}
