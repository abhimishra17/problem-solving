class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>>res=new ArrayList<>();
        Map<String,List<String>>map=new HashMap<>();
        for (String str:strs){
            String pattern=fnGeneratePatt(str);
            if(map.containsKey(pattern)){
                map.get(pattern).add(str);
            }
            else{
                List<String>newList=new ArrayList<>();
                newList.add(str);
                map.put(pattern,newList);
            }
        }
        res.addAll(map.values());
        return res;
        
    }

    public static String fnGeneratePatt(String str){
        int[]arr=new int[26];
        for(char c:str.toCharArray()){
            arr[c-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            sb.append((char)('a'+i));
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
