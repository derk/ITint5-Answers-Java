/*点的定义
public class Point {
    double x,y;
}*/
import java.util.Arrays;

public class Line {
    public int maxPointsOnLine(Point[] points) {
        if(points==null||points.length==0) return 0;
        if(points.length<3) return points.length;
        int max=2;
        for(int i=0;i<points.length;i++){
            double[] rs = new double[points.length-1];
            int sameXCount = 1;
            for(int j=0;j<points.length;j++){
                if(i==j) continue;
                if(points[i].x==points[j].x){
                    sameXCount++;
                }
                double r=(points[i].y-points[j].y)/(points[i].x-points[j].x);
                if(j<i) {
                    rs[j]=r;
                } else {
                    rs[j-1]=r;
                }
            }
            Arrays.sort(rs);
            int count=2;
            int index =0;
            while(index<rs.length-1) {
                if(Math.abs(rs[index]-rs[index+1])<1.0e-7){
                    count++;
                }else {
                    max=count>max?count:max;
                    count=2;
                }
                index++;
            }
            max=max<sameXCount?sameXCount:max;
        }
        return max;
    }
}
