package leetcode.medium;

public class JumpGame2 {
    //https://leetcode.com/problems/jump-game-ii/solution/
    public int jump(int[] nums) {
        int jumps = 0;
        int farthestJump = 0;
        int currentJumpEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthestJump = Math.max(farthestJump, i + nums[i]);

            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthestJump;
            }
        }
        return jumps;
    }

}
