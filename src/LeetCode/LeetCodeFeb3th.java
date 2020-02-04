package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCodeFeb3th {
    // Two Sum  #1
    // Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    //
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //Example:
    //
    //Given nums = [2, 7, 11, 15], target = 9,
    //
    //Because nums[0] + nums[1] = 2 + 7 = 9,
    //return [0, 1].
        public int[] twoSum(int[] nums, int target) {
            for(int i =0; i < nums.length; i ++){
                for(int j = i+1; j<nums.length; j ++){
                    if(nums[i] + nums[j] == target)
                        return new int[]{i,j};
                }
            }
            throw new IllegalArgumentException("no result");
        }
    // 2. Reverse Integer
    // Given a 32-bit signed integer, reverse digits of an integer.
        public int reverse(int x) {
            int result = 0;
            while (x != 0){
                int remind = x % 10;
                x = x /10;
                if( result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE && remind > 7 )
                    return 0;
                if( result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE && remind < -8)
                    return 0;
                result = result * 10 + remind;
            }
            return result;
        }
    // 3. Palindrome Number
    // Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
        public boolean isPalindrome(int x) {
            boolean result = false;
            int revernumber = 0;
            if( x < 0 || ( x % 10 == 0 && x != 0))
                return false;
            while ( x > revernumber){
                revernumber = revernumber * 10 + x % 10;
                x /= 10;
            }
            if(x == revernumber || x == revernumber/10)
                result = true;
            return result;
        }
    // 4. Roman to Integer
    // Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    // Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
        public int romanToInt(String s) {
            Map<Character,Integer> map = new HashMap<>();
            map.put('I',1);
            map.put('V',5);
            map.put('X',10);
            map.put('L',50);
            map.put('C',100);
            map.put('D',500);
            map.put('M', 1000);

            int len = s.length();
            int sum = map.get(s.charAt(len -1));

            for( int i = len -2 ; i >= 0 ; --i){
                if(map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))
                    sum = sum - map.get(s.charAt(i));
                else
                    sum = sum + map.get(s.charAt(i));
            }
            return sum;
        }
        // 5 .Longest Common Prefix
    //Write a function to find the longest common prefix string amongst an array of strings.
    //
    //If there is no common prefix, return an empty string "".
        public String longestCommonPrefix(String[] strs) {

            if(strs.length == 0) return  "";
            String prefix = strs[0];
            for( int i = 1 ; i < strs.length; i ++){
                while ( strs[i].indexOf(prefix) != 0){
                    prefix = prefix.substring(0, prefix.length()-1);
                    if(prefix.isEmpty())    return "";
                }
            }
            return prefix;
        }
        // 6. Valid Parentheses
    // Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    //
    //An input string is valid if:
    //
    //Open brackets must be closed by the same type of brackets.
    //Open brackets must be closed in the correct order.
    //Note that an empty string is also considered valid.
        public boolean isValid(String s) {
            HashMap<Character,Character> map = new HashMap<>();
            map.put('(', ')');
            map.put('[',']');
            map.put('<','>');
            map.put('{','}');

            Stack<Character> stack = new Stack<Character>();
            for( int i = 0; i < s.length(); i ++){
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    char top = stack.empty() ?  '#' : stack.pop();
                    // '#' set dummy value
                    if(top != map.get(c))   return false;
                    else
                        stack.push(c);
                }
            }
            return stack.isEmpty();
        }
        // 7. Merge Two Sorted Lists
    //Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return  l2;
            else if (l2 == null)    return  l1;
            else if (l1.val < l2.val){
                l1.next = mergeTwoLists(l1.next,l2);
                return l1;
            }
            else{
                l2.next = mergeTwoLists(l1, l2.next);
                return  l2;
            }
        }
        public class ListNode{
            int val;
            ListNode next;
            ListNode (int x ) {val = x;}
        }
        // 8. Remove Duplicates from Sorted Array
    //Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
    //
    //Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
        public int removeDuplicates(int[] nums) {
            if(nums.length == 0) return 0;
            int i = 0;
            for( int j = 1 ; j < nums.length ; j ++){
                if(nums[j] != nums[i]){
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i +1;
        }
        // 9. Remove Element
    //Given an array nums and a value val, remove all instances of that value in-place and return the new length.
    //
    //Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    //
    //The order of elements can be changed. It doesn't matter what you leave beyond the new length.
        public int removeElement(int[] nums, int val) {
            int i = 0;
            for( int j = 0 ; j < nums.length; j ++){
                if( nums[j] != val){
                    nums[i] = nums[j];
                    i++;
                }
            }
            return i;
        }
        // 10.  Implement strStr()
    // Implement strStr().
    //
    //Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
        public int strStr(String haystack, String needle) {
            int hlen = haystack.length();
            int nlen = needle.length();

            for( int i = 0; i < hlen - nlen + 1; ++i){
                if(haystack.substring(i, i + nlen).equals(needle))
                    return i;
            }
            return -1;
        }
}
