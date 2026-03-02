class ps {
    public String longestPalindrome(String s) {
        String longest = "";

        // 1. Look at every possible starting point
        for (int start = 0; start < s.length(); start++) {
            
            // 2. Look at every possible ending point
            for (int end = start; end < s.length(); end++) {
                
                // 3. Cut out this piece of the string
                String piece = s.substring(start, end + 1);
                
                // 4. Check: Is this piece a palindrome?
                if (isPalindrome(piece)) {
                    // 5. If it is, and it's the longest we've seen, save it!
                    if (piece.length() > longest.length()) {
                        longest = piece;
                    }
                }
            }
        }
        return longest;
    }

    // This part just checks if a word is the same backwards
    public boolean isPalindrome(String word) {
        int i = 0;
        int j = word.length() - 1;
        
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false; // Not a match!
            }
            i++; // move forward
            j--; // move backward
        }
        return true; // It's a match!
    }
}
