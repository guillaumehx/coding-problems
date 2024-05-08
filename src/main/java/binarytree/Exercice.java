package binarytree;

public class Exercice {

    /**
     * Exercice 2.1
     * Écrire un algorithme qui, étant donné un arbre T, compte le nombre de noeuds de T.
     *
     * @param T (arbre binaire)
     * @return Integer représentant le nombre de noeuds dans T
     */
    public static Integer nombreDeNoeuds(final Node<String> T) {
        if (T != null) {
            return 1 + nombreDeNoeuds(T.getLeft()) + nombreDeNoeuds(T.getRight());
        }
        return 0;
    }

    /**
     * Exercice 2.2
     * Écrire un algorithme qui, étant donné un arbre T, compte
     * la somme des valeurs contenues dans tous les noeuds de T.
     *
     * @param T (arbre binaire)
     * @return Integer représentant la somme des valeurs des noeuds de T
     */
    public static Integer sommeDesValeursDesNoeuds(final Node<Integer> T) {
        if (T != null) {
            return T.getKey() + sommeDesValeursDesNoeuds(T.getLeft()) + sommeDesValeursDesNoeuds(T.getRight());
        }
        return 0;
    }

    /**
     * Exercice 4
     * Écrire un algorithme qui affiche une version complètement parenthésée d'un arbre d'expression.
     *
     * @param A (arbre d'expression)
     */
    public static void afficherExpressionParentheses(final Node<?> A) {
        if (A.getLeft() == null && A.getRight() == null) {
            System.out.print(A.getKey());
        } else {
            System.out.print("(");
            afficherExpressionParentheses(A.getLeft());
            System.out.print(A.getKey());
            afficherExpressionParentheses(A.getRight());
            System.out.print(")");
        }
    }

    /**
     * Exercice 6 (Question d'examen)
     * Pour cette question, nous allons considérer des expression booléennes. Une expression booléenne est
     * constituée à l’aide de variables booléennes (elles ne peuvent valoir que vrai ou faux) et des opérateurs
     * logiques habituels (∨ pour « ou », ∧ pour « et », ⇒ pour l’implication et ¬ pour la négation). On peut
     * également utiliser des parenthèses et les constantes vrai et faux. Par exemple, p1 ∧(¬(p2 ∨ p3)∨(p1 ⇒
     * faux)) est une expression booléenne.
     * En donnant à chaque variable une valeur (vrai ou faux), on obtient une valeur pour l’expression. Par
     * exemple, si p1 vaut vrai, p2 vaut faux et p3 vaut faux, l’expression ci-dessus vaut vrai. Si par contre on
     * remplace la valeur de p1 par faux, l’expression vaut faux.
     * On peut représenter une telle expression sous forme d’un arbre binaire. Les feuilles sont étiquettées par
     * vrai, faux ou par une variable. Les nœuds internes sont étiquettés par ∨, ∧, ⇒ ou ¬. Dans les trois premiers
     * cas, les deux fils sont les arbres qui représentent les deux opérandes. Dans le cas de ¬, le fils gauche est
     * l’arbre représentant l’expression dont on veut prendre la négation, et le fils droit est l’arbre vide.
     *
     * @param A (arbre représentant une expression booléenne)
     * @param T (tableau de booléens)
     * @return résultat de l'expression
     */
    public static Boolean evaluerExpressionBooleenne(final Node<String> A, Boolean[] T) {
        if (A != null) {

            if (A.getLeft() == null && A.getRight() == null) {
                if (A.getKey().startsWith("p")) {
                    return T[Integer.parseInt(A.getKey().split("p")[1]) - 1];
                } else {
                    return Boolean.parseBoolean(A.getKey());
                }
            }

            Boolean gauche = evaluerExpressionBooleenne(A.getLeft(), T);

            if (A.getKey().equals("¬")) {
                return !gauche;
            }

            Boolean droite = evaluerExpressionBooleenne(A.getRight(), T);

            if (A.getKey().equals("∨")) {
                return gauche || droite;
            }
            if (A.getKey().equals("∧")) {
                return gauche && droite;
            }
            if (A.getKey().equals("⇒")) {
                return (!gauche) || droite;
            }

        }
        throw new RuntimeException("ok");
    }

    /**
     * Exercice 7
     * Écrire un algorithme qui teste si un arbre binaire donné
     * possède la propriété des arbres binaires de recherche.
     *
     * @param A (arbre binaire)
     * @return 'true' si l'arbre est un ABR, false sinon
     */
    public static Boolean testeABR(final Node<Integer> A) {

        if (A == null) {
            return true;
        }

        if (maxFromTree(A.getLeft()) > A.getKey() || minFromTree(A.getRight()) <= A.getKey()) {
            return false;
        }

        if (minFromTree(A.getRight()) <= A.getKey()) {
            return false;
        }

        if (testeABR(A.getRight()) && testeABR(A.getLeft())) {
            return true;
        }

        return false;
    }

    /**
     * @param A (arbre binaire)
     * @return Integer représentant le nombre maximum contenu dans A
     */
    public static Integer maxArbre(final Node<Integer> A) {
        if (A != null) {
            int l = maxArbre(A.getLeft());
            int r = maxArbre(A.getRight());
            return Math.max(Math.max(l, r), A.getKey());
        } else {
            return Integer.MIN_VALUE;
        }
    }

    /**
     * @param A (arbre binaire)
     * @return Integer représentant le nombre minimum contenu dans A
     */
    public static Integer minArbre(final Node<Integer> A) {
        if (A != null) {
            int l = minArbre(A.getLeft());
            int r = minArbre(A.getRight());
            return Math.min(Math.min(l, r), A.getKey());
        } else {
            return Integer.MAX_VALUE;
        }
    }

    /**
     * Exercice 8
     * Écrire un algorithme qui, étant donné un entier x et un arbre binaire de recherche
     * (ABR) A, retourne la profondeur du noeud contenant x s'il existe, +infini sinon.
     *
     * @param A (arbre binaire de recherche)
     * @param x (entier recherché)
     * @return Integer représentant la hauteur du noeud contenant x ou +infini sinon
     */
    public static Integer hauteurDuNoeudX(final Node<Integer> A, int x) {

        Node<Integer> current = A;
        int h = 1;

        while (current != null) {
            if (x == current.getKey()) {
                return h;
            } else if (x <= current.getKey()) {
                current = current.getLeft();
            } else if (x > current.getKey()) {
                current = current.getRight();
            }
            h++;
        }

        return Integer.MAX_VALUE;
    }

    /**
     * Exercice 9 (Question d'examen)
     * Donner un algorithme récursif qui reçoit un arbre binaire de recherche A, ainsi que deux bornes
     * bi et bs, et qui affiche toutes les valeurs contenues dans A qui sont comprises dans l'intervalle
     * [bi, bs] (bornes comprises, donc). Votre algorithme devra afficher ces valeurs dans l'ordre croissant.
     *
     * @param A (arbre binaire de recherche)
     * @param bi (borne inférieure)
     * @param bs (borne supérieure)
     */
    public static void afficherAvecIntervalle(final Node<Integer> A, int bi, int bs) {
        if (A != null) {
            int k = A.getKey();
            if (k >= bi) {
                afficherAvecIntervalle(A.getLeft(), bi, bs);
            }
            if (k >= bi && k <= bs) {
                System.out.print(k + " ");
            }
            if (k <= bs) {
                afficherAvecIntervalle(A.getRight(), bi, bs);
            }
        }
    }

}
