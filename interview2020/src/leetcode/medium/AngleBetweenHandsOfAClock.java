package leetcode.medium;

public class AngleBetweenHandsOfAClock {
    //https://leetcode.com/problems/angle-between-hands-of-a-clock/discuss/502738/JavaPythonC%2B%2B-Simple-Math-on-Clock-angles
    public double angleClock(int hour, int minutes) {

        double hourAngle = (hour % 12) * 30 + minutes * 0.5;
        double minutesAngle = minutes * 6;

        double diff = Math.abs(hourAngle - minutesAngle);

        return diff > 180 ? 360 - diff : diff;

    }
}
