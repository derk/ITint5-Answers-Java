public class Grid {
    public int totalPath(boolean[][] blocked) {
        if(blocked==null || blocked.length==0 || blocked[0].length==0) {
            return 0;
        }
        int m = blocked.length;
        int n = blocked[0].length;
        int[][] paths = new int[m][n];
        if(!blocked[0][0]) {
            paths[0][0]=1;
        }else {
            return 0;
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i==0 && j==0) {
                    continue;
                }else if(i==0) {
                    if(blocked[0][j]) {
                        paths[0][j] = 0;
                    } else {
                        paths[0][j] = paths[0][j-1];
                    }
                }else if(j==0) {
                    if(blocked[i][0]) {
                        paths[i][0] = 0;
                    } else {
                        paths[i][0] = paths[i-1][0];
                    }
                }else {
                    if(blocked[i][j]) {
                        paths[i][j] = 0;
                    } else {
                        paths[i][j] = paths[i-1][j] + paths[i][j-1];
                    }
                }
                
            }
        }
        return paths[m-1][n-1];
    }
}
