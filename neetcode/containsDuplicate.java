/*
Approach 1
 */
class Solution {
    //Only Implmentation part is here
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniques = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (uniques.contains(nums[i])) {
                return true;
            }
            uniques.add(nums[i]);
        }
        return false;
    }
}

//Time : O(n)
//Space: O(n)

/*
Approach 2
 */
public class Solution {
    public boolean hasDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}


//Time : O(n)
//Space: O(n)