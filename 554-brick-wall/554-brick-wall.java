class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> intersectionMap = new HashMap<>();
        // get total width of row
        Integer totalWidth = 0;
        for(Integer val : wall.get(0)) {
            totalWidth += val;
        }
        
        // find all the intersections per row
        for(List<Integer> row : wall) {
            System.out.println(row);
            Integer intersection = 0;
            for(Integer currentIntersection: row) {
                intersection+= currentIntersection;
                if(intersection.equals(totalWidth)) {
                    continue;
                }
                Integer prevValue = intersectionMap.containsKey(intersection) ? intersectionMap.get(intersection) : 0;
                
                intersectionMap.put(intersection, 1+prevValue);
            }
        }
        Integer totalRows = wall.size();
        Integer min = totalRows;
        for(Integer intersectionsAtWidth : intersectionMap.values()) {
            Integer diff = totalRows - intersectionsAtWidth;
            min = min >= diff ? diff : min; 
        }
        System.out.println("min " + min);
        System.out.println("intersectionMap size " +  intersectionMap.size());
        System.out.println("totalWidth " +  totalWidth);
        System.out.println("totalRows " +  totalRows);
        return intersectionMap.size() == 0 ? totalRows : min;
    }
}