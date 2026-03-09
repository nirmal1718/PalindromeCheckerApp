import java.util.Scanner;

public class PalindromeCheckerApp {

    static String appName = "PalindromeChecker App";
    static String version = "Version 1.0";

    public static void main(String[] args) {

        System.out.println("Welcome to " + appName);
        System.out.println(version);
        System.out.println("Application started");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = sc.nextLine();

        String reversed = new StringBuilder(text).reverse().toString();

        if (text.equals(reversed)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        System.out.println("Application finished");
    }
}