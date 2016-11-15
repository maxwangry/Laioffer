package com.laioffer.lab;

/**
 * Created by Ruoyu on 2016/10/28.
 */
public class Edit_Distance {

    public static int editDistance(String one, String two) {
        int[][] distance = new int[one.length() + 1][two.length() + 1]; // Including 0;
        for (int i = 0; i <= one.length(); i++) {
            for (int j = 0; j <= two.length(); j++) {
                if (i == 0) {
                    distance[i][j] = j;
                } else if (j == 0) {
                    distance[i][j] = i;
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    int case1 = 1 + distance[i - 1][j - 1];
                    int case2 = 1 + distance[i - 1][j];
                    int case3 = 1 + distance[i][j - 1];
                    distance[i][j] = Math.min(case1, Math.min(case2, case3));
                }
            }
        }
        return distance[one.length()][two.length()];
    }

    public static void main(String[] args) {
        System.out.print(editDistance("sigh", "asith"));
    }
}
