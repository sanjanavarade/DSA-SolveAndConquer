class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> Alphabets= new HashSet<>();
        for(char ch='a'; ch<='z'; ch++){
            Alphabets.add(ch);
        }
        for(int i=0;i<sentence.length();i++){
            Alphabets.remove(sentence.charAt(i));
            if(Alphabets.isEmpty()){
                return true;
            }
        }
        return false;
    }
}