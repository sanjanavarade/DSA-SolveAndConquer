class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> frequency =new HashMap<>();

        for(char c :s.toCharArray()){
            if(frequency.containsKey(c)){
                frequency.put(c, frequency.get(c)+1);
            }else{
                frequency.put(c,1);
            }
        }

        for(char c:t.toCharArray()){
            if(!frequency.containsKey(c)){
                return false;
            }else if(frequency.get(c)==1){
                frequency.remove(c);
            }else{
                frequency.put(c,frequency.get(c)-1);
            }
        }
        return frequency.isEmpty();
    }
}