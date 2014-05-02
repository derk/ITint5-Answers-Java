import java.util.List;
import java.util.Map;
import java.util.*;
public class JobScheduler {
    /*
     * deps[id]表示任务id所依赖的任务
     * 如果存在合法的任务完成序列，返回true，否则返回false
     * 合法的任务序列请存放在参数result中（已经分配空间）
     */
    public boolean jobSchedule(Map<Integer, List<Integer>> deps, int n,
                                int[] result) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int k:deps.keySet()) {
            if(deps.get(k).size()!=0){
                set.add(k);
            }
        }
        int curr=0;
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                result[curr++]=i;
            }
        }
        boolean changed = true;
        while(changed && set.size()!=0) {
            Iterator iter = set.iterator();
            changed = false;
            while(iter.hasNext()){
                Integer e = (Integer)iter.next();
                boolean canDo = true;
                for(int d:deps.get(e)){
                    if(set.contains(d)) {
                        canDo=false;
                        break;
                    }
                }
                if(canDo){
                    iter.remove();
                    result[curr++]=e;
                    changed=true;
                }
            }
        }
        return set.isEmpty();
   }
}
