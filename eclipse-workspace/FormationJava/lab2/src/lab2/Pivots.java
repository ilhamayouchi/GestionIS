package lab2;

public class Pivots {

    public static void afficherPivots(int[] t) {

        int n = t.length;

        if (n < 3) {
            System.out.println("Aucun pivot");
            return;
        }
        // Déclaration de PrifixMax et suffixMin 
        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        prefixMax[0] = t[0];

        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], t[i]);
        }

        suffixMin[n - 1] = t[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], t[i]);
        }

        boolean chercher = false;

        System.out.print("Pivots : ");

        for (int i = 1; i < n - 1; i++) {

            if (prefixMax[i - 1] <= t[i]
                    && suffixMin[i + 1] >= t[i]) {
            	//Afficher les indices des pivots
            	System.out.print("(" + i + " : " + t[i] + ") ");
                chercher = true;
            }
        }

        if (!chercher) {
            System.out.println("Aucun pivot");
        }
    }
    
    public static void main(String[] args) {
        int[] t = {2, 4, 3, 5, 6};
        afficherPivots(t);
    }
}