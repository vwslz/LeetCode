import java.util.*;

// O(n)
public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        Queue<Integer> queue = new LinkedList<>();
        int num = 0, i;

        int[] ins = new int[numCourses];;

        for (i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (!map.containsKey(pre)) {
                map.put(pre, new ArrayList());
            }
            map.get((pre)).add(course);
            ins[course]++;
        }

        for (i = 0; i < numCourses; i++) {
            if (ins[i] == 0) {
                queue.add(i);
                num++;
            }
        }

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (map.containsKey(temp)) {
                for (Integer itg: map.get(temp)) {
                    ins[itg] -= 1;
                    if (ins[itg] == 0) {
                        queue.add(itg);
                        num++;
                    }
                }
            }
        }

        return num == numCourses;
    }
}
