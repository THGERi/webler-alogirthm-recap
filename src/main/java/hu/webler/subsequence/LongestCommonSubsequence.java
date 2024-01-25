package hu.webler.subsequence;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "ABCD";
        String str2 = "ACDF";

        int result = longestCommonSubsequence(str1, str2);

        int commonLetters = findCommonLetters(str1, str2);

        System.out.println("Length of Longest Common Subsequence: " + result);
        System.out.println("Number of common letters: " + commonLetters);
    }

    private static int longestCommonSubsequence(String str1, String str2) {
        // Meghatározzuk a két sztring hosszát
        int m = str1.length();
        int n = str2.length();

        // Két dimenziós tömb a megoldás tárolására
        int[][] dp = new int[m + 1][n + 1];

        // Dinamikus programozás: a Longest Common Subsequence hosszát számoljuk
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // Az első sor és oszlop értéke mindig 0, mivel üres sztringgel nincs közös részsorozat
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                // Ha a karakterek egyeznek, növeljük a közös részsorozat hosszát
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // Ha a karakterek nem egyeznek, akkor az előző sor vagy oszlop eredményéből vesszük a nagyobbat
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // A dinamikus programozás során kapott eredmény, az LCS hossza
        return dp[m][n];
    }

    private static int findCommonLetters(String str1, String str2) {
        // Convert string to lowercase to make the comparison case-insensitive
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // Use a HashSet to store the common letters
        Set<Character> uniqueLetters = new HashSet<>();
        for (char c: str1.toCharArray()) {
            uniqueLetters.add(c);
        }

        // count the common letters in str2 by checking if each letters is in the HashSet
        int count = 0;
        for (char c : str2.toCharArray()) {
            if (uniqueLetters.contains(c)) {
                count++;
                // remove letter from the HashSet to avoid counting it twice
                uniqueLetters.remove(c);
            }
        }
        return count;
    }
}