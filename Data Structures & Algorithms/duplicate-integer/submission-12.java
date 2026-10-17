class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n=nums.length;
        HashSet<Integer> map=new HashSet<>();
        for(int x:nums){
            map.add(x);
        }
       return map.size()<n;
    }
}