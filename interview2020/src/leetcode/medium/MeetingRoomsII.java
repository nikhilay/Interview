package leetcode.medium;

import java.util.Arrays;

public class MeetingRoomsII {
    //https://leetcode.com/problems/meeting-rooms-ii/discuss/67855/Explanation-of-%22Super-Easy-Java-Solution-Beats-98.8%22-from-%40pinkfloyda
    public int minMeetingRooms(int[][] intervals) {
        int meetingRooms = 0;
        if (intervals == null || intervals.length == 0) return meetingRooms;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
         int endIndex = 0;
        for (int startIndex = 0; startIndex < intervals.length; startIndex++) {

            if(start[startIndex]<end[endIndex]){
                meetingRooms++;
            } else{
                endIndex++;
            }
        }
    return meetingRooms;
    }
}
