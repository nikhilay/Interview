package leetcode.easy;

public class MovingAverage {
    /**
     * Initialize your data structure here.
     */
    int position = 0;
    int size;
    int[] data;
    int sum = 0;
    int den = 0;

    public MovingAverage(int size) {
        data = new int[size];
        this.size = size;
    }

    public double next(int val) {
        if (den < size) den++;
        sum -= data[position];
        sum += val;
        data[position] = val;
        position = (position + 1) % size;

        return (double) sum / den;
    }

}
