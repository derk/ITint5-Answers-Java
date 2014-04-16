public class MaxConsSum {
    public int maxConsSum(int[] arr) {
        int max = 0;
        int currSum = 0;
        for(int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            max = Math.max(max, currSum);
            currSum = Math.max(0, currSum);
        }
        return max;
    }
}
