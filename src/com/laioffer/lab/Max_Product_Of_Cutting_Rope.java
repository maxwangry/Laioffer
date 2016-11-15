package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/10/26.
 */
public class Max_Product_Of_Cutting_Rope {

    public static int maxProduct(int length) {
        if (length <= 0) {
            return 0;
        }
        int[] dp = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * (i - j));
            }
        }
        return dp[length];
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(0));
        System.out.println(maxProduct(1));
        System.out.println(maxProduct(2));
        System.out.println(maxProduct(3));
        System.out.println(maxProduct(4));
        System.out.println(maxProduct(5));
        System.out.println(maxProduct(6));
        System.out.println(maxProduct(12));
    }
}
