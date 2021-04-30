package leetcode.easy;

public class PeakIndexInAMountainArray {

    //https://leetcode.com/problems/peak-index-in-a-mountain-array/discuss/139848/C%2B%2BJavaPython-Better-than-Binary-Search
    public int peakIndexInMountainArray(int[] arr) {
     int start = 0;
     int end = arr.length - 1;
     int mid = 0;

        while(start <end){
            mid = (start + end)/2;
            if(arr[mid] < arr [mid+1]){
                start = mid +1;
            } else {
                end = mid;
            }

        }

     return  start;

    }
}
