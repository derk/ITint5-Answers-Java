import java.util.*;
public class Generator {
    List<String> generate(int n) {
        List<String> list = new ArrayList<String>();
        for(String s:generate2(n)){
            list.add(s);
        }
        return list;
    }
    private static Set<String> generate2(int n) {
        Set<String> set = new HashSet<String>();
        if(n==0) return set;
        if(n==1) {
            set.add("()");
            return set;
        }
        for(String s : generate2(n-1)) {
            set.add("()"+s);
            for(int i = 1; i <= s.length(); i++) {
                set.add(s.substring(0,i)+"()"+s.substring(i));
            }
        }
        return set;
    }
}
