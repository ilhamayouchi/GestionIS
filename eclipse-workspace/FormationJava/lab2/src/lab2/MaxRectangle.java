package lab2;

public class MaxRectangle {

    static class Rectangle {
        int top;
        int left;
        int bottom;
        int right;
        int area;
    }

    public static Rectangle trouverMaxRectangle(int[][] m) {

        int lignes = m.length;
        int colonnes = m[0].length;

        int[] hauteur = new int[colonnes];

        Rectangle meilleur = new Rectangle();
        meilleur.area = 0;

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {

                if (m[i][j] == 1) {
                    hauteur[j]++;
                } else {
                    hauteur[j] = 0;
                }
            }
            int[] pile = new int[colonnes + 1];
            int sommet = -1;

            for (int j = 0; j <= colonnes; j++) {

                int h;

                if (j == colonnes) {
                    h = 0;
                } else {
                    h = hauteur[j];
                }

                while (sommet >= 0 && hauteur[pile[sommet]] > h) {

                    int index = pile[sommet];
                    sommet--;

                    int height = hauteur[index];

                    int right = j - 1;

                    int left;

                    if (sommet >= 0) {
                        left = pile[sommet] + 1;
                    } else {
                        left = 0;
                    }

                    int area = height * (right - left + 1);

                    if (area > meilleur.area) {

                        meilleur.area = area;
                        meilleur.left = left;
                        meilleur.right = right;
                        meilleur.bottom = i;
                        meilleur.top = i - height + 1;
                    }
                }

                pile[++sommet] = j;
            }
        }

        return meilleur;
    }

    public static void main(String[] args) {

        int[][] m = {
            {0, 1, 1, 0, 1},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 0},
            {1, 1, 0, 0, 1}
        };

        Rectangle r = trouverMaxRectangle(m);

        System.out.println("Aire maximale : " + r.area);
        System.out.println("top = " + r.top);
        System.out.println("left = " + r.left);
        System.out.println("bottom = " + r.bottom);
        System.out.println("right = " + r.right);
    }
}
