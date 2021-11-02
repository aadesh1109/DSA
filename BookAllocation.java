import java.util.ArrayList;
import java.util.Arrays;

public class BookAllocation {
    public static void main(String[] args) {
        int[] books = {10,20,30,40};
        int students = 2;
        System.out.println(booksAllocate(books,students));
        ArrayList<Integer> list = new ArrayList<>();
    }

    private static int booksAllocate(int[] books, int students) {

        int minimum = Integer.MAX_VALUE;
        int low = Arrays.stream(books).max().getAsInt();
        int high = Arrays.stream(books).sum();

        if (books.length<students)
            return -1;

        while (low<=high)
        {
            int mid = low+(high-low)/2;
            if (studentsAllocationFeasibility(mid,books,students))
            {
                minimum=Math.min(minimum,mid);
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return minimum;
    }

    private static boolean studentsAllocationFeasibility(int mid, int[] books, int students) {
        int stud = 1;
        int maxPages = 0;
        for (int i = 0; i < books.length ; i++) {

            maxPages+=books[i];

            if (maxPages>mid)
            {
                stud++;
                maxPages=books[i];
            }

            if (stud>students)
                return false;
        }
        return true;
    }
}