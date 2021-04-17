package leetcode.easy;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int[] result =  {0,0};
        for(int i = 0; i<moves.length();i++){
            if(moves.charAt(i) == 'R'){
                result[0]++;
            } else if(moves.charAt(i) == 'L'){
                result[0]--;
            }else if(moves.charAt(i) == 'U'){
                result[1]++;
            }else if(moves.charAt(i) == 'D'){
                result[1]--;
            }
        }
        return result[0] == 0 && result[1] == 0 ;
    }
}
