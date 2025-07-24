class Solution {
    public int minSteps(String s, String t) {
        int freqS[] = new int[26];
        int freqT[] = new int[26];
        int n1= s.length();
        int n2= t.length();
        int ans= 0;

        for(int i=0;i<n1;i++){
            freqS[s.charAt(i)-'a']++;
        }
        for(int i=0;i<n2;i++){
            freqT[t.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            ans += Math.abs(freqS[i]-freqT[i]);
        }
        return ans/2;
    }
}