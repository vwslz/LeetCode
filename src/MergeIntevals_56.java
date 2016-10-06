import java.util.*;

// O(nlogn)
public class MergeIntevals_56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();

        // sort inputs
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end; // if start time is same,
            }
        });

        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        for (Interval interval : intervals) {
            if (start == Integer.MAX_VALUE) {
                start = interval.start;
                end = interval.end;
            }
            else {
                if (interval.start > end) {
                    res.add(new Interval(start, end));
                    start = interval.start;
                    end = interval.end;
                }
                else {
                    if (interval.end > end)
                        end = interval.end;
                }
            }
        }
        if (start != Integer.MAX_VALUE)
            res.add(new Interval(start, end));
        return res;
    }
}
