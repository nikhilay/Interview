package leetcode.medium;

public class JumpGame {
//https://leetcode.com/problems/jump-game/solution/
    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) return false;

        int dest = nums.length - 1;
        int start = nums.length - 1;

        while (start >= 0) {

            if (start + nums[start] >= dest) {
                dest = start;
            }
            start--;
        }


        return dest == 0;
    }

}
