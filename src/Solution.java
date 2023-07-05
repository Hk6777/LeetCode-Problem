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
                System.out.println("hh  " + map.get(complement));
                return new int[] { map.get(complement), i };
            }
            System.out.println("kk  " + nums[i] + "--" + i);

            map.put(nums[i], i);
        }

        System.out.println("return  " + new int[] {});

        return new int[] {};
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            System.out.println(val1 + "--" + val2);
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            int remainder = sum % 10;
            System.out.println(carry + "++" + remainder);

            curr.next = new ListNode(remainder);
            curr = curr.next;

            if (l1 != null)
                l1 = l1.next;

            if (l2 != null)
                l2 = l2.next;
        }

        return dummy.next;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    // palindron numbner
    public static boolean isPalindrome(int x) {

        int x2 = reverse(x);

        if (x == x2) {
            return true;
        }

        return false;

    }

    public static int reverse(int n) {

        int rev = 0;
        int rem;
        while (n > 0) {

            rem = n % 10;

            rev = (rev * 10) + rem;
            n = n / 10;
            System.out.println("rem=" + rem + " rev=" + rev + " n=" + n);

        }
        return rev;
    }

    // Longest Common Prefix
    public static String longestCommonPrefix(String[] strs) {

        if(strs == null && strs.length == 0 ){
            return "";
        }

        String shortest = strs[0];
        System.out.println(shortest);

        for(String str:strs){

            if(str.length() < shortest.length()){

                shortest = str;
            }
        }
        System.out.println(shortest);

        for(int i =0; i< shortest.length();i++){

            char c = shortest.charAt(i);
            System.out.println(c);

            for(String str : strs){

                System.out.println("="+str.charAt(i));

                if(str.charAt(i) != c){

                    return shortest.substring(0, i);

                }
            }

        }
        return shortest;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // max profit sum
        // int[] prices = { 1,3,7,5,10,3};
        // int fee = 3;
        // int maxProfit = maxProfit(prices, fee);
        // System.out.println("Maximum profit: " + maxProfit); // Output: 8

        // two sum problem
        // int[] nums = {2,7,9,10,11};
        // int target = 13;
        // int[] result = twoSum(nums, target);

        // System.out.println("Two Sum Output: [" + result[0] + ", " + result[1] + "]");

        // two sum
        // ListNode l1 = new ListNode(2);
        // l1.next = new ListNode(4);
        // l1.next.next = new ListNode(3);

        // ListNode l2 = new ListNode(5);
        // l2.next = new ListNode(6);
        // l2.next.next = new ListNode(4);

        // ListNode result = addTwoNumbers(l1, l2);
        // while (result != null) {
        // System.out.print(result.val + " ");
        // result = result.next;
        // }

        // palindron number
        // boolean presult = isPalindrome(2345);
        // System.out.println(presult);

        // ongest common prefix
        // String[] strs1 = { "flower", "flow", "flight" };
        // System.out.println(longestCommonPrefix(strs1));
    }

}
