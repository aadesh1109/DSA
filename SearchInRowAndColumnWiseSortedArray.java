public class SearchInRowAndColumnWiseSortedArray {
    public static void main(String[] args) {
        int[][] arr = {{10, 20, 30, 40},
                       {15, 25, 35, 45},
                       {27, 29, 37, 48},
                       {32, 33, 39, 50}
        };
        int key = 28;
        System.out.println(search(arr,key));
    }

    private static boolean search(int[][] arr, int key) {
        int i = 0;
        int j = arr.length-1;
        while (i<arr.length && j>=0)
        {
            if (arr[i][j]==key)
                return true;
            else if (key>arr[i][j])
                i++;
            else
                j--;
            }
        return false;
        }

    }
