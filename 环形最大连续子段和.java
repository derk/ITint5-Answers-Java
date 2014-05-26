public class MaxConsSum2 {
    public int maxConsSum2(int[] arr) {
        int max=0;
        int min=0;
        int currSumMax=0;
        int currSumMin=0;
        int sum=0;
        for(int i = 0; i < arr.length; i++) {
            currSumMax+=arr[i];
            currSumMin+=arr[i];
            max=Math.max(max, currSumMax);
            currSumMax=Math.max(currSumMax, 0);
            min=Math.min(min, currSumMin);
            currSumMin=Math.min(currSumMin, 0);
            sum+=arr[i];
        }
        return Math.max(max, Math.max(sum, sum-min));
    }
}
