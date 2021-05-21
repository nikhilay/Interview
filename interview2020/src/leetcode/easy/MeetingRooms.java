package leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
 //https://leetcode.com/problems/meeting-rooms/discuss/67786/AC-clean-Java-solution
        if (intervals == null) return false;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] object1, int[] object2) {
                return object1[0] - object2[0];
            }
        });

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<intervals[i-1][1]){
                return false;
            }
        }
    return true;
    }

}
