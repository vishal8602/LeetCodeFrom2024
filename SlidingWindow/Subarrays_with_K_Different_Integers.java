package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subarray(nums, k) - subarray(nums, k - 1);
    }

    public int subarray(int[] nums, int k) {
        int front = 0, back = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (back < nums.length) {
            if (map.size() < k || map.get(nums[back]) != null) {
                count += (back - front + 1);
                map.put(nums[back], map.getOrDefault(nums[back], 0) + 1);
                back++;
            } else {
                map.put(nums[front], map.get(nums[front]) - 1);
                if (map.get(nums[front]) == 0) {
                    map.remove(nums[front]);
                }
                front++;
            }
        }
        return count;
    }
}

public class Subarrays_with_K_Different_Integers {
    public static void main(String[] args) {
        int []nums=new int[]{1,2,1,2,3};
        int k=2;
        int result=new Solution().subarraysWithKDistinct(nums,k);
        System.out.println(result);
    }
    
}
