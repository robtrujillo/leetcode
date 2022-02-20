class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // intervals 
        
        // sort with comparator lambda which compares based on first index
        // unless first index is equal, then second index
        Arrays.sort(intervals, (x, y) -> {
            return x[0] == y[0] ? y[1] - x[1] : x[0] - y[0];
        });

        int count = 0;
        int currEnd = 0;
        int prevEnd = 0;
        // loop over array, if currEnd is greater than previous end
        // after sorting, we are adding to count
        // in other implementations, the else would remove
        for(int i = 0; i < intervals.length; i++) {
            int[] curr = intervals[i];
            currEnd = curr[1]; 
            if(prevEnd < currEnd) {
                count++;
                prevEnd = currEnd;
            }
        }
        return count;
    }
   
}