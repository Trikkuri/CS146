package Lab;

import java.util.Scanner;

public class Lab2 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter string (s):");
        String s = scanner.nextLine();

        System.out.println("Enter string (t):");
        String t = scanner.nextLine();

        boolean result = isAnagram(s, t);
        System.out.println("Is anagram: " + result);

        scanner.close();
    }
}
