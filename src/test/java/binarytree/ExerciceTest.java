package binarytree;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static binarytree.Exercice.*;
import static org.junit.Assert.*;

public class ExerciceTest {

    @Test
    public void testNombreDeNoeuds() {

        final Node<Integer> T = createBinarySearchTree();
        BinaryTreeUtils.Printer.printClean(T);

        assertEquals(9, (int) nombreDeNoeuds(T));
    }

    @Test
    public void testSommeDesValeursDesNoeuds() {

        final Node<Integer> T = createBinarySearchTree();
        BinaryTreeUtils.Printer.printClean(T);

        assertEquals(110, (int) sommeDesValeursDesNoeuds(T));
    }

    @Test
    public void testEvaluerExpressionBooleenneFalse() {

        final Node<String> A = createBooleanExpressionTree();
        Boolean[] T;
        BinaryTreeUtils.Printer.printClean(A);

        T = new Boolean[] { true, false, false };
        assertEquals(true, evaluerExpressionBooleenne(A, T));

        T = new Boolean[] { false, true, true };
        assertEquals(false, evaluerExpressionBooleenne(A, T));

        T = new Boolean[] { false, false, false };
        assertEquals(false, evaluerExpressionBooleenne(A, T));
    }

    @Test
    public void testArbreExpression() {
        final Node<String> A = createBinaryExpressionTree();
        BinaryTreeUtils.Printer.printClean(A);

        assertTrue(testeArbreExpression(A));
        assertTrue(testeArbreExpression(new Node<>("9")));
        assertFalse(testeArbreExpression(null));
        assertFalse(testeArbreExpression(new Node<>("9", null, new Node<>("-"))));
    }

    @Test
    public void testABR() {

        final Node<Integer> A = createBinarySearchTree();
        BinaryTreeUtils.Printer.printClean(A);

        assertEquals(true, testeABR(A));
    }

    @Test
    public void testABROneNode() {

        final Node<Integer> A = new Node<>(10);
        BinaryTreeUtils.Printer.printClean(A);

        assertEquals(true, testeABR(A));
    }

    @Test
    public void testABRFalse() {

        final Node<Integer> A = new Node<>(1);
        A.setLeft(new Node<>(2));
        A.setRight(new Node<>(2));

        BinaryTreeUtils.Printer.printClean(A);

        assertEquals(false, testeABR(A));
    }

    @Test
    public void testMaxMinArbre() {

        final Node<Integer> A = createBinarySearchTree();
        BinaryTreeUtils.Printer.printClean(A);

        assertEquals(20, (int) maxArbre(A));
        assertEquals(5, (int) minArbre(A));
    }

    @Test
    public void testHauteurDuNoeudX() {

        final Node<Integer> A = createBinarySearchTree();
        BinaryTreeUtils.Printer.printClean(A);

        assertEquals(4, (int) hauteurDuNoeudX(A, 20));
        assertEquals(4, (int) hauteurDuNoeudX(A, 17));
        assertEquals(1, (int) hauteurDuNoeudX(A, 10));
        assertEquals(2, (int) hauteurDuNoeudX(A, 5));
        assertEquals(Integer.MAX_VALUE, (int) hauteurDuNoeudX(A, 1000));
    }

    @Test
    public void testAfficherExpressionParentheses() throws NoSuchMethodException {

        Method method = Exercice.class.getMethod("afficherExpressionParentheses", Node.class);

        String stringPrinted = getPrintedElementInConsole(method);
        assertEquals("((8/2)+(3*(5-2)))", stringPrinted);
    }

    @Test
    public void testAfficherAvecIntervalle() throws NoSuchMethodException {

        Method method = Exercice.class.getMethod("afficherAvecIntervalle", Node.class, int.class, int.class);

        String stringPrinted1 = getPrintedElementInConsole(method, 10, 15);
        String stringPrinted2 = getPrintedElementInConsole(method, 5, 22);
        String stringPrinted3 = getPrintedElementInConsole(method, 0, 1);

        assertEquals("10 12 15 ", stringPrinted1);
        assertEquals("5 5 7 10 12 15 17 19 20 ", stringPrinted2);
        assertEquals("", stringPrinted3);
    }

    private String getPrintedElementInConsole(Method m, int ... bi) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        try {
            if (m.getName().equals("afficherAvecIntervalle")) {
                Node<Integer> T = createBinarySearchTree();
                m.invoke(m, T, bi[0], bi[1]);
            }
            if (m.getName().equals("afficherExpressionParentheses")) {
                Node<String> T = createBinaryExpressionTree();
                m.invoke(m, T);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        System.setOut(old);
        return baos.toString();
    }

    private static Node<Integer> createBinarySearchTree() {

        Node<Integer> root = new Node<>(10);
        Node<Integer> n1 = new Node<>(5);
        Node<Integer> n2 = new Node<>(15);
        Node<Integer> n3 = new Node<>(5);
        Node<Integer> n4 = new Node<>(7);
        Node<Integer> n5 = new Node<>(12);
        Node<Integer> n6 = new Node<>(17);
        Node<Integer> n7 = new Node<>(20);
        Node<Integer> n8 = new Node<>(19);

        root.setLeft(n1);
        root.setRight(n2);

        n1.setLeft(n3);
        n1.setRight(n4);

        n2.setLeft(n5);
        n2.setRight(n8);

        n8.setLeft(n6);
        n8.setRight(n7);

        return root;
    }

    private static Node<String> createBinaryExpressionTree() {

        Node<String> root = new Node<>("+");
        Node<String> n1 = new Node<>("/");
        Node<String> n2 = new Node<>("*");
        Node<String> n3 = new Node<>("8");
        Node<String> n4 = new Node<>("2");
        Node<String> n5 = new Node<>("3");
        Node<String> n6 = new Node<>("5");
        Node<String> n7 = new Node<>("2");
        Node<String> n8 = new Node<>("-");

        root.setLeft(n1);
        root.setRight(n2);

        n1.setLeft(n3);
        n1.setRight(n4);

        n2.setLeft(n5);
        n2.setRight(n8);

        n8.setLeft(n6);
        n8.setRight(n7);

        return root;
    }

    private static Node<String> createBooleanExpressionTree() {

        Node<String> root = new Node<>("∧");
        Node<String> nDiv = new Node<>("p1");
        Node<String> nMulti = new Node<>("∨");
        Node<String> n3 = new Node<>("¬");
        Node<String> n5 = new Node<>("p1");
        Node<String> n22 = new Node<>("false");
        Node<String> nMinus = new Node<>("⇒");
        Node<String> nil = new Node<>("nil");
        Node<String> p2 = new Node<>("p2");
        Node<String> p3 = new Node<>("p3");
        Node<String> v = new Node<>("∨");

        root.setLeft(nDiv);
        root.setRight(nMulti);

        v.setLeft(p2);
        v.setRight(p3);

        n3.setLeft(v);
        n3.setRight(nil);

        nMulti.setLeft(n3);
        nMulti.setRight(nMinus);

        nMinus.setLeft(n5);
        nMinus.setRight(n22);

        return root;
    }

}