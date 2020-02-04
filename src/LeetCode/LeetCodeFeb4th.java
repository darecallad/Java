package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class LeetCodeFeb4th {
    // 1.Search Insert Position
    // Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
    //
    //You may assume no duplicates in the array.
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length-1; i ++){
            if( nums[i] == target)
                return i;
            else if( nums[i] < target && nums[i+1] > target)
                return i+1;
        }
        return -1;
    }
    // 2. Count and Say
    // The count-and-say sequence is the sequence of integers with the first five terms as following:
    //
    //1.     1
    //2.     11
    //3.     21
    //4.     1211
    //5.     111221
    //
    public String countAndSay(int n) {

                LinkedList<Integer> prevSeq = new LinkedList<Integer>();
                prevSeq.add(1);
                // Using -1 as the delimiter
                prevSeq.add(-1);

                List<Integer> finalSeq = this.nextSequence(n, prevSeq);
                StringBuffer seqStr = new StringBuffer();
                for (Integer digit : finalSeq) {
                    seqStr.append(String.valueOf(digit));
                }
                return seqStr.toString();
            }

            protected LinkedList<Integer> nextSequence(int n, LinkedList<Integer> prevSeq) {
                if (n <= 1) {
                    // remove the delimiter before return
                    prevSeq.pollLast();
                    return prevSeq;
                }

                LinkedList<Integer> nextSeq = new LinkedList<Integer>();
                Integer prevDigit = null;
                Integer digitCnt = 0;
                for (Integer digit : prevSeq) {
                    if (prevDigit == null) {
                        prevDigit = digit;
                        digitCnt += 1;
                    } else if (digit == prevDigit) {
                        // in the middle of the sub-sequence
                        digitCnt += 1;
                    } else {
                        // end of a sub-sequence
                        nextSeq.add(digitCnt);
                        nextSeq.add(prevDigit);
                        // reset for the next sub-sequence
                        prevDigit = digit;
                        digitCnt = 1;
                    }
                }

                // add the delimiter for the next recursion
                nextSeq.add(-1);
                return this.nextSequence(n - 1, nextSeq);
            }
        // 3. Maximum Subarray
    // Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.


}
