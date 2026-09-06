package lab2;

public class MatriceMagique {
	    public static boolean estCarreMagique(int[][] m) {

	        int ref = m[0][0] + m[0][1] + m[0][2];
	        
	        for (int i = 1; i < 3; i++) {
	            int somme = m[i][0] + m[i][1] + m[i][2];
	            if (somme != ref) {
	                return false;
	            }
	        }

	        for (int j = 0; j < 3; j++) {
	            int somme = m[0][j] + m[1][j] + m[2][j];
	            if (somme != ref) {
	                return false;
	            }
	        }

	        int diagonale1 = m[0][0] + m[1][1] + m[2][2];
	        if (diagonale1 != ref) {
	            return false;
	        }
	        int diagonale2 = m[0][2] + m[1][1] + m[2][0];
	        if (diagonale2 != ref) {
	            return false;
	        }

	        return true;
	    }

	    public static void main(String[] args) {

	        int[][][] tests = {

	            {
	                {8, 1, 6},
	                {3, 5, 7},
	                {4, 9, 2}
	            },

	            {
	                {2, 7, 6},
	                {9, 5, 1},
	                {4, 3, 7}
	            },

	            {
	                {1, 1, 1},
	                {1, 1, 1},
	                {1, 1, 1}
	            }
	        };

	        for (int[][] m : tests) {
	            // Affichage de la matrice
	            for (int i = 0; i < m.length; i++) {

	                for (int j = 0; j < m[i].length; j++) {
	                    System.out.print(m[i][j] + " ");
	                }

	                System.out.println();
	            }
	            if (estCarreMagique(m)) {
	                System.out.println("Carré magique");
	            } else {
	                System.out.println("Pas un carré magique");
	            }

	            System.out.println();
	        }
	    }}
