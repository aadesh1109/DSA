//finding max profit by buying and selling stock any number of time.
public class StocksBuyAndSellToMaximiseProfit2 {
    public static void main(String[] args) {
        int[] stockPrice = {5, 2, 7, 3, 6, 1, 2, 4};
        int profit = findMaxProfit(stockPrice);
        System.out.println(profit);
    }

    private static int findMaxProfit(int[] stockPrice) {
        int low = stockPrice[0];
        int profit = 0;
        for (int i = 1; i < stockPrice.length; i++) {
            if (i + 1 == stockPrice.length) {
                if (stockPrice[i] < stockPrice[i - 1])
                    low = stockPrice[i];
                if (stockPrice[i] > stockPrice[i - 1])
                    profit += (stockPrice[i] - low);
            } else {
                if (stockPrice[i] < stockPrice[i - 1] && stockPrice[i] < stockPrice[i + 1])
                    low = stockPrice[i];
                if (stockPrice[i] > stockPrice[i - 1] && stockPrice[i] > stockPrice[i + 1])
                    profit += (stockPrice[i] - low);
            }
        }
        return profit;
    }
}
