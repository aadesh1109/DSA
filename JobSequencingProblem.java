import java.util.*;

public class JobSequencingProblem {
    public static void main(String[] args) {
        Job[] arr = new Job[]{
                new Job(6,2,80),
                new Job(3,6,70),
                new Job(4,6,65),
                new Job(2,5,60),
                new Job(5,4,25),
                new Job(8,2,22),
                new Job(1,4,20),
                new Job(7,2,10)
        };
        int[] countAndSum = JobScheduling(arr, arr.length);
        System.out.println(countAndSum[0]+" "+countAndSum[1]);

    }

   private static  int[] JobScheduling(Job[] arr, int n)
    {
        int[] countAndSum = new int[2];
        Arrays.sort(arr, (o1, o2) -> o2.profit-o1.profit);
        int count=0,profit=0;
        int maxDeadline = 0;
        for (Job j : arr) {
            maxDeadline=Math.max(maxDeadline,j.deadline);
        }
        int[] slots = new int[maxDeadline+1];
        for (Job j : arr) {
            int i= j.deadline;
            while (i>0 && slots[i]==1)
            {
                i--;
            }
            if (i!=0)
            {
                slots[i]=1;
                count++;
                profit+=j.profit;
            }
        }
        countAndSum[0]=count;
        countAndSum[1]=profit;
        return countAndSum;
    }
}

class Job{
    int id,deadline,profit;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.profit = profit;
        this.deadline = deadline;
    }
}
