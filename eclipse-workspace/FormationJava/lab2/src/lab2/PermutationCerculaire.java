package lab2;

public class PermutationCerculaire {

    public static boolean estPermutationCirculaire(int[] t) {

        int n = t.length;

        // Vérification des valeurs et des doublons
        boolean[] vu = new boolean[n + 1];

        for (int i = 0; i < n; i++) {

            int x = t[i];
            if (x < 1 || x > n) {
                return false;
            }

            // Vérifier les doublons
            if (vu[x]) {
                return false;
            }

            vu[x] = true;
        }

        // Trouver la position de 1
        int pos = 0;

        for (int i = 0; i < n; i++) {

            if (t[i] == 1) {
                pos = i;
                break;
            }
        }

        // Vérifier l'ordre circulaire
        for (int k = 0; k < n; k++) {

            int indice = (pos + k) % n;
            int valeur = k + 1;

            if (t[indice] != valeur) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] tests = {
            {1},
            {1, 2, 3, 4, 5},
            {2, 3, 4, 5, 1},
            {3, 4, 5, 1, 2},
            {4, 5, 1, 2, 3},
            {5, 1, 2, 3, 4},
            {3, 1, 2, 4, 5},
            {2, 1, 3, 4, 5},
            {4, 1, 2, 3, 5},
            {0, 1, 2, 3, 4},
            {1, 2, 2, 3, 4},
            {1, 2, 3, 4, 6}
        };

        for (int[] t : tests) {

            System.out.print("Tableau : ");

            for (int x : t) {
                System.out.print(x + " ");
            }

            System.out.println();

            System.out.println(
                "Permutation circulaire : "
                + estPermutationCirculaire(t)
            );

            System.out.println();
        }
    }
}