class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<int[], Integer> originalIndexes = new HashMap<>();
        for(int i = 0; i < mat.length; i++) {
            originalIndexes.put(mat[i], i);
        }
        
        Arrays.sort(mat, (rowOne, rowTwo) -> {
            for(int i = 0; i < rowOne.length; i++) {
                if(rowOne[i] < rowTwo[i]) {
                    // rowTwo has a soldier and rowOne a civ
                    return -1;
                } else if(rowOne[i] > rowTwo[i]) {
                    // rowOne has a soldier and rowTwo a civ
                    return 1;
                } else {
                    // they are equal (both soldiers, or both civs)
                    continue;
                }
            }
            // they are equal in soliders, so rowTwo is bigger by default
            return 1;
        });
        
        int[] ret = new int[k];
        for(int i = 0; i < k; i++) {
            ret[i] = originalIndexes.get(mat[i]);
        }
        return ret;
    }
}