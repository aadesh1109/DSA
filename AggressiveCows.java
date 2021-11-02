import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] barn = {9,12};
        int cows = 2;
        Arrays.sort(barn);
        int minDis = 1;
        int min = Integer.MAX_VALUE;
        int maxDis = barn[barn.length-1]-barn[0];
        while (minDis<=maxDis)
        {
            int midDis = (minDis+maxDis)/2;
            int getMinMaxDis = get(midDis,barn,cows);
            if (getMinMaxDis==-1)
            {
                maxDis=midDis-1;
            }
            else
            {
                minDis=midDis+1;
                min=getMinMaxDis;

            }
        }
        System.out.println(min);
    }

    private static int get(int midDis, int[] barn,int cows) {
        List<Integer> list = new ArrayList<>();
        list.add(barn[0]);
        list.add(barn[barn.length-1]);
        int sum = 0; int c =2;
        for (int i = 1; i < barn.length ; i++) {
            if (c==cows)
                break;
            sum+=barn[i]-barn[i-1];
            if (sum>midDis)
            {
                sum=barn[i]-barn[i-1];
                c++;
                list.add(barn[i-1]);
            }
        }
        if (c!=cows)
            return -1;
        else
        {
            Collections.sort(list);
            for (int i:
                 list) {
                System.out.print(i + " ");
            }
            int minDiff = Integer.MAX_VALUE;
            for (int i = 1; i < list.size() ; i++) {
                if (minDiff>list.get(i)-list.get(i-1))
                {minDiff = list.get(i)-list.get(i-1);
                }
            }
            System.out.println(": " +minDiff);
            return minDiff;
        }

    }
}
