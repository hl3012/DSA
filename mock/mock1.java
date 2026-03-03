import java.util.*;



// Given a binary array nums and an integer k, 
// return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
//                   l         *
// nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// 
// int[] freq = new int[2]
// int maxLen=0
// int l, r=0
// r==nums.length-1

// maxlen = 2
// freq[0] = 0
// freq[1] = 3
// num = 1
//maxLen=6  

//
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
// 

public class mock1 {
    public int maxLen(int[] nums, int k) {
        //1. save the freqency of 1, 0 into a map
        // Map<Integer,  Integer> freq = new HashMap<>();
        int[] freq = new int[2]; //idx=0 freq=0; idx=1, freq=0
        int maxLen=0;
        int left =0;              
        //2. two point left and right, go through each window and update the max
        for(int right=0;right<nums.length;right++) {                  
            int num = nums[right];
            freq[num]++;
            while(freq[0]>k) {
                int numLeft = nums[left];
                freq[numLeft]--;
                left++;
            }
            maxLen=Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
//          l
// [1,1,1,0,0,0,1,1,1,1,0]  k=2
//            r
// l                         1  2  3   4
// r       0  1  2  3  4  5
// freq[0]          1  2  3        2
// freq[1] 1  2  3        2  1  0
// maxLen  1  2  3  4  5               5
//    l
// [0,0,0]  k=2
//      r
// l       0     1             
// r       0  1
// freq[0] 1  2  1       
// freq[1] 
// maxLen  1  2  2

//[]   k=0
// maxLen=0

//[0]  k=0
//maxLen=1
