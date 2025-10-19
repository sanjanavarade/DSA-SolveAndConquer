class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<>();
        solve(n, n, "", l);
        return l;
    }

    private void solve(int open, int close, String op, List<String> l) {
        if(open == 0 && close == 0) {
            l.add(op);
            return;
        }
        if(open > 0) {
            solve(open - 1, close, op + "(", l);
        }
        if(close > open) {
            solve(open, close - 1, op + ")", l);
        }
    }
}