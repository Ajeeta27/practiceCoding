import java.util.Arrays;

class Pair {
    boolean key;
    int value;

    public boolean getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

}

class Solution {
    int globalCount = -1;

    Pair solutionCheck(int index, int s, int[] prices, Pair[][] dp) {
        Pair p = new Pair();
        ;
        if (s == 0) {

            p.key = true;
            p.value = 0;
            return p;
        }

        if (index >= prices.length) {

            p.key = false;
            p.value = -1;
            return p;

        }

        if (dp[index][s].value != -2) {
            return dp[index][s];
        }

        Pair select = new Pair();
        ;
        Pair notSelect = new Pair();
        ;

        if (prices[index] <= s) {
            select = solutionCheck(index + 1, s - prices[index], prices, dp);
            select.value = select.getValue() + 1;

        }

        notSelect = solutionCheck(index + 1, s, prices, dp);

        if (select.getKey() && notSelect.getKey()) {

            p.key = true;
            p.value = Math.max(select.getValue(), notSelect.getValue());
            // return p;
        } else if (select.getKey()) {

            p.key = true;
            p.value = select.getValue();
            // return p;
        } else if (notSelect.getKey()) {

            p.key = true;
            p.value = notSelect.getValue();
            // return p;
        } else {
            p.key = false;
            p.value = -1;
            // return p;
        }

        // when both child is not able to get cakes in budget
        dp[index][s] = p;
        return p;

        // dp[index][(int)s] = globalCount;

    }

    int solution(int n, int s, int[] price) {

        Pair[][] dp = new Pair[n][s + 1];
        Pair p = new Pair();
        p.key = false;
        p.value = -2;
        for (var it : dp) {
            Arrays.fill(it, p);
        }

        int index = 0;
        Pair res = solutionCheck(index, s, price, dp);

        return res.value;
    }

}

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int s = 10;
        int n = 5;
        int[] input = { 2, 5, 3, 6, 4 };

        int res = sol.solution(n, s, input);

        System.out.println("globalCount.  " + res);

        Solution sol2 = new Solution();

        int s2 = 10;
        int n2 = 6;
        int[] input2 = { 2, 5, 3, 6, 2, 1 };

        int res2 = sol2.solution(n2, s2, input2);

        System.out.println("globalCount.  " + res2);

        Solution sol3 = new Solution();

        int s3 = 10;
        int n3 = 5;
        int[] input3 = { 1, 0, 3, 1, 4 };

        int res3 = sol3.solution(n3, s3, input3);

        System.out.println("globalCount4.  " + res3);

        Solution sol4 = new Solution();

        int s4 = 12;
        int n4 = 8;
        int[] input4 = { 3, 3, 3, 4, 4, 4, 4, 3 };

        int res4 = sol4.solution(n4, s4, input4);

        System.out.println("globalCount4.  " + res4);

        Solution sol5 = new Solution();

        int s5 = 5;
        int n5 = 8;
        int[] input5 = { 5, 6, 6, 6, 6, 6, 6, 6 };

        int res5 = sol5.solution(n5, s5, input5);

        System.out.println("globalCount5.  " + res5);

        System.out.println("Hello World");
    }
}
