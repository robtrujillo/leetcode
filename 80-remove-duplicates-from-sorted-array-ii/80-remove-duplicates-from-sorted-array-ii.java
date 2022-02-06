class Solution {
    public int removeDuplicates(int[] nums) {
        
        // edge cases for sizes 0,1,2
        if(nums.length <= 2) {
            return nums.length;
        }
        
        int currDupeCount = 0;
        // at least 2 elements in the loop we know to start
        // loop while i < nums.length - 1 - currDupeCount
        // (-currDupeCount) b/c we dont want to loop on the shifted dupes at the end
        for(int i = 0; i < nums.length - 1 - currDupeCount; i++) {
            int end = nums.length - currDupeCount;
            int curr = nums[i];
            int next = nums[i+1];
            if (curr != next) {
                // not a dupe, iterate next
                continue;
            } else if((i+2) >= nums.length || nums[i+2] < curr)  {
                // there is nothing left we want to check! 
                // or, the next value is less than, which means unsorted, so we
                // prob moved a dupe there which means end of significant array
                return nums.length - currDupeCount;
            } else {
                // found a dupe! any consecutive dupes from here must be 
                // removed and then array must shift by found dupe count
                // keep track of starting index of possible dupe!
                int startingIndexToCheck = i+2;
                // step 1: count the dupes
                int numDupes = countConsecutiveDupes(nums, curr, startingIndexToCheck, end);
                // step 2: shift this chunk of dupes to end
                if(numDupes == 0) {
                    // there were no other dupes, i.e. [1,1] and not [1,1,1]
                    continue;
                } else {
                    // add the new dupes found
                    currDupeCount += numDupes;
                    // shift everything after dupe chunk
                    removeDupeChunkAndShift(nums, startingIndexToCheck, numDupes);
                }
            }
        }
        return nums.length - currDupeCount;
    }
    
    
    // @param nums : array to use
    // @param startingShiftIndex : which location needs to be shifted
    // @param lengthToShift : how many need to be shifted 
    private void removeDupeChunkAndShift(int[] nums, int startingShiftIndex, int lengthToShift) {
        for(int i = startingShiftIndex; i+lengthToShift < nums.length; i++) {
            nums[i] = nums[i+lengthToShift];
        }
    }
    
    // @param nums : array to search through
    // @param value : the value we are looking for dupes of
    // @param startingIndex : starting index of the array to search from
    // @param endingIndex : ending index of the array we can search to
    private int countConsecutiveDupes(int[] nums, int value, int startingIndex, int endingIndex) {
        int dupeCount = 0;
        for(int i = startingIndex; i < endingIndex; i++) {
            int curr = nums[i];
            if(curr == value) {
                dupeCount++;
            } else {
                return dupeCount;
            }
        }
        return dupeCount;
    }
}