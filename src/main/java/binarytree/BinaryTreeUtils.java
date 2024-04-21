package binarytree;

import java.util.*;

public class BinaryTreeUtils {

    public static void parcoursPrefixe(Node<?> A) {
        if (A != null) {
            System.out.print(A.getKey()+ " ");
            parcoursPrefixe(A.getLeft());
            parcoursPrefixe(A.getRight());
        }
    }

    public static void parcoursInfixe(Node<?> A) {
        if (A != null) {
            parcoursInfixe(A.getLeft());
            System.out.print(A.getKey() + " ");
            parcoursInfixe(A.getRight());
        }
    }

    public static void parcoursPostfixe(Node<?> A) {
        if (A != null) {
            parcoursPostfixe(A.getLeft());
            parcoursPostfixe(A.getRight());
            System.out.print(A.getKey()+ " ");
        }
    }

    public static void parcoursLargeur(Node<?> A) {
        if (A != null) {
            Queue<Node<?>> tempStack = new ArrayDeque<>();
            tempStack.add(A);
            while (!tempStack.isEmpty()) {
                Node<?> n = tempStack.poll();
                System.out.print(n.getKey() + " ");
                if (n.getLeft() != null) {
                    tempStack.add(n.getLeft());
                }
                if (n.getRight() != null) {
                    tempStack.add(n.getRight());
                }
            }
        }
    }

    public static void parcoursLargeurInverse(Node<?> A) {
        // TODO this work but complexity is bad
        if (A != null) {
            Stack<Node<?>> finalStack = new Stack<>();
            Queue<Node<?>> tempStack = new ArrayDeque<>();
            tempStack.add(A);
            while (!tempStack.isEmpty()) {
                Node<?> n = tempStack.poll();
                finalStack.push(n);
                if (n.getRight() != null) {
                    tempStack.add(n.getRight());
                }
                if (n.getLeft() != null) {
                    tempStack.add(n.getLeft());
                }
            }

            while (!finalStack.isEmpty()) {
                Node<?> n = finalStack.pop();
                System.out.print(n.getKey() + " ");
            }
        }
    }

    public static void parcoursDiagonalV1(Node<?> A, Queue<Node<?>> queue) {
        // Recursion
        Queue<Node<?>> tempQueue = queue == null ? new ArrayDeque<>() : queue;

        if (A != null) {
            if (A.getLeft() != null) {
                tempQueue.add(A.getLeft());
            }
            System.out.print(A.getKey() + " ");
            parcoursDiagonalV1(A.getRight(), tempQueue);
        } else if (!tempQueue.isEmpty()) {
            parcoursDiagonalV1(tempQueue.poll(), tempQueue);
        }
    }

    public static void parcoursDiagonalV2(Node<?> A) {
        // Iteration
        if (A == null) {
            return;
        }

        Queue<Node<?>> queue = new ArrayDeque<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            Node<?> node = queue.poll();
            while (node != null) {
                System.out.print(node.getKey() + " ");
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                node = node.getRight();
            }
        }
    }

    public static void afficherExpression(Node<?> A) {
        if (A != null) {
            if (A.getLeft() != null) {
                System.out.print("(");
                afficherExpression(A.getLeft());
                System.out.print(")");

            }
            System.out.print(A.getKey());
            if (A.getRight() != null) {
                System.out.print("(");
                afficherExpression(A.getRight());
                System.out.print(")");
            }
        }
    }

    public static Float evaluerExpression(Node<String> A) {
        if (A != null) {
            if (A.getLeft() == null) {
                return Float.parseFloat(A.getKey());
            } else {
                Float x = evaluerExpression(A.getLeft());
                Float y = evaluerExpression(A.getRight());

                return switch (A.getKey()) {
                    case "+" -> x + y;
                    case "-" -> x - y;
                    case "*" -> x * y;
                    case "/" -> x / y;
                    default -> throw new IllegalStateException("Unexpected value: " + A.getKey());
                };
            }
        }
        return null;
    }

    public static Node<?> createTreeFromRPN(final String RPN) {

        Stack<Node<String>> tempStack = new Stack<>();

        for (String s : RPN.split("\\s+")) {
            if ("+-*/".contains(s)) {
                Node<String> right = tempStack.pop();
                Node<String> left = tempStack.pop();
                Node<String> n = new Node<>(s);
                n.setRight(right);
                n.setLeft(left);
                tempStack.push(n);
            } else {
                tempStack.push(new Node<>(s));
            }
        }

        return tempStack.pop();
    }

    /**
     * Taken from https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram-in-java
     */
    public static class Printer {

        /**
         * @author MightyPork
         */
        public static void printCompact(PrintableNode root) {

            List<List<String>> lines = new ArrayList<>();
            List<PrintableNode> level = new ArrayList<>();
            List<PrintableNode> next = new ArrayList<>();

            level.add(root);
            int nn = 1;

            int widest = 0;

            while (nn != 0) {
                List<String> line = new ArrayList<>();

                nn = 0;

                for (PrintableNode n : level) {
                    if (n == null) {
                        line.add(null);

                        next.add(null);
                        next.add(null);
                    } else {
                        String aa = n.getText();
                        line.add(aa);
                        if (aa.length() > widest) widest = aa.length();

                        next.add(n.getLeft());
                        next.add(n.getRight());

                        if (n.getLeft() != null) nn++;
                        if (n.getRight() != null) nn++;
                    }
                }

                if (widest % 2 == 1) widest++;

                lines.add(line);

                List<PrintableNode> tmp = level;
                level = next;
                next = tmp;
                next.clear();
            }

            int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
            for (int i = 0; i < lines.size(); i++) {
                List<String> line = lines.get(i);
                int hpw = (int) Math.floor(perpiece / 2f) - 1;

                if (i > 0) {
                    for (int j = 0; j < line.size(); j++) {

                        // split node
                        char c = ' ';
                        if (j % 2 == 1) {
                            if (line.get(j - 1) != null) {
                                c = (line.get(j) != null) ? '┴' : '┘';
                            } else {
                                if (j < line.size() && line.get(j) != null) c = '└';
                            }
                        }
                        System.out.print(c);

                        // lines and spaces
                        if (line.get(j) == null) {
                            for (int k = 0; k < perpiece - 1; k++) {
                                System.out.print(" ");
                            }
                        } else {

                            for (int k = 0; k < hpw; k++) {
                                System.out.print(j % 2 == 0 ? " " : "─");
                            }
                            System.out.print(j % 2 == 0 ? "┌" : "┐");
                            for (int k = 0; k < hpw; k++) {
                                System.out.print(j % 2 == 0 ? "─" : " ");
                            }
                        }
                    }
                    System.out.println();
                }

                // print line of numbers
                for (int j = 0; j < line.size(); j++) {

                    String f = line.get(j);
                    if (f == null) f = "";
                    int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                    int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                    // a number
                    for (int k = 0; k < gap1; k++) {
                        System.out.print(" ");
                    }
                    System.out.print(f);
                    for (int k = 0; k < gap2; k++) {
                        System.out.print(" ");
                    }
                }
                System.out.println();

                perpiece /= 2;
            }
        }

        /**
         * @author michal.kreuzman
         */
        public static <T extends Comparable<?>> void printClean(PrintableNode root) {
            int maxLevel = maxLevel(root);

            printNodeInternal(Collections.singletonList(root), 1, maxLevel);
        }

        private static <T extends Comparable<?>> void printNodeInternal(List<PrintableNode> nodes, int level, int maxLevel) {
            if (nodes.isEmpty() || isAllElementsNull(nodes)) {
                return;
            }

            int floor = maxLevel - level;
            int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
            int firstSpaces = (int) Math.pow(2, (floor)) - 1;
            int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

            printWhitespaces(firstSpaces);

            List<PrintableNode> newNodes = new ArrayList<>();
            for (PrintableNode node : nodes) {
                if (node != null) {
                    System.out.print(node.getText());
                    newNodes.add(node.getLeft());
                    newNodes.add(node.getRight());
                } else {
                    newNodes.add(null);
                    newNodes.add(null);
                    System.out.print(" ");
                }

                printWhitespaces(betweenSpaces);
            }
            System.out.println("");

            for (int i = 1; i <= endgeLines; i++) {
                for (PrintableNode node : nodes) {
                    printWhitespaces(firstSpaces - i);
                    if (node == null) {
                        printWhitespaces(endgeLines + endgeLines + i + 1);
                        continue;
                    }

                    if (node.getLeft() != null) {
                        System.out.print("/");
                    } else {
                        printWhitespaces(1);
                    }

                    printWhitespaces(i + i - 1);

                    if (node.getRight() != null) {
                        System.out.print("\\");
                    } else {
                        printWhitespaces(1);
                    }

                    printWhitespaces(endgeLines + endgeLines - i);
                }
                System.out.println("");
            }
            printNodeInternal(newNodes, level + 1, maxLevel);
        }

        private static void printWhitespaces(int count) {
            for (int i = 0; i < count; i++) {
                System.out.print(" ");
            }
        }

        private static <T extends Comparable<?>> int maxLevel(PrintableNode node) {
            if (node == null) {
                return 0;
            }
            return Math.max(maxLevel(node.getLeft()), maxLevel(node.getRight())) + 1;
        }

        private static <T> boolean isAllElementsNull(List<T> list) {
            for (Object object : list) {
                if (object != null) {
                    return false;
                }
            }
            return true;
        }
    }

    public interface PrintableNode {

        PrintableNode getLeft();

        PrintableNode getRight();

        String getText();
    }
}