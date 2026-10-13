class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();

        for(int i =0; i<s.length(); i++){
            char original = s.charAt(i);
            char replace =  t.charAt(i);

            if(map.containsKey(original)){
                if(map.get(original) != replace) return false;
            }else{ 
                if(map.containsValue(replace)) return false;
                map.put(original,replace);
            }     
        }
        return true;
    }
}