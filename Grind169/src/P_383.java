import java.util.HashMap;

public class P_383 {
    /*
     * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
     * Each letter in magazine can only be used once in ransomNote.
     */

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Count the frequency of each character in the magazine
        for (char ch : magazine.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        // Check if ransomNote can be constructed
        for (char ch : ransomNote.toCharArray()) {
            if (!charCount.containsKey(ch) || charCount.get(ch) <= 0) {
                return false; // Not enough characters available
            }
            charCount.put(ch, charCount.get(ch) - 1); // Use one character
        }

        return true; // All characters in ransomNote are available in magazine
    }

    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println("Answer: " + canConstruct(ransomNote, magazine)); // Output: true
    }
}
