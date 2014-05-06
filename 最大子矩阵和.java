public class Matrix {
    public int maxRectSum(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) {
            return 0;
        }
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            int[] arr = new int[matrix[i].length];
            for(int j = i; j < matrix.length; j++) {
                for(int k = 0; k < matrix[j].length; k++) {
                    arr[k] += matrix[j][k];
                }
                max = Math.max(maxSum(arr), max);
            }
        }
        return max;
    }
    private static int maxSum(int[] arr) {
        int max = 0;
        int currSum = 0;
        for(int i = 0; i < arr.length; i++) {
            currSum+=arr[i];
            max = Math.max(max, currSum);
            currSum = Math.max(0,currSum);
        }
        return max;
    }
}
