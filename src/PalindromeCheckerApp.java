import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    static final String APP_NAME = "PalindromeChecker App";
    static final String VERSION = "Version 1.0";

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(APP_NAME);
        System.out.println(VERSION);
        System.out.println("=================================");

        hardcodedPalindromeCheck();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a string: ");
        String input = scanner.nextLine();

        reverseStringCheck(input);
        charArrayCheck(input);
        stackCheck(input);
        queueStackCheck(input);
        dequeCheck(input);

        scanner.close();
    }

    static void hardcodedPalindromeCheck() {
        String word = "madam";
        boolean result = isPalindromeString(word);
        System.out.println("\nHardcoded Check: \"" + word + "\" is " + (result ? "a palindrome." : "not a palindrome."));
    }

    static void reverseStringCheck(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        System.out.println("Reverse String Check: " + resultMessage(str.equals(reversed)));
    }

    static void charArrayCheck(String str) {
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (arr[left] != arr[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        System.out.println("Character Array Check: " + resultMessage(isPalindrome));
    }

    static void stackCheck(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindrome = true;
        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Stack Check: " + resultMessage(isPalindrome));
    }

    static void queueStackCheck(String str) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Queue + Stack Check: " + resultMessage(isPalindrome));
    }

    static void dequeCheck(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            deque.add(c);
        }

        boolean isPalindrome = true;
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Deque Check: " + resultMessage(isPalindrome));
    }

    static boolean isPalindromeString(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    static String resultMessage(boolean result) {
        return result ? "Palindrome" : "Not a Palindrome";
    }
}