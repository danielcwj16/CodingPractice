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
 * 和meeting rooms的方法类似，用两个数组记录start和end，然后排序
 */
class MeetingRooms {
    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for(int i=0;i<intervals.length;i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int res = 0;
        int endpos = 0;
        for(int i=0;i<start.length;i++){
            if(start[i]<end[endpos]) res++;
            else{
                endpos++;
            }
        }
        return res;
    }
}