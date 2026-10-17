class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer>map=new HashMap<>();
        for(char x:s.toCharArray()){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(char y:t.toCharArray()){
            if(map.containsKey(y)){
                if(map.get(y)>0){
                    if(map.get(y)>0){
                    map.put(y,map.get(y)-1);}
                    if(map.get(y)==0){
                        map.remove(y);

                    }
                }
            }
            else{
                return false;
            }
        }

    return map.size()==0;
    }
}
