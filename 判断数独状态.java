import java.util.HashSet;

public class Sudoku {
    public boolean isValidSudoku(int[] arr) {
        if(arr == null || arr.length != 81) return false;
        //row
        for(int i = 0; i < 9; i++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for(int j = 0; j < 9; j++) {
                int d = arr[i * 9 + j];
                if(d >= 1 && d <= 9) {
                    if(set.contains(d)) return false;
                    else set.add(d);
                } else {
                    return false;
                }
            }
        }
        //collumn
        for(int j = 0; j < 9; j++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for(int i = 0; i < 9; i++) {
                int d = arr[i * 9 + j];
                if(d >= 1 && d <= 9) {
                    if(set.contains(d)) return false;
                    else set.add(d);
                } else {
                    return false;
                }
            }
        }
        //3 x 3 area
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                HashSet<Integer> set = new HashSet<Integer>();
                for(int m = 0; m < 3; m++) {
                    for(int n = 0; n < 3; n++) {
                        int r = i * 3 + m;
                        int c = j * 3 + n;
                        int index = r * 9 + c;
                        int d = arr[index];
                        if(d >= 1 && d <= 9) {
                            if(set.contains(d)) return false;
                            else set.add(d);
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
