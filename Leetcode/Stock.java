// You are given an array prices where prices[i] is the price of a given stock on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day 
// in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

package Leetcode;

public class Stock {

    public static int maxProfit(int[] prices) {

        // Initially set minPrice to largest num
        // -> We want the first stock price we encounter to become the min
        int minPrice = Integer.MAX_VALUE;
        // If no money is made, return 0
        int maxProfit = 0;

        // Take each piece from the prices array, one at a time and store it in the variable price
        for (int price : prices) {
            // Lowest buying price so far
            minPrice = Math.min(minPrice, price);

            // Profit if we sell today
            int profit = price - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        int[] prices1 = {7, 1, 5, 3, 2, 4};
        int[] prices2 = {7, 5, 4, 6, 1};
        int[] prices3 = {2, 4, 1, 7};

        System.out.println(maxProfit(prices1));

        System.out.println("\n" + maxProfit(prices2));

        System.out.println("\n" + maxProfit(prices3));
    }
    
}
