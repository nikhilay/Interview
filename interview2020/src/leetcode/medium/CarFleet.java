package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class CarFleet {
    //https://leetcode.com/problems/car-fleet/discuss/139850/C%2B%2BJavaPython-Straight-Forward
    public int carFleet(int target, int[] position, int[] speed) {

        double[][] timeTaken = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            timeTaken[i][0] = position[i];
            timeTaken[i][1] = (double)(target - position[i]) / speed[i];
        }
        Arrays.sort(timeTaken, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o1[0]>o2[0]) return 1;
                if(o1[0]<o2[0]) return -1;
                return 0;
            }
        });
        for(int i=0;i<timeTaken.length;i++){
            System.out.println(timeTaken[i][0] + " " + timeTaken[i][1]);
        }
        int fleet = 0;
        double maxTime = 0;
        for (int i = position.length - 1; i >= 0; i--) {
            if (timeTaken[i][1] > maxTime) {
                maxTime = timeTaken[i][1];
                fleet++;
            }
        }
        return fleet;
    }
}
