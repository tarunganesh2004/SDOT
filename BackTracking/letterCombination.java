// Letter combinations of a phone number
// Given a digit string, return all possible letter combinations that the number could represent.
// A mapping of digit to letters (just like on the telephone buttons) is given below.
// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

import java.util.*;

class letterCombination {
    static String[] keypad = { ",", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    static void com(String s, String res) {
        if (s.length() == 0) {
            System.out.print(res + " ");
            return;
        }
        String key = keypad[s.charAt(0) - '1'];
        for (int i = 0; i < key.length(); i++) {
            com(s.substring(1), res + key.charAt(i));
        }

    }
    
    static void printCombinations(String s, String res) {
        if (s.length() == 0) {
            System.out.print(res + " ");
            return;

        }
        String first = keypad[s.charAt(0) - '1'];
        String second = keypad[s.charAt(1) - '1'];
        for (int i = 0; i < second.length(); i++) {
            for (int j = 0; j < first.length(); j++) {
                System.out.print(res+first.charAt(j)+second.charAt(i)+" ");
            }
        }
    }
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // com(s, "");
        printCombinations(s, "");
        sc.close();
    }
}