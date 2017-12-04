import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class CourseScheduleII_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Hashtable<Integer, List<Integer>> ins = new Hashtable<Integer, List<Integer>>();
        int[] outs = new int[numCourses];

        for (int[] arr: prerequisites)
        {
            outs[arr[0]]++;
            if (ins.containsKey(arr[1]))
                ins.get(arr[1]).add(arr[0]);
            else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(arr[0]);
                ins.put(arr[1], list);
            }
        }

        int[] res = new int[numCourses];
        int index = 0;
        for (int i = 0; i < numCourses; i++)
        {
            if (outs[i] == 0) {
                res[index++] = i;
            }
        }
        int i = 0;
        while (i < index && i < numCourses)
        {
            if (ins.containsKey(res[i])) {
                for (int out : ins.get(res[i])) {
                    outs[out]--;
                    if (outs[out] == 0)
                        res[index++] = out;
                }
            }
            i++;
        }
        if (index == numCourses)
            return res;
        else
            return new int[0];
    }
}
