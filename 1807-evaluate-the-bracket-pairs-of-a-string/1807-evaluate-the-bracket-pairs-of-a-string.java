class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();

        for(List<String> ls : knowledge){
            map.put(ls.get(0),ls.get(1));
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c == '('){
                int st = i+1;
                while(s.charAt(i) != ')') i++ ;
                String key = s.substring(st,i);
                
                if(map.containsKey(key)) sb.append(map.get(key));
                else sb.append("?");
            }
            else sb.append(c);
        }
        return sb.toString();
    }
}