public class MergeSortedArray {
    public void mergeSortedArray(int[] arr1, int[] arr2, int n, int m) {
        if(m == 0) return;
        if(n == 0) {
            for(int i = 0; i < m; i++) {
                arr1[i] = arr2[i];
            }
            return;
        }
        int curr1 = n - 1;
        int curr2 = m - 1;
        int curr = n + m - 1;
        while(curr2 >= 0 && curr1 >= 0) {
            if(arr2[curr2] >= arr1[curr1]) {
                arr1[curr--] = arr2[curr2--];
            } else {
                arr1[curr--] = arr1[curr1--];
            }
        }
        while(curr2 >= 0) {
            arr1[curr--] = arr2[curr2--];
        }
    }
}
