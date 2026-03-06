class ListNode {
    char val;
    ListNode next;
    ListNode(char val) { this.val = val; }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        PalindromeCheckerApp checker = new PalindromeCheckerApp();

        String word = "racecar";
        if (checker.isPalindrome(word)) {
            System.out.println("'" + word + "' is a palindrome.");
        } else {
            System.out.println("'" + word + "' is not a palindrome.");
        }
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;

        ListNode head = stringToList(s);

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalfHead = reverseList(slow);
        ListNode firstHalfHead = head;

        ListNode p1 = firstHalfHead;
        ListNode p2 = secondHalfHead;
        boolean result = true;

        while (p2 != null) {
            if (p1.val != p2.val) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
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