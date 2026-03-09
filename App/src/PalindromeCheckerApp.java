import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PalindromeCheckerApp {

    static boolean stackMethod(String text) {
        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) {
            stack.push(c);
        }
        for (char c : text.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    static boolean dequeMethod(String text) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : text.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    static boolean reverseMethod(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = sc.nextLine();

        long start1 = System.nanoTime();
        boolean r1 = stackMethod(text);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean r2 = dequeMethod(text);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        boolean r3 = reverseMethod(text);
        long end3 = System.nanoTime();

        System.out.println("Stack Method Result: " + r1 + " Time: " + (end1 - start1) + " ns");
        System.out.println("Deque Method Result: " + r2 + " Time: " + (end2 - start2) + " ns");
        System.out.println("Reverse Method Result: " + r3 + " Time: " + (end3 - start3) + " ns");
    }
}