package LeetCode;
//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//Example:
//
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].

import java.util.HashMap;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        // starting in position 0 and check it;
        int len = nums.length;
        for(int i = 0; i< len ; i ++){
            for(int j = i +1; j < len; j ++){
                if(nums[i] + nums[j] == target)
                    return new int[]{i,j};
            }
        }
        throw new IllegalArgumentException( " no result");
    }

    // to improve running time we can use HashTable
    public int[] twoSumMap(int[] nums , int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i ++) // set up map
            map.put(nums[i], i);
        for(int i = 0; i < len ; i ++){
            int complete = target - nums[i];
            // since value cannot be the same values are unique
            if(map.containsKey(complete) && map.get(complete) != i)
                return new int[]{i,map.get(complete)};
        }
        throw new IllegalArgumentException( " no result");
    }
}
