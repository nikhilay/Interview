package leetcode.easy;

public class NumberOfDaysBetweenTwoDates {
    //https://leetcode.com/problems/number-of-days-between-two-dates/discuss/517605/Similar-to-day-of-the-year/457557
    //https://stackoverflow.com/a/725110
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(noOfDays(date1) - noOfDays(date2));
    }

    private int noOfDays(String date) {
        String[] dateArr = date.split("-");
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int y = Integer.valueOf(dateArr[0]);
        int m = Integer.valueOf(dateArr[1]);
        int days = Integer.valueOf(dateArr[2]);
        for (int start = 1971; start < y; start++) {
            days += 365;
            if (isLeap(start)) days++;
        }

        for (int month = 0; month < m - 1; month++) {
            days+=months[month];
        }
        if (m > 2 && isLeap(y)) days += 1; // on Feb leap year have 29 days instead of 28
        return days;
    }

    private boolean isLeap(int y) {
        return (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0));
    }
}
