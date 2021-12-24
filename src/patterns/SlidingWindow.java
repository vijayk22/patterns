package patterns;

//Sliding window pattern
public class SlidingWindow {
    static int maxSubArrayOfKSize(int k, int[] arr) {
        int maxSum = 0, winSum=0, winStart=0, winEnd=0;
        for(winEnd=0; winEnd < arr.length; winEnd++) {
           winSum+=arr[winEnd];
           if(winEnd > k -1) {
                maxSum = Math.max(maxSum, winSum);

                winSum -=arr[winStart];
                winStart++;
           }
        }
        return maxSum;
    }
}
