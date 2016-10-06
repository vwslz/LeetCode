import java.util.ArrayList;
import java.util.List;

// O()
public class InsertInterval_57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0, start = newInterval.start, end = newInterval.end;
        boolean inserted = false;
        List<Interval> res = new ArrayList<Interval>();

        for (Interval itr: intervals) {
            if (itr.end < start || inserted) {
                res.add(itr);
            }
            else if (itr.start > end) {
                res.add(new Interval(start, end));
                res.add(itr);
                inserted = true;
            }
            else {
                if (itr.start < start)
                    start = itr.start;
                if (itr.end > end)
                    end = itr.end;
            }
        }

        if (!inserted) {
            res.add(new Interval(start, end));
        }

        return res;
    }
}
