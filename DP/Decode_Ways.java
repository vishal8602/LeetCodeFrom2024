package DP;

class Solution {
    int dp[];

    public int dfs(String s, int index) {

        if (index == s.length())
            return 1;
        if (index > s.length() || s.charAt(index) == '0')
            return 0;
        if (dp[index] != 0)
            return dp[index];
        int ans = 0;
        ans += dfs(s, index + 1);
        if (index + 1 < s.length() && Integer.parseInt(s.substring(index, index + 2)) < 27)
            ans += dfs(s, index + 2);
        return dp[index] = ans;
    }

    public int iterative(String s) {

        int dp[] = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0')
                continue;
            dp[i] = dp[i + 1];
            if (i + 1 < s.length() && Integer.parseInt(s.substring(i, i + 2)) < 27) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }

    public int numDecodings(String s) {
        // dp=new int[s.length()];

        return iterative(s);
    }
}

public class Decode_Ways {
    public static void main(String[] args) {
        new Solution().numDecodings("1123");
    }
}
