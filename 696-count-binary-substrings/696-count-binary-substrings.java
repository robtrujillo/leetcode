class Solution {
    public int countBinarySubstrings(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char firstChar = s.charAt(0);
        char suffixCharType;
        if(firstChar == '0') {
            suffixCharType = '1';
        } else {
            suffixCharType = '0';
        }
        int indexOfSecondChar = s.indexOf(suffixCharType);
        if(indexOfSecondChar < 0) {
           return 0;
        }
        int firstCharCount = indexOfSecondChar;

        int indexOfNextPrefixChar = s.indexOf(firstChar, indexOfSecondChar);
        // second char count is difference between 2 indexes or until end of string
        int secondCharCount = indexOfNextPrefixChar > 0 ? indexOfNextPrefixChar - indexOfSecondChar : s.length() - indexOfSecondChar;

        int numSubstrings = 0;
        if (firstCharCount <= secondCharCount) {
            numSubstrings = numSubstrings + firstCharCount;
        } else {
            numSubstrings = numSubstrings + secondCharCount;
        }
            
        String nextSubstring = s.substring(indexOfSecondChar);

        return numSubstrings + countBinarySubstrings(nextSubstring);
    }
}