/*积木的定义(请不要在代码中定义该结构)
public class Box {
  int vol, weight;
}*/

import java.util.*;

public class MaxBox {
    public int maxBoxes(Box[] boxes) {
        if(boxes==null || boxes.length==0) return 0;
        boxes = msort(boxes);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(boxes.length-1, 1);
        for(int i = boxes.length-2; i>=0;i--){
            lis(boxes,i,map);
        }
        int max = 0;
        for(int i : map.values()) {
            max = Math.max(max, i);
        }
        return max;
    }
    private void lis(Box[] boxes, int i, HashMap<Integer, Integer> map) {
        if(map.containsKey(i)) return;
        int max = 0;
        for(int j = i+1; j < boxes.length; j++) {
            if(boxes[j].vol>boxes[i].vol && boxes[j].weight>boxes[i].weight){
                max = Math.max(max, map.get(j));
            }
        }
        max++;
        map.put(i,max);
    }
    private Box[] msort(Box[] arr) {
        if(arr==null || arr.length<=1) return arr;
        Box[] left = msort(Arrays.copyOfRange(arr,0,arr.length/2));
        Box[] right = msort(Arrays.copyOfRange(arr,arr.length/2, arr.length));
        return merge(left, right);
    }
    private Box[] merge(Box[] a, Box[] b) {
        Box[] r = new Box[a.length+b.length];
        int curr = 0;
        int curra = 0;
        int currb = 0;
        while(curra<a.length && currb<b.length) {
            if(a[curra].vol <= b[currb].vol) {
                r[curr++]=a[curra++];
            }else {
                r[curr++]=b[currb++];
            }
        }
        while(curra<a.length) {
            r[curr++]=a[curra++];
        }
        while(currb<b.length) {
            r[curr++]=b[currb++];
        }
        return r;
    }
}
