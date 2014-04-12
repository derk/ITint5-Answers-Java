public class SelectGasStation {
    public int selectGasStation(int[] a, int[] g) {
        if(a == null || g == null || a.length != g.length) return -1;
        int totalLeftGas = 0;
        int leftGas = 0;
        int startIndex = 0;
        for(int i = 0; i < a.length; i++) {
            totalLeftGas += a[i] - g[i];
            leftGas += a[i] - g[i];
            if(leftGas < 0) {
                startIndex = i + 1;
                leftGas = 0;
            }
        }
        
        return totalLeftGas >= 0 ? startIndex : -1;
    }
}
