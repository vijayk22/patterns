package patterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
//https://www.educative.io/courses/grokking-the-coding-interview/3jyVPKRA8yx
class Interval {
   int start, end;
   public Interval(int start, int end) {
        this.start = start;
        this.end = end;
   }
}
public class MergeIntervals {

    static List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() < 2)
            return intervals;

        List<Interval> merged = new ArrayList<>();
        //sort intervals by start time, that way need to worry about end time only.
        Collections.sort(intervals, (a,b)-> Integer.compare(a.start, b.start));
        Iterator<Interval> itr = intervals.iterator();
        //Get the first interval start end time
        Interval interval = itr.next();
        int prevStart = interval.start, prevEnd = interval.end;

        //iterator over 2nd one and onwards
        while(itr.hasNext()) {
            Interval currInterval = itr.next();
            //if current start overlap with previous end
            if(currInterval.start <= prevEnd) {
               prevEnd = Math.max(currInterval.end, prevEnd); //adjust end
               //no need to adjust start as it is sorted, so it will be same or less
            } else {
                merged.add(new Interval(prevStart, prevEnd)); //add prev interval for no overlapping
                //reset for next iteration
                prevStart = currInterval.start;
                prevEnd = currInterval.end;
            }
        }
        //add the last interval
        merged.add(new Interval(prevStart, prevEnd));
        return merged;
    }
    public static void main(String[] args) {
       List<Interval> input = new ArrayList<>();
       input.add(new Interval(1,4));
       input.add(new Interval(2,5));
       input.add(new Interval(7,9));

       for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
       System.out.println();
        //output: [1,5] [7,9]
    }
}
