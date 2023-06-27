import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Harshil Kachhadiya

public class Solution {

    // max profit problem
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];

        buy[0] = -prices[0];

        sell[0] = 0;

        for (int i = 1; i < n; i++) {

            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);

            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
            System.out.print("\nsell" + sell[i]);
        }
        System.out.print("\nfianl" + sell[n - 1]);
        return sell[n - 1];
    }

    // two sum problem
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            System.out.println(complement);
            System.out.println(map.containsKey(complement));
            
            if (map.containsKey(complement)) {
                System.out.println("hh  "+map.get(complement));
                return new int[]{map.get(complement), i};
            }
            System.out.println("kk  "+nums[i]+"--"+i);
            
            map.put(nums[i], i);
        }

        System.out.println("return  "+new int[]{});

        return new int[]{};
    }

    public static void main(String[] args) {
        // max profit sum
        // int[] prices = { 1,3,7,5,10,3};
        // int fee = 3;
        // int maxProfit = maxProfit(prices, fee);
        // System.out.println("Maximum profit: " + maxProfit); // Output: 8

        // two sum problem
        int[] nums = {2,7,9,10,11};
        int target = 13;
        int[] result = twoSum(nums, target);
  
        System.out.println("Output: [" + result[0] + ", " + result[1] + "]");

    }

}
