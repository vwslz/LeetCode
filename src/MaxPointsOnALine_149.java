import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine_149 {
    public int maxPoints(Point[] points) {
        if (points == null)
            return 0;

        int res = 0;
        Map<Integer,Map<Integer,Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int samePoint = 1;
            int localRes = 0;
            for (int j = i + 1; j < points.length; j++) {
                int deltaX = points[i].x - points[j].x;
                int deltaY = points[i].y - points[j].y;
                if (deltaX == 0 && deltaY == 0)
                    samePoint++;
                else {
                    int gcd = getGcd(deltaX, deltaY);
                    deltaX /= gcd;
                    deltaY /= gcd;
                    if (!map.containsKey(deltaX)) {
                        Map<Integer, Integer> mapForY = new HashMap<Integer, Integer>();
                        map.put(deltaX, mapForY);
                    }
                    if (map.get(deltaX).containsKey(deltaY))
                        map.get(deltaX).put(deltaY, map.get(deltaX).get(deltaY) + 1);
                    else
                        map.get(deltaX).put(deltaY, 1);
                    if (map.get(deltaX).get(deltaY) > localRes)
                        localRes = map.get(deltaX).get(deltaY);
                }
            }
            if (localRes + samePoint > res)
                res = localRes + samePoint;
        }
        return res;
    }

    public int getGcd(int int1, int int2)
    {
        if (int2 == 0)
            return int1;
        else
            return getGcd(int2, int1 % int2);
    }
}