import java.util.Arrays;
//finding max profit by buying and selling stock only 1 time

public class StocksBuyAndSellToMaximiseProfit {
    public static void main(String[] args) {
        int[] stockPrice = {3, 1, 4, 8, 7, 2, 5};
        int profit = findMaxProfit(stockPrice);
        System.out.println(profit);
    }

    private static int findMaxProfit(int[] stockPrice) { //time complexity-O(n)...space complexity-O(1)
        int maxDiff = 0;
        int maxPriceSoFarFromRight = stockPrice[stockPrice.length - 1]; //can also be done from left by minPriceSoFarFromLeft and starting loop from 1 to n
        for (int i = stockPrice.length - 2; i >= 0; i--) {
            maxPriceSoFarFromRight = Math.max(stockPrice[i], maxPriceSoFarFromRight);
            maxDiff = Math.max(maxPriceSoFarFromRight - stockPrice[i], maxDiff);
        }
        return maxDiff;
    }

//    private static int findMaxProfit(int[] stockPrice) { //DYNAMIC PROGRAMMING APPROACH...time complexity-O(n), space complexity-O(n)
//        int[] maxSoFarFromRight = new int[stockPrice.length];
//        maxSoFarFromRight[maxSoFarFromRight.length-1]=stockPrice[stockPrice.length-1];
//        for (int i = maxSoFarFromRight.length-2; i >=0 ; i--) {
//            maxSoFarFromRight[i] = Math.max(stockPrice[i], maxSoFarFromRight[i + 1]);
//        }
//        int maxDiffBetweenPrices = Integer.MIN_VALUE;
//        for (int i = 0; i < stockPrice.length; i++) {
//            maxDiffBetweenPrices = Math.max(maxDiffBetweenPrices,maxSoFarFromRight[i]-stockPrice[i]);
//        }
//        return maxDiffBetweenPrices;
//    }

//    private static int findMaxProfit(int[] stockPrice) { //time complexity-O(n2)...space complexity-O(1)
//        int maxDiffBetweenPrices = Integer.MIN_VALUE;
//        for (int buy = 0; buy < stockPrice.length; buy++) {
//            for (int sell = buy; sell < stockPrice.length ; sell++) {
//                if (maxDiffBetweenPrices<stockPrice[sell]-stockPrice[buy])
//                    maxDiffBetweenPrices = stockPrice[sell]-stockPrice[buy];
//            }
//        }
//        return maxDiffBetweenPrices;
//    }
}
