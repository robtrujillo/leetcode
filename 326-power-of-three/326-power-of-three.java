class Solution {
    public boolean isPowerOfThree(int n) {
        // the constraint is a trick. n < 1 is not a power of 3 by default
        if (n == 1) {
            return true;
        }
        // check if power of 3
        double base = 3;
        double curr = n;
        while(curr > 1) {
            if (curr == 3) {
                return true;
            }
            curr = curr / base;
            if(curr % 1 != 0) {
                return false;
            }
            
        }
        return false;
    }
}