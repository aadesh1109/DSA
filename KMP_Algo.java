import java.lang.reflect.Array;
import java.util.Arrays;

public class KMP_Algo {
    public static void main(String[] args) {
        String toSearch = "acacabacacabacacac";
        int[] arr = new int[toSearch.length()];
        int i = 0;
        for (int j = 1; j < toSearch.length() ; j++) {
            if (toSearch.charAt(i)==toSearch.charAt(j))
            {
                arr[j]=i+1;
                i++;
            }
            else
            {
                if (i>0)
                {
                    while (toSearch.charAt(j)!=toSearch.charAt(i))
                    {
                        if (i==0)
                        { break;}
                        i=arr[i-1];
                    }
                    if (i==0 && toSearch.charAt(i)!=toSearch.charAt(j))
                        arr[j]=0;
                    else
                        arr[j]=i+1;
                    i=0;
                }


            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
