/*
存放a,b,c的三元组
public class ABC {
  public int a, b, c;
  public ABC(int a, int b, int c) {
    this.a=a;this.b=b;this.c=c;
  }
}
*/
import java.util.*;
public class ThreeSumZero {
    //返回所有满足条件的(a,b,c)三元组
    public List<ABC> threeSumZero(int[] arr) {
        List<ABC> r = new ArrayList<ABC>();
        Arrays.sort(arr);
        if(arr.length<3) return r;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int p=-(arr[i]+arr[j]);
                int k=Arrays.binarySearch(arr,j+1,arr.length, p);
                if(k>=j+1){
                    ABC t = new ABC(arr[i], arr[j], p);
                    if(r.size()==0){
                        r.add(t);
                    }else{
                        insert(r,t);
                    }
                }
            }
        }
        return r;
    }
    private static void insert(List<ABC> list, ABC t) {
        //insert t to an already sorted ABC list
        int index = list.size();
        while(compare(t,list.get(index-1))<0) {
            index--;
        }
        if(compare(t,list.get(index-1))!=0) {
            list.add(index, t);
        }
    }
    private static int compare(ABC m, ABC n) {
        if(m.a!=n.a) return m.a-n.a;
        if(m.b!=n.b) return m.b-n.b;
        if(m.c!=n.c) return m.c-n.c;
        return 0;
    }
}
