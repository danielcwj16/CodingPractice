/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
/**
 * 
 */
import java.util.*;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0)
            return res;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval obj1, Interval obj2) {
                return obj1.start - obj2.start;
            }
        });

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval inter : intervals) {
            if (inter.start <= end) {
                end = Math.max(end, inter.end);
            } else {
                res.add(new Interval(start, end));
                start = inter.start;
                end = inter.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}