package lab2;

public class LIS {

    public static int longueurLIS(int[] t) {

        if (t.length == 0) {
            return 0;
        }

        int[] dp = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < t.length; i++) {

            for (int j = 0; j < i; j++) {

                if (t[j] < t[i]) {

                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }

        
        int resultat = 0;

        for (int i = 0; i < dp.length; i++) {

            if (dp[i] > resultat) {
                resultat = dp[i];
            }
        }

        return resultat;
    }

    public static void main(String[] args) {

        int[][] tests = {
            {},                              // tableau vide
            {5},                             // un seul élément
            {5, 4, 3, 2, 1},                 // décroissant
            {1, 2, 3, 4, 5},                 // croissant
            {2, 1, 4, 2, 3, 5, 1, 7},        // exemple donné
            {3, 3, 3, 3},                    // tous égaux
            {10, 9, 2, 5, 3, 7, 101, 18}     // exemple classique
        };

        for (int[] t : tests) {

            System.out.println("LIS = " + longueurLIS(t));

        }
    }
}