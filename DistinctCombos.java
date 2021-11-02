import java.util.ArrayList;
import java.util.Arrays;

public class DistinctCombos {
    public static void main(String[] args) {
        int[] arr = {0,1,2};
        int k =3;
        Arrays.sort(arr);
        generate(0,arr,k,new ArrayList<>());
        /*
        000 001 002 011 012 022 111 112 122 222
        */
    }

    private static void generate(int i , int[] arr, int k ,ArrayList<Integer> list) {


        if (list.size()==k)
        {
            System.out.println(list);
            return;
        }

        for (int j = i; j < arr.length ; j++)
        {
            /*while (j<arr.length-1 && arr[j]==(arr[j+1]))
            {
                j++;
            }*/

            list.add(arr[j]);
            generate(j,arr,k,list);
            list.remove(list.size()-1);
        }
    }
}
