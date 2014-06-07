public class Matrix {
    public boolean exists(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) return false;
        return exists(matrix, 0, 0, matrix.length-1, 
                       matrix[0].length-1, target);
    }
    private boolean exists(int[][] matrix, int x1, int y1, int x2, int y2,
                           int target) {
        if(x1>x2||y1>y2) return false;
        if(x1==x2&&y1==y2) return matrix[x1][y1]==target;
        int midx = (x1+x2)/2;
        int midy = (y1+y2)/2;
        if(matrix[midx][midy]==target) return true;
        else if(matrix[midx][midy]>target) {
            return exists(matrix, x1, y1, x2, midy-1, target)
                || exists(matrix, x1, midy, midx-1, y2, target);
        } else {
            return exists(matrix, x1, midy+1, x2, y2, target)
                || exists(matrix, midx+1, y1, x2, midy, target);
        }
    }
}
