package lab2;

public class NombreAbsente {

	    public static void afficherElementsManquants(int[] t) {

	        int n = t.length;

	        boolean[] vu = new boolean[n + 1];
	        for (int i = 0; i < n; i++) {

	            int x = t[i];
	            if (x >= 1 && x <= n) {
	                vu[x] = true;
	            }
	        }

	       
	        boolean chercher = false;

	        System.out.print("Éléments manquants : ");

	        for (int k = 1; k <= n; k++) {

	            if (vu[k] == false) {
	                System.out.print(k + " ");
	                chercher = true;
	            }
	        }

	        // Si il y a aucun élément manquant
	        if (chercher == false) {
	            System.out.print("Aucun élément manquant");
	        }

	        System.out.println();
	    }

	    public static void main(String[] args) {

	        int[][] tests = {
	            {1, 3, 3, 5},
	            {1, 2, 3, 4},
	            {3, 3, 3},
	            {1, 1, 1, 1},
	            {4, 2, 2, 1, 5},
	            {1}
	        };

	        for (int[] t : tests) {

	            System.out.print("Tableau : ");

	            for (int x : t) {
	                System.out.print(x + " ");
	            }

	            System.out.println();
	            afficherElementsManquants(t);
	            System.out.println();
	        }
	    }
	}