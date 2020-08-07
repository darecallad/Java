package LeetCode;

public class Containerwithmostwater {
    public int maxArea(int[] height) {
        // in this case we need to find the max area between 2 line
        // so first we need to set up maxarea = 0 and two pointers left and right
        int maxarea =0;
        int left = 0;
        // right point = length - 1;
        int len = height.length;
        int right = len -1;
        // then we can calculate maxarea while R point > L point
        while(right > left){
            maxarea = Math.max(maxarea,Math.min(height[right],height[left]) * (right - left));
            // in the case if L is higher than we move right side
            if(height[left]> height[right])
                right--;
            else
                left++;
        }
        return maxarea;
    }
}
