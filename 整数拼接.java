import java.util.Arrays;

public class ConcatNums {
    public String biggestNum(String[] nums) {
        /*
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(cmpString(nums[i], nums[j]) == -1) {
                    String t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
        */
        nums = mergesort(nums);
        StringBuilder sb = new StringBuilder();
        for(String s : nums) {
            sb.append(s);
        }
        return sb.toString();
    }
    private static String[] mergesort(String[] nums) {
        if(nums.length <= 1) return nums;
        String[] l = mergesort(Arrays.copyOfRange(nums, 0, nums.length / 2));
        String[] r = mergesort(Arrays.copyOfRange(nums, nums.length / 2, nums.length));
        return merge(l, r);
        
    }
    private static String[] merge(String[] l, String[] r) {
        String[] sa = new String[l.length + r.length];
        int curr = 0, currL = 0, currR = 0;
        while(currL < l.length && currR < r.length) {
            if(cmpString(l[currL], r[currR]) >= 0) {
                sa[curr++] = l[currL++];
            } else {
                sa[curr++] = r[currR++];
            }
        }
        while(currL < l.length) {
            sa[curr++] = l[currL++];
        }
        while(currR < r.length) {
            sa[curr++] = r[currR++];
        }
        return sa;
    }
    //s1 s2 cannot be null and only contain digits
    private static int cmpString(String s1, String s2) {
        if(s1.equals(s2)) return 0;
        int swapped = 1;
        if(s1.length() > s2.length()) {
            String t = s1;
            s1 = s2;
            s2 = t;
            swapped = -1;
        }
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) < s2.charAt(i)) return -1 * swapped;
            else if(s1.charAt(i) > s2.charAt(i)) return swapped;
        }
        //s2 must be longer than s1 now
        return cmpString(s1, s2.substring(s1.length())) * swapped;
    }
}
