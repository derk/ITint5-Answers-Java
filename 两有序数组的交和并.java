public class Arrays {
    public int[] arrayUnion(int[] a, int[] b) {
        if(a == null || b == null) return null;
               
        int currA = 0;
        int currB = 0;
        int curr = 0;
        int[] r = new int[a.length + b.length];
        while(currA < a.length && currB < b.length) {
            if(a[currA] < b[currB]) {
                r[curr++] = a[currA++];
                if(curr - 2 >= 0 && (r[curr - 2] == r[curr - 1])) {
                    curr--;
                }
            } else if(a[currA] > b[currB]) {
                r[curr++] = b[currB++];
                if(curr - 2 >= 0 && (r[curr - 2] == r[curr - 1])) {
                    curr--;
                }
            } else {
                r[curr++] = a[currA++];
                currB++;
                if(curr - 2 >= 0 && (r[curr - 2] == r[curr - 1])) {
                    curr--;
                }
            }
        }
        while(currA < a.length) {
            r[curr++] = a[currA++];
            if(curr - 2 >= 0 && (r[curr - 2] == r[curr - 1])) {
                curr--;
            }
        }
        while(currB < b.length) {
            r[curr++] = b[currB++];
            if(curr - 2 >= 0 && (r[curr - 2] == r[curr - 1])) {
                curr--;
            }
        }
        return java.util.Arrays.copyOf(r, curr);
    }

    public int[] arrayIntersect(int[] a, int[] b) {
        if(a == null || b == null) return null;
        if(a.length == 0 || b.length == 0) return new int[0];
        
        int currA = 0;
        int currB = 0;
        int curr = 0;
        int[] r = new int[Math.min(a.length, b.length)];
        while(currA < a.length && currB < b.length) {
            if(a[currA] < b[currB]) {
                currA++;
            } else if (a[currA] > b[currB]) {
                currB++;
            } else {
                r[curr++] = a[currA++];
                currB++;
                if(curr - 2 >= 0 && (r[curr - 2] == r[curr - 1])) {
                    curr--;
                }
            }
        }
        return java.util.Arrays.copyOf(r, curr);
    }
}
