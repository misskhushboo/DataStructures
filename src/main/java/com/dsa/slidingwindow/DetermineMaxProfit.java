package com.slidingwindow;


/**
 * You have an array of prices where each element prices[i] represents the price of a stock on day i.
 * You want to choose exactly one day to buy the stock and another (later) day to sell it in order to maximize your profit.
 * Your task is to return the maximum possible profit. If no profit can be made, return 0.
 * Example 1:
 * Input: prices = [8, 2, 5, 4, 11, 1]
 * Output: 9
 * Explanation:
 * The best strategy is to buy on day 2 (price = 2) and sell on day 5 (price = 11),
 * resulting in a profit of 11−2=9.
 * Example 2:
 * Input: prices = [5, 4, 3, 2, 1]
 * Output: 0
 * Explanation:
 * The prices only go down each day, so there is no chance to make a profit.
 * Hence, the maximum profit is 0.
 */
public class DetermineMaxProfit {

    public static void main(String[] args){
        new DetermineMaxProfit().determineMaxProfit(new int[]{8, 3, 5, 4, 2, 11, 1});
    }

    private void determineMaxProfit(int[] inputArray) {

        int profit=0;
        int buyDay=inputArray[0];

        for(int i=0 ; i<inputArray.length; i++){

            if(buyDay> inputArray[i] && inputArray[i]!=inputArray[inputArray.length-1] ){
                buyDay = inputArray[i];
            }
            if(profit < (inputArray[i] - buyDay))
                profit=inputArray[i] - buyDay;

        }
        System.out.println("Buy Day "+buyDay+ " | Profit="+profit);

    }
}
