class ListNode {
    char val;
    ListNode next;
    ListNode(char val) { this.val = val; }
}

public class PalindromeCheckerApp {

    private ListNode leftSidePointer;

    public static void main(String[] args) {
        PalindromeCheckerApp checker = new PalindromeCheckerApp();
        String word = "level";

        if (checker.isPalindrome(word)) {
            System.out.println("'" + word + "' is a palindrome.");
        } else {
            System.out.println("'" + word + "' is not a palindrome.");
        }
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;

        ListNode head = stringToList(s);
        leftSidePointer = head;

        return checkRecursively(head);
    }

    private boolean checkRecursively(ListNode rightSidePointer) {
        if (rightSidePointer == null) {
            return true;
        }

        boolean isSubListPalindrome = checkRecursively(rightSidePointer.next);

        if (!isSubListPalindrome) return false;

        boolean valuesMatch = (rightSidePointer.val == leftSidePointer.val);
        leftSidePointer = leftSidePointer.next;

        return valuesMatch;
    }

    private ListNode stringToList(String s) {
        ListNode dummy = new ListNode(' ');
        ListNode curr = dummy;
        for (char c : s.toCharArray()) {
            curr.next = new ListNode(c);
            curr = curr.next;
        }
        return dummy.next;
    }
}