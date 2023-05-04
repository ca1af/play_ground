package com.example.play_ground.find_algorithm;

import java.util.Arrays;

public class DynamicProgramming {
    public int fibonacciTabulation(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    public int fibonacciMemoization(int n){
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return fibonacciMemoizationHelper(n, memo);
    }

    public int fibonacciMemoizationHelper(int n, int[] memo){
        if (n <= 1){
            return n;
        }
        if (memo[n] != -1){
            return memo[n];
        }
        memo[n] = fibonacciMemoizationHelper(n-1, memo) + fibonacciMemoizationHelper(n-2, memo);
        return memo[n];
    }
}
