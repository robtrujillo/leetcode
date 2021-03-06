class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // 2 different ways of retrieving max gaps
        int[] currentGaps = new int[heights.length];
        Queue<Integer> brickAllocations = new PriorityQueue<>((a, b) -> b - a);
        if(ladders >= heights.length - 1) {
            return heights.length-1;
        }
        for(int i = 0; i < heights.length - 1; i++) {
            int bricksNeeded = heights[i+1] - heights[i];
            currentGaps[i] = bricksNeeded;
            if(bricksNeeded <= 0) {
                // dont need to use bricks/ladders
                continue;
            }
            
            brickAllocations.add(bricksNeeded);
            bricks -= bricksNeeded;
            if (bricks < 0 && ladders == 0) {
                // this is as far as you go. cannot cross to next building
                return i;
            }
            
            // replace largest gap with ladder
            if (bricks < 0) {
                ladders--;
                int largestGapSoFar = bricksNeeded;
                // for(int j=0; j <= i; j++) {
                //     if (currentGaps[j] > 0 && currentGaps[j] > largestGapSoFar) {
                //         largestGapSoFar = currentGaps[j];
                //         currentGaps[j] = 0;
                //     }
                // }
                int removedFromQueue = brickAllocations.remove();
                if(removedFromQueue != largestGapSoFar) {
                    // System.out.println("Largest found from queue=" + removedFromQueue + " | from array=" + largestGapSoFar);
                }
              
                // using the queue works, using the largestGapSoFar variable doesnt
                // bricks += largestGapSoFar;
                bricks += removedFromQueue;
            }
        }
        // made it to the end
        return heights.length - 1;
    }
}