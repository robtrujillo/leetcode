class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> masterList = new ArrayList<>();
        // start off with 1 entry of an empty set
        masterList.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int currentMasterLength = masterList.size();
            // only loop the inner lists up to the current length
            // since the length will increase as we are adding to it
            // and we dont want to add subsets like [2,2]
            for(int j=0; j < currentMasterLength; j++) {
                // make a copy of each inner list
                List<Integer> copy = new ArrayList<>(masterList.get(j));
                // add the new num to the copy of the inner list
                copy.add(num);
                // add the new subset to the master list we are returning
                masterList.add(copy);
            }
        }
        return masterList;
    }
}