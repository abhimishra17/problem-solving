import java.util.HashMap;

public class duplicate2 {
  public static void main(String[] args) {
    // Initialize the array and the value of k
    int[] nums = {1, 2, 3, 1}; // You can modify this array to test different cases
    int k = 3; // Example value of k

    // Create an instance of the Solution class
    Solution solution = new Solution();
    
    // Call the containsNearbyDuplicate method and store the result
    boolean result = solution.containsNearbyDuplicate(nums, k);
    
    // Output the result
    if(result) {
      System.out.println("The array contains nearby duplicates within k distance.");
    } else {
      System.out.println("No nearby duplicates found within k distance.");
    }
  }
}
class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
      HashMap<Integer,Integer>map=new HashMap<>();
      for(int i=0;i<nums.length;i++){
        if(map.containsKey(nums[i])){
          int j=map.get(nums[i]);
          if(Math.abs(i-j)<=k)
          return true;
        }
        map.put(nums[i],i);
      }
      return false;
  }
}
