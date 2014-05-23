import java.util.Arrays;

public class Median {
    public int median(int[] arr1, int[] arr2) {
        if((arr1.length +arr2.length) %2==0) {
            int m = findKth(arr1, arr2, (arr1.length +arr2.length)/2);
            int n = findKth(arr1, arr2, (arr1.length +arr2.length)/2-1);
            return (m+n)/2;
        }else {
            return findKth(arr1, arr2, (arr1.length +arr2.length)/2);
        }
    }

    /**
     * @param a 1st arr
     * @param b 2nd arr
     * @param k 0 based
     * @return found value
     */
    private int findKth(int[] a, int[] b, int k) {
        assert k < a.length + b.length;
        if (a.length < b.length) {
            return findKth(b, a, k);
        }
        if (b.length == 0) {
            return a[k];
        }
        if (k == 0) {
            return Math.min(a[0], b[0]);
        }
        if (k == 1) {
            if (a.length > 1 && b.length > 1) {
                return Math.min(Math.min(a[0] + b[0] - Math.min(a[0], b[0]), a[1]), b[1]);
            } else if (a.length > 1) {
                return Math.min(a[0] + b[0] - Math.min(a[0], b[0]), a[1]);
            } else {
                return a[0] + b[0] - Math.min(a[0], b[0]);
            }
        }
        if (b.length <= k / 2) {
            int b0 = b[b.length - 1];
            int a0 = a[k / 2];
            if (a0 <= b0) {
                return findKth(Arrays.copyOfRange(a, k / 2, a.length), b, k - k / 2);
            } else {
                return findKth(a, new int[0], k - b.length);
            }
        } else {
            int b0 = b[k / 2];
            int a0 = a[k / 2];
            if(a0 <= b0) {
                return findKth(Arrays.copyOfRange(a, k / 2, a.length), b, k - k / 2);
            } else {
                return findKth(a, Arrays.copyOfRange(b, k / 2, b.length), k - k / 2);
            }
        }
    }
}
