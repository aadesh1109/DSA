public class GasStationProblem {
    public static void main(String[] args) {
        int[] gas  = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int surplus = 0;
        int deficit = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            if(gas[i]-cost[i]<0)
            {
                start++;
                deficit+=gas[i]-cost[i];

            }
            else
                surplus+=gas[i]-cost[i];

        }

        return (surplus+deficit>=0)?start:-1;


    }
}
