class Solution {
    public int largestUniqueNumber(int[] A) {
        int largest = -1;
        Map<Integer, Integer> occurenceMap = new HashMap<>();
        for(int val : A) {
            Integer key = new Integer(val);
            if(occurenceMap.containsKey(new Integer(val))) {
              occurenceMap.put(key, occurenceMap.get(key) + 1); 
            }  else {
              occurenceMap.put(key, 1);  
            } 
        }
        for(Integer key : occurenceMap.keySet()) {
            if(occurenceMap.get(key).equals(new Integer(1)) && key > largest) {
                largest = key.intValue();
            }
        }
        return largest;
    }
}