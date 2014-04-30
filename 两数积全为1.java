import java.util.*;

public class MinAllOne {
    public int findMinAllOne(int a) {
        if(a <= 0) {
            return -1;
        }
        int d1 = a % 10;
        if(!(d1 == 1 || d1 == 3 || d1 == 7 || d1 == 9)) {
            return -1;
        }
        HashSet<Integer> reminders = new HashSet<Integer>();
        int r = 0;
        int len=0;
        while(true) {
            r = r*10+1;
            len++;
            r = r%a;
            if(r == 0) {
                return len;
            }
            if(reminders.contains(r)) {
                return -1;
            }
            reminders.add(r);
        }
        
    }
}
