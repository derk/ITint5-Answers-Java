public class RotateSortedArray {
    public int search(int[] arr, int target) {
        if(arr==null || arr.length==0) return -1;
        int start = 0;
        int end = arr.length;
        while(start < end) {
            int mid = (start + end) / 2;
            if(mid == start && arr[mid] != target) {
                return -1;
            }
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > arr[0]) {
                if(target >= arr[0] && target < arr[mid]) {
                    end = mid;
                } else if(target > arr[mid] || target <= arr[end-1]) {
                    start = mid + 1;
                }
            } else if(arr[mid] <= arr[end - 1]) {
                if(target >= arr[0] || target < arr[mid]) {
                    end = mid;
                } else if(target > arr[mid] && target <=arr[end - 1]) {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
