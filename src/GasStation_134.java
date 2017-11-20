public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0)
            return -1;
        int[] prev = {0, -1};
        int[] next = {0, -1};

        for (int i = 0; i < gas.length; i++) {
            int current = gas[i] - cost[i];
            if (current > 0) {
                if (next[1] >= 0)
                    next[0] += current;
                else if (prev[0] <= 0) {
                    next[0] = current;
                    next[1] = i;
                } else
                    prev[0] += current;
            } else {
                if (next[1] < 0)
                    prev[0] += current;
                else {
                    next[0] += current;
                    if (next[0] < 0) {
                        prev[0] += next[0];
                        next[1] = -1;
                    }
                }
            }
        }
        if (prev[0] + next[0] < 0)
            return -1;
        if (next[1] > -1)
            return next[1];
        else
            return 0;
    }
}
