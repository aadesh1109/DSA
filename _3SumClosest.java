public class _3SumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums,1));

    }
    public static int threeSumClosest(int[] nums, int target) {
        int[] res = new int[2];
        res[1] =Integer.MAX_VALUE;
        threeSumClosest(0,nums,0,target,res,0);
        return res[0];
    }

    private static void threeSumClosest(int i, int[] nums, int sum , int target, int[] res , int selected) {

        if (selected==3)
        {
            if (Math.abs(target-sum)<res[1])
            {
                res[0]=sum;
                res[1]=Math.abs(target-sum);
            }
            return;
        }

        if (i==nums.length)
            return;


        if (selected+1<=3)
            threeSumClosest(i+1,nums,sum+nums[i],target,res,selected+1);

        threeSumClosest(i+1,nums,sum,target,res,selected);

    }
}
