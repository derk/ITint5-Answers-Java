import java.util.*;
public class Word {
    public List<String> transform(Set<String> dict, String from, String to) {
                HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String s : dict) {
            map.put(s, 0x7fffffff);
        }
        map.put(from, 0);

        Queue<String> q = new LinkedList<String>();
        q.offer(from);
        while(!q.isEmpty()) {
            String s = q.poll();
            int d = map.get(s);
            for(String t:dict) {
                if(isAdjacent(s,t) && map.get(t) == 0x7fffffff) {
                    map.put(t, d+1);
                    q.offer(t);
                    if(t.equals(to))
                        break;
                }
            }
        }
        LinkedList<String> r = new LinkedList<String>();
        if(map.get(to) == 0x7fffffff) {
            return r;
        }
        int dist = map.get(to);
        r.add(to);
        String curr = to;
        while(--dist >= 0) {
            for(String str:map.keySet()) {
                if(isAdjacent(str, curr) && map.get(str)==dist) {
                    r.addFirst(str);
                    curr = str;
                    break;
                }
            }
        }
        return r;
    }
    private static boolean isAdjacent(String a, String b) {
        if(a==null || b==null) return false;
        if(a.length() != b.length()) return false;
        int cnt = 0;
        if(a.equals(b)) return false;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i)!=b.charAt(i)) {
                cnt++;
            }
            if(cnt>1) {
                return false;
            }
        }
        return true;
 
    }
}
