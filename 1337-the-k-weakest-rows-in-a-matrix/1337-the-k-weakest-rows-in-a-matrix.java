class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        // keep track of their original indexes since we are sorting them
        // need original indexes for the return
        Map<int[], Integer> originalIndexes = new HashMap<>();
        for(int i = 0; i < mat.length; i++) {
            originalIndexes.put(mat[i], i);
        }
        // assume all inner arrays are already sorted
        // assume all inner arrays are equal in length
        Arrays.sort(mat, (rowOne, rowTwo) -> {
            // sort in ascending order
            for(int i = 0; i < rowOne.length; i++) {
                if(rowOne[i] < rowTwo[i]) {
                    // rowTwo has a soldier and rowOne a civ
                    // so rowOne is lesser
                    return -1;
                } else if(rowOne[i] > rowTwo[i]) {
                    // rowOne has a soldier and rowTwo a civ
                    // so rowOne is greater
                    return 1;
                } else {
                    // they are equal (both soldiers, or both civs)
                    // keep checking for when they differ
                    continue;
                }
            }
            // they are equal in # of soliders, so rowOwo is greater by default
            return 1;
        });
        
        // setup return array of k weakest
        // mat is sorted in ascending order so get originalIndexes of first k elements
        int[] ret = new int[k];
        for(int i = 0; i < k; i++) {
            ret[i] = originalIndexes.get(mat[i]);
        }
        return ret;
    }
}