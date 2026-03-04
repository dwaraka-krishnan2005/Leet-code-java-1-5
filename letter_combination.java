import java.util.*;

class letter_combination {
    // Fixed mapping of digits to letters
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        backtrack(result, new StringBuilder(), digits, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, String digits, int index) {
        // Base Case: If the combination is complete
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters for the current digit
        String letters = KEYPAD[digits.charAt(index) - '0'];
        
        for (char c : letters.toCharArray()) {
            current.append(c);             // 1. Choose
            backtrack(result, current, digits, index + 1); // 2. Explore
            current.deleteCharAt(current.length() - 1); // 3. Backtrack
        }
    }
}
