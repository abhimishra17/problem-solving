class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        String str=s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }


      return true;  
    }
}
