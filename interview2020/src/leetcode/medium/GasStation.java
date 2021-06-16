package leetcode.medium;

public class GasStation {
    //https://leetcode.com/problems/gas-station/discuss/42568/Share-some-of-my-ideas./180595
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalFuel = 0;
        int totalCost = 0;
        //determine if we have a solution
        for (int i = 0; i < gas.length; i++) {
            totalFuel += gas[i];
            totalCost += cost[i];
        }
        if (totalFuel < totalCost) {
            return -1;
        }

        //Find out the starting point
        int travelCost = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            travelCost += gas[i] - cost[i];
            if (travelCost < 0) {
                start = i + 1;
                travelCost = 0;
            }

        }
        return start;

    }
}
