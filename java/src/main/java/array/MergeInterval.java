package main.java.array;

/**
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * They are sorted based on start times. Start1 will always be less than Start2.
 * Start2<End1, so they are overlapping. So we will merge them and get [Start1, Max(End1, End2)]
 * Dont care about the Endtime.
 * If Start2>End1, then they are not overlapping. [Start1, End1] [Start2, End2]
 * If the arrays are not sorted, sort them based on start times first.
 * Max of (Start1,Start2)< Min (E1,E2) - if arrays are not sorted.
 * June 7.
 */
public class MergeInterval {

    @Override
    public String toString() {
            return super.toString();
    }
}
