import java.util.Deque;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String str = "racecar";

        Deque<Character> deque = new LinkedList<>();

        for (char c : str.toCharArray()) {
            deque.add(c);
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            char frontChar = deque.removeFirst();
            char rearChar = deque.removeLast();

            System.out.println("Front: " + frontChar + ", Rear: " + rearChar);

            if (frontChar != rearChar) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("The string \"" + str + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + str + "\" is not a palindrome.");
        }
    }
}