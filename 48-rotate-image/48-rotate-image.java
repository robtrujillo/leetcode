
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]

// [0][0] -> [0][2]
// [0][1] -> [1][2]
// [0][2] -> [2][2]

// [1][0] -> [0][1]
// [1][1] -> [1][1]
// [1][2] -> [2][1]

// [2][0] -> [0][0]
// [2][1] -> [1][0]
// [2][2] -> [2][0]

class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i< matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                if(matrix[i][j] > 1001) {
                    continue;
                }
                int temp = matrix[j][matrix.length - 1 - i];
                // multiply by -1 to mark that it has already been swapped
                matrix[j][matrix.length - 1 - i] = matrix[i][j] + 3000;
                matrix[i][j] = temp + 3000;
            }
        }
        for(int i = 0; i< matrix.length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                while(matrix[i][j] > 1000) {
                    matrix[i][j] = matrix[i][j] - 3000;
                }
            }
        }
        
    }
}