class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        if(n==0||n==1){
            return n;
        }
        int curr=1;
        int max=1;
        for(int i=0;i<n-1;i++){
           if(nums[i]+1==nums[i+1]){
            curr++;
            if(curr>max){
                max=curr;
            }        

           }
           else if(nums[i]==nums[i+1]){
            }
           else{
            curr=1;
           }
        }

     return max;   
    }
}
