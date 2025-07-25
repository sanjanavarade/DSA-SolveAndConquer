class Solution {
    public String removeOuterParentheses(String s) {
       int sum=0;int start=0;
       int end=0;
       StringBuilder res= new StringBuilder();
       while(end<s.length()){
        if(s.charAt(end) == '(') sum++;
        else sum--;

        if(sum==0){
            res.append(s.substring(start + 1, end));
            start = end+1;
        }
        end++;
       }
       return res.toString();
    }
}