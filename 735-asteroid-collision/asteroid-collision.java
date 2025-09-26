class Solution {
    public int[] asteroidCollision(int[] asteroids) {
         Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];

            if (curr > 0) {
                // Positive asteroid, just push
                stack.push(curr);
            } else {
                // Negative asteroid: check for collisions
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(curr)) {
                    stack.pop(); // smaller positive asteroid destroyed
                }

                if (!stack.isEmpty() && stack.peek() == Math.abs(curr)) {
                    // both destroy each other
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    // no collision, push current negative asteroid
                    stack.push(curr);
                }
            }
        }

        // Convert stack to array
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}